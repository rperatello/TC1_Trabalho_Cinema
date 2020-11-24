package model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SalaTest {

    private static Sala s;
    public static ArrayList<Sala> listaSalas;

    @BeforeAll
    public static void criaObjeto(){
        s = new Sala();
        listaSalas = new ArrayList<Sala>();
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
    @ValueSource(strings = {"1633711111"})
    @DisplayName("Teste get/set de telefone")
    @Order(5)
    void getTelefone_sala(String tel) {
        s.setTelefone_sala(tel);
        assertEquals("(16)3371-1111", s.getTelefone_sala());
        s.setTelefone_sala("16997826643");
        assertEquals("(16)99782-6643", s.getTelefone_sala());
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("Teste get/set de acessível")
    @Order(6)
    void isAcessivel(boolean b) {
        s.setAcessivel(b);
        assertEquals(b, s.isAcessivel());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6})
    @DisplayName("Testa carrega salas")
    @Order(8)
    void carregaSalas(int posicao) {
        listaSalas = s.carregaSalas(listaSalas);

        ArrayList<Sala> salasPadrao = new ArrayList<>();

        salasPadrao.add(new Sala(1,20,"Sala 1","2D","1633511010",true));
        salasPadrao.add(new Sala(2,25,"Sala 2","2D","1633511020",true));
        salasPadrao.add(new Sala(3,20,"Sala 3","2D","1633511030", false));
        salasPadrao.add(new Sala(4,30,"Sala 4","3D","1633511040",true));
        salasPadrao.add(new Sala(5,15,"Sala 5","3D","1633511050", false));
        salasPadrao.add(new Sala(6,22,"Sala 6","2D","1633511060", true));
        salasPadrao.add(new Sala(7,25,"Sala 7","3D","1633511070", false));

        System.out.println(posicao);
        System.out.println(listaSalas.get(posicao).getNome());
        System.out.println(salasPadrao.get(posicao).getNome());
        assertAll("Teste carregar salas",
                () -> assertEquals(listaSalas.get(posicao).getCodigo(),salasPadrao.get(posicao).getCodigo()),
                () -> assertEquals(listaSalas.get(posicao).getCapacidade(),salasPadrao.get(posicao).getCapacidade()),
                () -> assertEquals(listaSalas.get(posicao).getNome(),salasPadrao.get(posicao).getNome()),
                () -> assertEquals(listaSalas.get(posicao).getTipo_de_exibicao(),salasPadrao.get(posicao).getTipo_de_exibicao()),
                () -> assertEquals(listaSalas.get(posicao).getTelefone_sala(),salasPadrao.get(posicao).getTelefone_sala()),
                () -> assertEquals(listaSalas.get(posicao).isAcessivel(),salasPadrao.get(posicao).isAcessivel())
        );
    }

    @Test
    @DisplayName("Teste buscar sala")
    @Order(9)
    void buscarSala() {
        ArrayList<Sala> salas = new ArrayList<>();
        Sala sala1 = new Sala(1,20,"Sala 1","2D","1633511010",true);

        salas = s.carregaSalas(salas);
        Sala sala2 = s.buscarSala(salas,1);

        assertAll("Teste buscar Filmes",
                () -> assertEquals(sala1.getCodigo(), sala2.getCodigo()),
                () -> assertEquals(sala1.getCapacidade(), sala2.getCapacidade()),
                () -> assertEquals(sala1.getNome(), sala2.getNome()),
                () -> assertEquals(sala1.getTipo_de_exibicao(), sala2.getTipo_de_exibicao()),
                () -> assertEquals(sala1.getTelefone_sala(), sala2.getTelefone_sala()),
                () -> assertEquals(sala1.isAcessivel(), sala2.isAcessivel())
        );
    }

    @ParameterizedTest
    @DisplayName("Teste deletar sala")
    @ValueSource(ints = {0,1,2,3,4,5})
    @Order(10)
    void deletaSala(int posicao) {
        ArrayList<Sala> salasPadrao = new ArrayList<>();

        listaSalas = s.carregaSalas(listaSalas);
        listaSalas = s.deletaSala(listaSalas, 3);

        salasPadrao.add(new Sala(1,20,"Sala 1","2D","1633511010",true));
        salasPadrao.add(new Sala(2,25,"Sala 2","2D","1633511020",true));
        salasPadrao.add(new Sala(4,30,"Sala 4","3D","1633511040",true));
        salasPadrao.add(new Sala(5,15,"Sala 5","3D","1633511050", false));
        salasPadrao.add(new Sala(6,22,"Sala 6","2D","1633511060", true));
        salasPadrao.add(new Sala(7,25,"Sala 7","3D","1633511070", false));

        assertAll("Teste deletar salas",
                () -> assertEquals(listaSalas.get(posicao).getCodigo(),salasPadrao.get(posicao).getCodigo()),
                () -> assertEquals(listaSalas.get(posicao).getCapacidade(),salasPadrao.get(posicao).getCapacidade()),
                () -> assertEquals(listaSalas.get(posicao).getNome(),salasPadrao.get(posicao).getNome()),
                () -> assertEquals(listaSalas.get(posicao).getTipo_de_exibicao(),salasPadrao.get(posicao).getTipo_de_exibicao()),
                () -> assertEquals(listaSalas.get(posicao).getTelefone_sala(),salasPadrao.get(posicao).getTelefone_sala()),
                () -> assertEquals(listaSalas.get(posicao).isAcessivel(),salasPadrao.get(posicao).isAcessivel())
        );
    }

    @Test
    @DisplayName("Teste incluir sala")
    @Order(7)
    void incluirSala() {
        ArrayList<Sala> salas = new ArrayList<>();
        ArrayList<Sala> salaPadrao = new ArrayList<>();
        Sala s = new Sala(1,20,"Sala 1","2D","1633511010",true);

        s.incluirSala(salas,s);
        salaPadrao.add(s);

        assertArrayEquals(salas.toArray(), salaPadrao.toArray());
    }

    @Test
    @DisplayName("Teste alterar sala")
    @Order(11)
    void alterarSala() {
        ArrayList<Sala> salaPadrao = new ArrayList<>();
        Sala newSala= new Sala(1,99,"Sala 1","3D","1633333333",false);

        listaSalas = s.carregaSalas(listaSalas);
        s.alterarSala(listaSalas,newSala);

        assertAll("Teste alterar sala",
                () -> assertEquals(listaSalas.get(0).getCodigo(),newSala.getCodigo()),
                () -> assertEquals(listaSalas.get(0).getCapacidade(),newSala.getCapacidade()),
                () -> assertEquals(listaSalas.get(0).getNome(),newSala.getNome()),
                () -> assertEquals(listaSalas.get(0).getTipo_de_exibicao(),newSala.getTipo_de_exibicao()),
                () -> assertEquals(listaSalas.get(0).getTelefone_sala(),newSala.getTelefone_sala()),
                () -> assertEquals(listaSalas.get(0).isAcessivel(),newSala.isAcessivel())
        );
    }
}