package model;

public class Filme {

    private int codigo, ano_de_lancamento;
    private String nome, diretor, ator;

    public Filme() {
    }

    public Filme(int codigo, int ano_de_lancamento, String nome, String diretor, String ator) {
        this.codigo = codigo;
        this.ano_de_lancamento = ano_de_lancamento;
        this.nome = nome;
        this.diretor = diretor;
        this.ator = ator;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAno_de_lancamento() {
        return ano_de_lancamento;
    }

    public void setAno_de_lancamento(int ano_de_lancamento) {
        this.ano_de_lancamento = ano_de_lancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getAtor() {
        return ator;
    }

    public void setAtor(String ator) {
        this.ator = ator;
    }
}
