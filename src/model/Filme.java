package model;

import java.util.ArrayList;
import java.util.Scanner;

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

    @Override
    public String toString() {
        return  "\ncodigo do filme = " + codigo +
                "\nano_de_lancamento = " + ano_de_lancamento +
                "\nnome = " + nome +
                "\ndiretor = " + diretor +
                "\nator = " + ator +
                "\n#######\n";
    }

    public ArrayList<Filme> incluirFilme(ArrayList<Filme> filmes){
        int codigo, ano_de_lancamento;
        String nome, diretor, ator;
        boolean checkCodigo = true;

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nInforme o códiogo do filme:");
        codigo = Integer.parseInt(scanner.nextLine());
        for (Filme f : filmes){
            if (f.codigo == codigo){
                System.out.println("Código já Cadastrado");
                checkCodigo = false;
                break;
            }
        }
        if (checkCodigo == true) {
            System.out.println("\nInforme o ano de lançamento do filme:");
            ano_de_lancamento = Integer.parseInt(scanner.nextLine());
            System.out.println("\nInforme o nome do filme:");
            nome = scanner.nextLine();
            System.out.println("\nInforme o nome do diretor filme:");
            diretor = scanner.nextLine();
            System.out.println("\nInforme o nome ator principal do filme:");
            ator = scanner.nextLine();

            Filme novoFilme = new Filme(codigo, ano_de_lancamento, nome, diretor, ator);
            filmes.add(novoFilme);
            System.out.println("\n ### Filme incluído com sucesso ### \n");
        } else {
            System.out.println("\n ### Filme não cadastrado ### \n");
        }
        return filmes;
    }

    public ArrayList<Filme> carregaFilmes(){
        ArrayList carregaArrayFilmes = new ArrayList();

        carregaArrayFilmes.add(new Filme(1,1999,"Matrix","Lilly Wachowski","Keanu Reeves"));
        carregaArrayFilmes.add(new Filme(2,2014,"Guardiões da Galáxia","James Gunn","Chris Pratt"));
        carregaArrayFilmes.add(new Filme(3,2018,"Hereditário","Ari Aster","Toni Collette"));
        carregaArrayFilmes.add(new Filme(4,2019,"Midsommar: O Mal Não Espera a Noite","Ari Aster"," Florence Pugh"));
        carregaArrayFilmes.add(new Filme(5,2017,"It: A Coisa","Andy Muschietti","Bill Skarsgård"));
        carregaArrayFilmes.add(new Filme(6,1988,"Os Fantasmas se Divertem","Tim Burton","Alec Baldwin"));
        carregaArrayFilmes.add(new Filme(7,1991,"A Família Addams","Barry Sonnenfeld"," Anjelica Huston"));

        return carregaArrayFilmes;
    }

    public Filme buscarFilme(ArrayList<Filme> filmes){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nInforme o códiogo do filme:");
        codigo = Integer.parseInt(scanner.nextLine());

        for (Filme f : filmes) {
            if (f.codigo == codigo){
                return f;
            }
        }
            return null;
    }

    public void deletaFilme(ArrayList<Filme> filmes, int codigo){
        for (Filme f : filmes) {
            if (f.codigo == codigo){
                filmes.remove(f);
                System.out.println("\n ### Filme deletado com sucesso ###\n");
                break;
            }
        }
    }

}
