package model;

public class Sala {

    private int codigo, capacidade;
    private String nome, tipo_de_exibicao, telefone_sala;
    private boolean acessivel;

    public Sala() {
    }

    public Sala(int codigo, int capacidade, String nome, String tipo_de_exibicao, String telefone_sala, boolean acessivel) {
        this.codigo = codigo;
        this.capacidade = capacidade;
        this.nome = nome;
        this.tipo_de_exibicao = tipo_de_exibicao;
        this.telefone_sala = telefone_sala;
        this.acessivel = acessivel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_de_exibicao() {
        return tipo_de_exibicao;
    }

    public void setTipo_de_exibicao(String tipo_de_exibicao) {
        this.tipo_de_exibicao = tipo_de_exibicao;
    }

    public String getTelefone_sala() {
        return telefone_sala;
    }

    public void setTelefone_sala(String telefone_sala) {
        this.telefone_sala = telefone_sala;
    }

    public boolean isAcessivel() {
        return acessivel;
    }

    public void setAcessivel(boolean acessivel) {
        this.acessivel = acessivel;
    }


}
