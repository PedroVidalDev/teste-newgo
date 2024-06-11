package application;

import java.util.Scanner;

import application.dto.SenhaDTO;
import domain.SenhaService;
import infrastructure.exception.Senha;

public class Menu {

    private SenhaService service = new SenhaService();

    public void exibirMenu(){
        Scanner sc = new Scanner(System.in);

        String conteudo;
        System.out.println("Digite a senha que deseja criar: ");
        conteudo = sc.nextLine();

        SenhaDTO senhaDTO = new SenhaDTO(conteudo);

        Senha senha = service.validarSenha(senhaDTO);
        
        System.out.println("Pontuacao da senha atual: " + senha.verificarForca());

        System.out.println("Deseja alterar a senha: 1) ");

        sc.close();
    }
}
