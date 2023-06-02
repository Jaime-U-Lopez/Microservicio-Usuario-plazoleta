package com.pragma.usuariomicroservice.domain.usecase.validaciones;

import com.pragma.usuariomicroservice.adapters.http.exceptions.ContraseñaErrada;
import com.pragma.usuariomicroservice.adapters.http.exceptions.NoEsMayorDeEdadException;
import com.pragma.usuariomicroservice.configuration.Constants;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;
import java.time.Period;

public class ValidacionesUsuario extends ValidacionesGenerales {

    public ValidacionesUsuario() {

    }

    public static  void validadFechaNacimiento(String fechaNacimiento){
        LocalDate fechaInicio = stringToDate(fechaNacimiento);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaInicio,fechaActual);
        if(periodo.getYears()<18){
            throw new NoEsMayorDeEdadException(Constants.NO_ES_MAYOR_DE_EDAD);
        }

    }


    public  static boolean validarPasswordEncritado(String password ){

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        if (BCrypt.checkpw(password, hashedPassword)) {
                return true;
        } else {

            throw new ContraseñaErrada(Constants.CONTRASEÑA_ERRADA);

        }

    }



}
