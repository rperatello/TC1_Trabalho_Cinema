package model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FilmeTest {

    private static Filme f;
    public static ArrayList<Filme> listaFilmes;


    @BeforeAll
    public static void criaObjeto(){
        f = new Filme();
    }
    public static void criaArrayList(){
        listaFilmes = new ArrayList<>();

    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Teste get/set de código")
    @Order(1)
    void getCodigo(int valor) {
        f.setCodigo(valor);
        assertEquals(valor, f.getCodigo());
    }

    @ParameterizedTest
    @ValueSource(ints = {1980,1990,2000})
    @DisplayName("Teste get/set do ano de lançamento")
    @Order(2)
    void getAno_de_lancamento(int ano) {
        f.setAno_de_lancamento(ano);
        assertEquals(ano, f.getAno_de_lancamento());
    }

    @ParameterizedTest
    @ValueSource(strings = {"MIB", "Código de Conduta","Liga da Justiça"})
    @DisplayName("Teste get/set de nome")
    @Order(3)
    void getNome(String nome) {
        f.setNome(nome);
        assertEquals(nome, f.getNome());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Roger", "Rogério","Mateus"})
    @DisplayName("Teste get/set de diretor")
    @Order(4)
    void getDiretor(String diretor) {
        f.setDiretor(diretor);
        assertEquals(diretor, f.getDiretor());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Roger", "Rogério","Mateus"})
    @DisplayName("Teste get/set de ator")
    @Order(5)
    void getAtor(String ator) {
        f.setAtor(ator);
        assertEquals(ator, f.getAtor());
    }

    @Test
    @DisplayName("Teste inclusao de filmes")
    @Order(6)
    void testIncluirFilme() {
        ArrayList<Filme> filmes = new ArrayList<>();
        ArrayList<Filme> filmesPadrao = new ArrayList<>();
        Filme filme = new Filme(50,1500,"Brasil","Portugal","Pedro Cabral");

        f.incluirFilme(filmes,filme);
        filmesPadrao.add(filme);

        assertArrayEquals(filmes.toArray(), filmesPadrao.toArray());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6})
    @DisplayName("Testa carrega filmes")
    @Order(8)
    void testCarregaFilmes(int posicao) {
        ArrayList<Filme> filmesPadrao = new ArrayList<>();

        listaFilmes = f.carregaFilmes(listaFilmes);

        filmesPadrao.add(new Filme(1,1999,"Matrix","Lilly Wachowski","Keanu Reeves"));
        filmesPadrao.add(new Filme(2,2014,"Guardiões da Galáxia","James Gunn","Chris Pratt"));
        filmesPadrao.add(new Filme(3,2018,"Hereditário","Ari Aster","Toni Collette"));
        filmesPadrao.add(new Filme(4,2019,"Midsommar: O Mal Não Espera a Noite","Ari Aster"," Florence Pugh"));
        filmesPadrao.add(new Filme(5,2017,"It: A Coisa","Andy Muschietti","Bill Skarsgård"));
        filmesPadrao.add(new Filme(6,1988,"Os Fantasmas se Divertem","Tim Burton","Alec Baldwin"));
        filmesPadrao.add(new Filme(7,1991,"A Família Addams","Barry Sonnenfeld","Anjelica Huston"));

        System.out.println(posicao);
        System.out.println(listaFilmes.get(posicao).nome);
        System.out.println(filmesPadrao.get(posicao).nome);
        assertAll("Teste carregar Filmes",
                () -> assertEquals(listaFilmes.get(posicao).codigo,filmesPadrao.get(posicao).codigo),
                () -> assertEquals(listaFilmes.get(posicao).ano_de_lancamento,filmesPadrao.get(posicao).ano_de_lancamento),
                () -> assertEquals(listaFilmes.get(posicao).nome,filmesPadrao.get(posicao).nome),
                () -> assertEquals(listaFilmes.get(posicao).diretor,filmesPadrao.get(posicao).diretor),
                () -> assertEquals(listaFilmes.get(posicao).ator,filmesPadrao.get(posicao).ator)
        );
    }

    @Test
    @DisplayName("Teste buscar filmes")
    @Order(7)
    void buscarFilme() {

        Filme filme2 = new Filme(5,2017,"It: A Coisa","Andy Muschietti","Bill Skarsgård");

        ArrayList<Filme> filmes = new ArrayList<>();
        filmes = f.carregaFilmes(filmes);

        Filme filme1 = f.buscarFilme(filmes,5);

        assertAll("Teste buscar Filmes",
                () -> assertEquals(filme1.codigo,filme2.codigo),
                () -> assertEquals(filme1.ano_de_lancamento,filme2.ano_de_lancamento),
                () -> assertEquals(filme1.nome,filme2.nome),
                () -> assertEquals(filme1.diretor,filme2.diretor),
                () -> assertEquals(filme1.ator,filme2.ator)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5})
    @DisplayName("Teste deleta filme")
    @Order(10)
    void deletaFilme(int posicao) {
        ArrayList<Filme> filmesPadrao = new ArrayList<>();

        listaFilmes = f.carregaFilmes(listaFilmes);
        f.deletaFilme(listaFilmes,5);

        filmesPadrao.add(new Filme(1,1999,"Matrix","Lilly Wachowski","Keanu Reeves"));
        filmesPadrao.add(new Filme(2,2014,"Guardiões da Galáxia","James Gunn","Chris Pratt"));
        filmesPadrao.add(new Filme(3,2018,"Hereditário","Ari Aster","Toni Collette"));
        filmesPadrao.add(new Filme(4,2019,"Midsommar: O Mal Não Espera a Noite","Ari Aster"," Florence Pugh"));
        filmesPadrao.add(new Filme(6,1988,"Os Fantasmas se Divertem","Tim Burton","Alec Baldwin"));
        filmesPadrao.add(new Filme(7,1991,"A Família Addams","Barry Sonnenfeld","Anjelica Huston"));

        assertAll("Teste deleta Filmes",
                () -> assertEquals(listaFilmes.get(posicao).codigo,filmesPadrao.get(posicao).codigo),
                () -> assertEquals(listaFilmes.get(posicao).ano_de_lancamento,filmesPadrao.get(posicao).ano_de_lancamento),
                () -> assertEquals(listaFilmes.get(posicao).nome,filmesPadrao.get(posicao).nome),
                () -> assertEquals(listaFilmes.get(posicao).diretor,filmesPadrao.get(posicao).diretor),
                () -> assertEquals(listaFilmes.get(posicao).ator,filmesPadrao.get(posicao).ator)
        );
    }

    @Test
    @DisplayName("Teste altera filme")
    @Order(9)
    void alteraFilme() {
        ArrayList<Filme> filmesPadrao = new ArrayList<>();
        Filme newFilme = new Filme(5,1500,"Brasil","Índios","Pedro Alvares Cabral");

        listaFilmes = f.carregaFilmes(listaFilmes);
        f.alteraFilme(listaFilmes,newFilme);

       assertAll("Teste altera Filmes",
                () -> assertEquals(listaFilmes.get(4).codigo,newFilme.codigo),
                () -> assertEquals(listaFilmes.get(4).ano_de_lancamento,newFilme.ano_de_lancamento),
                () -> assertEquals(listaFilmes.get(4).nome,newFilme.nome),
                () -> assertEquals(listaFilmes.get(4).diretor,newFilme.diretor),
                () -> assertEquals(listaFilmes.get(4).ator,newFilme.ator)
        );

    }
}