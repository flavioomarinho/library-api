package com.flaviomarinho.library.exception;

//Classe para lançamento das excessões
public class RuleBussinesException extends RuntimeException{
    public RuleBussinesException(String message) {
        super(message);
    }
}
