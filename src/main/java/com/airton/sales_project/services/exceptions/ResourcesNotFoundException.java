package com.airton.sales_project.services.exceptions;

public class ResourcesNotFoundException extends RuntimeException{

    public ResourcesNotFoundException(Object id){
        super("Resouce not found Id " + id);
    }

}
