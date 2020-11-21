package model;

import java.util.ArrayList;
import java.util.Scanner;

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

    @Override
    public String toString() {

        return  "\ncodigo da sala = " + codigo +
                "\ncapacidade = " + capacidade +
                "\nnome = " + nome +
                "\ntipo de exibição = " + tipo_de_exibicao +
                "\ntelefone da sala = " + telefone_sala +
                "\nacessivel = " + acessivel +
                "\n#######\n";
    }

    public ArrayList<Sala> carregaSalas(ArrayList<Sala> salas){
        Sala aux = new Sala();

        Sala s1 = new Sala(1,20,"Sala 1","2D","(16)3351-1010",true);
        Sala s2 = new Sala(2,25,"Sala 2","2D","(16)3351-1020",true);
        Sala s3 = new Sala(3,20,"Sala 3","2D","(16)3351-1030", false);
        Sala s4 = new Sala(4,30,"Sala 4","3D","(16)3351-1040",true);
        Sala s5 = new Sala(5,15,"Sala 5","3D","(16)3351-1050", false);
        Sala s6 = new Sala(6,22,"Sala 6","2D","(16)3351-1060", true);
        Sala s7 = new Sala(7,25,"Sala 7","3D","(16)3351-1070", false);

        salas = aux.incluirSala(salas,s1);
        salas = aux.incluirSala(salas,s2);
        salas = aux.incluirSala(salas,s3);
        salas = aux.incluirSala(salas,s4);
        salas = aux.incluirSala(salas,s5);
        salas = aux.incluirSala(salas,s6);
        salas = aux.incluirSala(salas,s7);

        return salas;
    }

    public Sala buscarSala(ArrayList<Sala> salas, Integer codigo){
        for (Sala s : salas) {
            if (s.codigo == codigo){
                return s;
            }
        }
        return null;
    }

    public ArrayList<Sala> deletaSala(ArrayList<Sala> salas, int codigo){
        for (Sala s : salas) {
            if (s.codigo == codigo){
                salas.remove(s);
                System.out.println("\n ### Filme deletado com sucesso ###\n");
                return salas;
            }
        }
        return salas;
    }

    public ArrayList<Sala> incluirSala(ArrayList<Sala> salas, Sala sala){
        for (Sala item : salas){
            if (item.getCodigo() == codigo){
                System.out.println("Sala não cadastrada - Código informa já existe!");
                return salas;
            }
        }
        salas.add(sala);
        //System.out.println("\n ### Sala incluída com sucesso ### \n");
        return salas;
    }

    public ArrayList<Sala> alterarSala(ArrayList<Sala> salas, Sala sala){
        for (Sala s : salas) {
            if (s.codigo == sala.codigo){
                s.setCapacidade(sala.getCapacidade());
                s.setNome(sala.getNome());
                s.setTipo_de_exibicao(sala.getTipo_de_exibicao());
                s.setTelefone_sala(sala.getTelefone_sala());
                s.setAcessivel(sala.isAcessivel());
                return salas;
            }
        }
        return salas;
    }
}
