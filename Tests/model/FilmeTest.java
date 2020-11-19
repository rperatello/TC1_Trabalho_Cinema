package model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FilmeTest {

    private static Filme f;

    @BeforeAll
    public static void criaObjeto(){
        f = new Filme();
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
    @Order(4)
    void getAtor(String ator) {
        f.setAtor(ator);
        assertEquals(ator, f.getAtor());
    }

    @Test
    void incluirFilme() {
    }

    @Test
    void carregaFilmes() {
    }

    @Test
    void buscarFilme() {
    }

    @Test
    void deletaFilme() {
    }

    @Test
    void alteraFilme() {
    }
}