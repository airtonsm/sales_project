package com.airton.sales_project.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(4),
    DELIVERED(5),
    CANCELED(5);

    private int code;

    private OrderStatus(int code){ // construtor
        this.code = code;
    }

    public int getCode(){ // recebe o valor da enumeração.
        return code;
    }


    public static OrderStatus valueOf(int code){ // converte um integer em enumeração, para poder ser recebido valor na classe Order
        for(OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }


}
