package com.airton.sales_project.resources.exceptions;

import com.airton.sales_project.services.exceptions.ResourcesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice //intercepta as excessões para o objeto tratar a excessão
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundException.class) //intercepta qualquer excessão do tipo instanciado
    public ResponseEntity<StandarError> resourceNotFound(ResourcesNotFoundException e,
                                                         HttpServletRequest request){
        String error = "Resouce not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
