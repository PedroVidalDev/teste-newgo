package infrastructure.exception;

import application.dto.SenhaDTO;

public class Senha {
    private String conteudo;
    private String[] sequencias = {"abc", "12345", "qwert", "asdfg"};

    public Senha(String conteudo){
        this.conteudo = conteudo;
    }

    public Senha(SenhaDTO dto){
        this.conteudo = dto.senha();
    }

    public float verificarForca(){
        float pontuacao = 75;
        int pontuacaoPorComprimento = 0;
        int pontuacaoPorRepeticao = 5;
        int pontuacaoPorSequencia = 5;

        String senha = this.conteudo;

        pontuacaoPorComprimento = (15 * (senha.length())) / 30;

        for (String sequencia : sequencias) {
            if(senha.contains(sequencia)){
                System.out.println("apareceu sequencia " + sequencia);
                pontuacaoPorSequencia--;
            }
        }

        System.out.println(senha.length());
        System.out.println(pontuacaoPorComprimento);

        System.out.println(pontuacaoPorSequencia);

        pontuacao = pontuacao + pontuacaoPorComprimento + pontuacaoPorRepeticao + pontuacaoPorSequencia;

        return pontuacao;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }

    public String getConteudo(){
        return conteudo;
    }
}
