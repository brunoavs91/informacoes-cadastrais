package com.boaentrega.informacoescadastrais.exception;

public class BusinnesException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BusinnesException(String msg){
        super(msg);
    }

    public BusinnesException(String msg, Throwable cause){
        super(msg,cause);
    }
}
