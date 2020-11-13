package model;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();

        int opMenu, opSubmenuFilmes, opSubmenuSalas;


        opMenu = menu.menuPrincipal();

        while(opMenu != 3) {
            switch (opMenu) {
                case 1:
                    opSubmenuFilmes = menu.submenuFilmes();
                    break;

                case 2:
                    opSubmenuSalas = menu.submenuSalas();
                    break;
            }

            opMenu = menu.menuPrincipal();
        }

    }
}
