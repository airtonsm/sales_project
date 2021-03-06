package com.airton.sales_project.services;


import com.airton.sales_project.entities.User;
import com.airton.sales_project.repositories.UserRepository;
import com.airton.sales_project.services.exceptions.DataBaseException;
import com.airton.sales_project.services.exceptions.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return  repository.findAll(); // vai no banco e trás o usuárip
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return  obj.orElseThrow(() -> new ResourcesNotFoundException(id)); //retorna objeto do tipo User que está contido no 'obj'
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){

        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){ // captura específca de excessão
            throw new ResourcesNotFoundException(id); // importando excessão construida
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        try {
            User entity = repository.getOne(id); // instancia user, sem ir no banco, para ser monitorado e trabalhar com ele, para depois efetuar alguam ação
            updateData(entity, obj);
            return repository.save(entity);
        }catch(EntityNotFoundException e){
            throw new ResourcesNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }

}
