package model;

import util.CarregarDados;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Filme filme = new Filme();

        int opMenu, opSubmenuFilmes = 0, opSubmenuSalas = 0;

        ArrayList<Filme> filmes;

        /*USAR PARA CARREGAR UMA LISTA DE FILMES PRÉ CADASTRADOS*/
        filmes = filme.carregaFilmes();

        opMenu = menu.menuPrincipal();

        while(opMenu != 3) {
            switch (opMenu) {
                case 1:
                    opSubmenuFilmes = menu.submenuFilmes();
                    opSubmenuSalas=0;
                    switch (opSubmenuFilmes){
                        case 1:
                            for(Filme f : filmes){
                                System.out.println(f.toString());
                            }
                            break;

                        case 3:
                            filmes = filme.incluirFilme(filmes);
                            break;
                    }
                    break;

                case 2:
                    opSubmenuSalas = menu.submenuSalas();
                    opSubmenuFilmes =0;
                    break;
            }
            opMenu = menu.menuPrincipal();
        }

    }
}
