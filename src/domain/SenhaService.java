package domain;

import application.dto.SenhaDTO;
import infrastructure.entities.ErroPersonalizado;
import infrastructure.exception.Senha;

public class SenhaService {
    public Senha validarSenha(SenhaDTO dto){
        String senha = dto.senha();
        
        if(senha.length() < 10){
            throw new ErroPersonalizado("Senha deve ter no minimo 10 caracteres");
        }

        if(senha.length() > 30){
            throw new ErroPersonalizado("Senha deve ter no maximo 30 caracteres.");
        }

        // if(!senha.matches("A-Z")){
        //     throw new ErroPersonalizado("Senha deve conter ao menos um letra maiuscula.");
        // }

        // if(!senha.matches("a-z")){
        //     throw new ErroPersonalizado("Senha deve conter ao menos um letra minuscula.");
        // }

        Senha senhaCriada = new Senha(dto);

        return senhaCriada;
    }
}
