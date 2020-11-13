package model;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Filme filme = new Filme();
        Filme f;

        int opMenu, opSubmenuFilmes = 0, opSubmenuSalas = 0;

        ArrayList<Filme> filmes;

        /*CARREGA UMA LISTA DE FILMES PRÉ CADASTRADOS*/
        filmes = filme.carregaFilmes();

        opMenu = menu.menuPrincipal();

        while(opMenu != 3) {
            switch (opMenu) {
                case 1:
                    opSubmenuFilmes = menu.submenuFilmes();
                    opSubmenuSalas=0;
                    switch (opSubmenuFilmes){
                        case 1:
                            for(Filme i : filmes){
                                System.out.println(i.toString());
                            }
                            break;

                        case 2:
                            f = filme.buscarFilme(filmes);
                            if (f != null){
                                System.out.println(f.toString());
                            } else {
                                System.out.println("\n### Filme não encontrado ### \n");
                            }
                            break;

                        case 3:
                            filmes = filme.incluirFilme(filmes);
                            break;

                        case 4:
                            f = filme.buscarFilme(filmes);
                            filme.alteraFilme(filmes, f);
                            break;

                        case 5:
                            Scanner scanner = new Scanner(System.in);
                            String confirma;
                            f = filme.buscarFilme(filmes);
                            if (f != null){
                                System.out.println(f.toString());
                                System.out.println("\nConfirma exclusão? (s/n)");
                                confirma = scanner.nextLine();
                                if(confirma.equals("s") || confirma.equals("S")){
                                    filme.deletaFilme(filmes,f.getCodigo());
                                } else {
                                    System.out.println("\n### Operação Cancelada ### \n");
                                }
                            } else {
                                System.out.println("\n### Filme não encontrado ### \n");
                            }
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
