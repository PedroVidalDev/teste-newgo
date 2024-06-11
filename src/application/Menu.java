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

        String opcao;
        System.out.println("Deseja alterar a senha: 1) Sim 2) Nao ");
        opcao = sc.nextLine();
        if(opcao.equals("1")){
            System.out.println("Digite a nova senha: ");
            String novaSenhaString;
            novaSenhaString = sc.nextLine();
            SenhaDTO novaSenhaDTO = new SenhaDTO(novaSenhaString);

            Senha novaSenha = service.validarSenha(novaSenhaDTO);
            senha.setConteudo(novaSenha.getConteudo());
        }

        if(opcao.equals("2")){

        }

        else{
            System.out.println("Escolha invalida.");
        }

        sc.close();
    }
}
