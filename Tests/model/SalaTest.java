package model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SalaTest {

    private static Sala s;

    @BeforeAll
    public static void criaObjeto(){
        s = new Sala();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Teste get/set de código")
    @Order(1)
    void getCodigo(int valor) {
        s.setCodigo(valor);
        assertEquals(valor, s.getCodigo());
    }

    @ParameterizedTest
    @ValueSource(ints = {10,20,30})
    @DisplayName("Teste get/set de capacidade")
    @Order(2)
    void getCapacidade(int valor) {
        s.setCapacidade(valor);
        assertEquals(valor, s.getCapacidade());

    }

    @ParameterizedTest
    @ValueSource(strings = {"Sala A", "Sala B","Sala C"})
    @DisplayName("Teste get/set do nome")
    @Order(3)
    void getNome(String nome) {
        s.setNome(nome);
        assertEquals(nome, s.getNome());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2D", "3D"})
    @DisplayName("Teste get/set do tipo de exibição")
    @Order(4)
    void getTipo_de_exibicao(String tipo) {
        s.setTipo_de_exibicao(tipo);
        assertEquals(tipo, s.getTipo_de_exibicao());
    }

    @ParameterizedTest
    @ValueSource(strings = {"(16)3371-1111", "(16)3371-1112"})
    @DisplayName("Teste get/set de telefone")
    @Order(5)
    void getTelefone_sala(String tel) {
        s.setTelefone_sala(tel);
        assertEquals(tel, s.getTelefone_sala());
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("Teste get/set de acessível")
    @Order(6)
    void isAcessivel(boolean b) {
        s.setAcessivel(b);
        assertEquals(b, s.isAcessivel());
    }

    @Test
    void carregaSalas() {
    }

    @Test
    void buscarSala() {
    }

    @Test
    void deletaSala() {
    }

    @Test
    void incluirSala() {
    }

    @Test
    void alterarSala() {
    }
}