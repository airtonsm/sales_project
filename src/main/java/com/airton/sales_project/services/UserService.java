package com.airton.sales_project.services;


import com.airton.sales_project.entities.User;
import com.airton.sales_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return  obj.get(); //retorna objeto do tipo User que está contido no 'obj'
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User obj){
        User entity = repository.getOne(id); // instancia user, sem ir no banco, para ser monitorado e trabalhar com ele, para depois efetuar alguam ação
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }

}
