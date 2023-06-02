package com.pragma.usuariomicroservice.adapters.http.exceptions;

public class ContraseñaErrada extends RuntimeException {

    public ContraseñaErrada(String message) {
        super(message);
    }

}
