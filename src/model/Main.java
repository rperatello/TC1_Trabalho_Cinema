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
        ArrayList<Filme> filmes = new ArrayList<>();
        ArrayList<Sala> salas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int opMenu, opSubmenuFilmes = 0, opSubmenuSalas = 0;

        int codigo, ano_de_lancamento, capacidade;
        String nome, diretor, ator, tipo_de_exibicao, telefone_sala;
        boolean acessivel, checkCodigo = true;

        /*CARREGA UMA LISTA DE FILMES PRÉ CADASTRADOS*/
        filmes = filme.carregaFilmes(filmes);

        /*CARREGA UMA LISTA DE SALAS PRÉ CADASTRADAS*/
        salas = sala.carregaSalas(salas);

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
                            System.out.println("\nInforme o código do filme:");
                            codigo = Integer.parseInt(scanner.nextLine());
                            f = filme.buscarFilme(filmes, codigo);
                            if (f != null){
                                System.out.println(f.toString());
                            } else {
                                System.out.println("\n### Filme não encontrado ### \n");
                            }
                            break;
                        case 3:
                            checkCodigo = true;
                            System.out.println("\nInforme o código do filme:");
                            codigo = Integer.parseInt(scanner.nextLine());
                            for (Filme itemFilme : filmes){
                                if (itemFilme.getCodigo() == codigo){
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
                                filmes = filme.incluirFilme(filmes, novoFilme);
                            }
                            break;
                        case 4:
                            System.out.println("\nInforme o código do filme:");
                            codigo = Integer.parseInt(scanner.nextLine());
                            f = filme.buscarFilme(filmes,codigo);
                            if (f != null){
                                System.out.println("\n*Informe os novos dados de filme*");
                                System.out.println("\nInforme o ano de lançamento do filme:");
                                f.setAno_de_lancamento(Integer.parseInt(scanner.nextLine()));
                                System.out.println("\nInforme o nome do filme:");
                                f.setNome(scanner.nextLine());
                                System.out.println("\nInforme o nome do diretor filme:");
                                f.setDiretor(scanner.nextLine());
                                System.out.println("\nInforme o nome ator principal do filme:");
                                f.setAtor(scanner.nextLine());
                                filme.alteraFilme(filmes, f);
                            } else {
                                System.out.println("\n### Filme não encontrado ### \n");
                            }
                            break;
                        case 5:
                            System.out.println("\nInforme o código do filme:");
                            codigo = Integer.parseInt(scanner.nextLine());
                            String confirma;
                            f = filme.buscarFilme(filmes, codigo);
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
                            System.out.println("\nInforme o código da sala:");
                            codigo = Integer.parseInt(scanner.nextLine());
                            s = sala.buscarSala(salas, codigo);
                            if (s != null){
                                System.out.println(s.toString());
                            } else {
                                System.out.println("\n### Sala não encontrada ### \n");
                            }
                            break;
                        case 3:
                            checkCodigo = true;
                            System.out.println("\nInforme o código da sala:");
                            codigo = Integer.parseInt(scanner.nextLine());
                            for (Sala item : salas){
                                if (item.getCodigo() == codigo){
                                    System.out.println("Código já Cadastrado");
                                    checkCodigo = false;
                                    break;
                                }
                            }
                            if (checkCodigo == true) {
                                System.out.println("\nInforme a capacidade da sala:");
                                capacidade = Integer.parseInt(scanner.nextLine());
                                System.out.println("\nInforme o nome da sala:");
                                nome = scanner.nextLine();
                                System.out.println("\nInforme o tipo de exibição da sala:");
                                tipo_de_exibicao = scanner.nextLine();
                                System.out.println("\nInforme o telefone da sala:");
                                telefone_sala = scanner.nextLine();
                                System.out.println("\nInforme se existe acessibilidade na sala:");
                                acessivel = Boolean.parseBoolean(scanner.nextLine());
                                Sala novaSala = new Sala(codigo, capacidade,nome,tipo_de_exibicao,telefone_sala,acessivel);
                                salas = sala.incluirSala(salas, novaSala);
                                System.out.println("\n ### Sala cadastrada ### \n");
                            } else {
                                System.out.println("\n ### Nova Sala não cadastrada ### \n");
                            }
                            break;
                        case 4:
                            System.out.println("\nInforme o código da sala:");
                            codigo = Integer.parseInt(scanner.nextLine());
                            s = sala.buscarSala(salas, codigo);
                            if (s != null){
                                System.out.println("\n*Insira os novos dados*");
                                System.out.println("\nInforme a capacidade da sala:");
                                s.setCapacidade(Integer.parseInt(scanner.nextLine()));
                                System.out.println("\nInforme o nome da sala:");
                                s.setNome(scanner.nextLine());
                                System.out.println("\nInforme o tipo de exibição da sala:");
                                s.setTipo_de_exibicao(scanner.nextLine());
                                System.out.println("\nInforme o telefone da sala:");
                                s.setTelefone_sala(scanner.nextLine());
                                System.out.println("\nInforme se existe acessibilidade na sala:");
                                s.setAcessivel(Boolean.parseBoolean(scanner.nextLine()));
                                salas = sala.alterarSala(salas, s);
                            } else {
                                System.out.println("\n### Sala não encontrada ### \n");
                            }
                            break;
                        case 5:
                            System.out.println("\nInforme o código da sala:");
                            codigo = Integer.parseInt(scanner.nextLine());
                            String confirma;
                            s = sala.buscarSala(salas, codigo);
                            if (s != null){
                                System.out.println(s.toString());
                                System.out.println("\nConfirma exclusão? (s/n)");
                                confirma = scanner.nextLine();
                                if(confirma.equals("s") || confirma.equals("S")){
                                    sala.deletaSala(salas, s.getCodigo());
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
