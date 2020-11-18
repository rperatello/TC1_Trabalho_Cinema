package model;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Filme filme = new Filme();
        Sala sala = new Sala();
        Filme f;
        Sala s;

        int opMenu, opSubmenuFilmes = 0, opSubmenuSalas = 0;

        /*CARREGA UMA LISTA DE FILMES PRÉ CADASTRADOS*/
        ArrayList<Filme> filmes = filme.carregaFilmes();

        /*CAREEGA UMA LISTA DE SALAS PRÉ CADASTRADAS*/
        ArrayList<Sala> salas = sala.carregaSalas();

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

                    switch (opSubmenuSalas) {
                        case 1:
                            for (Sala i : salas) {
                                System.out.println(i.toString());
                            }
                            break;

                        case 2:
                            s = sala.buscarSala(salas);
                            if (s != null){
                                System.out.println(s.toString());
                            } else {
                                System.out.println("\n### Sala não encontrada ### \n");
                            }
                            break;

                        case 3:
                            salas = sala.incluirSala(salas);
                            break;

                        case 4:
                            s = sala.buscarSala(salas);
                            sala.alterarSala(salas, s);
                            break;

                        case 5:
                            Scanner scanner = new Scanner(System.in);
                            String confirma;
                            s = sala.buscarSala(salas);
                            if (s != null){
                                System.out.println(s.toString());
                                System.out.println("\nConfirma exclusão? (s/n)");
                                confirma = scanner.nextLine();
                                if(confirma.equals("s") || confirma.equals("S")){
                                    sala.deletaSala(salas,s.getCodigo());
                                } else {
                                    System.out.println("\n### Operação Cancelada ### \n");
                                }
                            } else {
                                System.out.println("\n### Filme não encontrado ### \n");
                            }
                            break;
                    }
                    break;
            }
            opMenu = menu.menuPrincipal();
        }

    }
}
