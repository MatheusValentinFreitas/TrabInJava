package utilitarios;

import estruturas.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.Console;
import java.io.IOException;

public class Controlador {

    private Controlador() {
    }

    public static int menu() {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Cadastrar usuário.");
        System.out.println("2 - Excluir usuário.");
        System.out.println("3 - Listar usuário.");
        System.out.println("4 - Pesquisar.");
        System.out.println("5 - Alterar.");
        System.out.println("6 - Seguir.");
        System.out.println("7 - Cancelar seguir.");
        System.out.println("0 - Sair.");

        opcao = scanner.nextInt();

        return opcao;
    }

    public static void imprimeLista(ArrayList<Usuario> array) {

        System.out.println("Impressão lista de Usuarios.");
        System.out.println();

        if (!vazioLista(array)) {
            for (Usuario usuario : array) {
                System.out.println("Login: " + usuario.getLogin() + " | Nome: " + usuario.getNome());
                System.out.println();
            }
        } else {
            System.out.println("A lista esta vazia.");
        }
    }

    public static void pesquisarUsuario(ArrayList<Usuario> array) {
        if (!vazioLista(array)) {

            Scanner scanner = new Scanner(System.in);
            String loginBusca;
            Boolean achou = false;

            System.out.print("Digite o login de usuario que deja procurar: ");
            loginBusca = scanner.nextLine();

            for (Usuario usuario : array) {
                if (loginBusca.equals(usuario.getLogin())) {
                    achou = true;
                    System.out.println("Nome: " + usuario.getNome());
                    System.out.println("Email: " + usuario.getEmail());
                    System.out.println("Data de nascimento: " + usuario.getDataNasc());
                    break;
                }
            }

            if (!achou) {
                System.out.println("Usuario não encontrado");
            }
        } else {
            System.out.println("Não ha o que procurar.");
        }
    }

    public static void excluirUsuario(ArrayList<Usuario> array) {
        if (!vazioLista(array)) {

            Scanner scanner = new Scanner(System.in);
            String loginBusca;
            Boolean achou = false;

            System.out.println("Digite o login de usuario que deja remover: ");
            loginBusca = scanner.nextLine();

            Usuario removeUser;

            for (int i = 0; i < array.size(); i++) {

                removeUser = array.get(i);

                if (loginBusca.equals(removeUser.getLogin())) {
                    achou = true;
                    array.remove(i);
                    break;
                }
            }

            if (!achou) {
                System.out.println("Usuario não encontrado");
            } else {
                System.out.println("Usuario removido com sucesso.");
            }
        } else {
            System.out.println("Não ha o que procurar.");
        }
    }

    public static void alteraUsuario(ArrayList<Usuario> array) {

        if (!vazioLista(array)) {

            Scanner scanner = new Scanner(System.in);
            String loginBusca;
            Boolean achou = false;

            System.out.println("Digite o login de usuario que deja alterar: ");
            loginBusca = scanner.nextLine();

            for (Usuario usuario : array) {
                if (loginBusca.equals(usuario.getLogin())) {
                    achou = true;
                    System.out.print("Digite o novo Nome: ");
                    usuario.setNome(scanner.nextLine());
                    System.out.print("Digite o novo Email: ");
                    usuario.setEmail(scanner.nextLine());
                    System.out.print("Digite a nova Data de nascimento: ");
                    usuario.setDataNasc(scanner.nextLine());
                    break;
                }
            }

            if (!achou) {
                System.out.println("Usuario não encontrado");
            }
        } else {
            System.out.println("Não ha o que alterar.");
        }
    }

    public static void cadastraUsuario(ArrayList<Usuario> array) {

        Scanner scanner = new Scanner(System.in);

        String nome;
        String email;
        String dataNasc;
        String login;

        System.out.print("Digite seu nome: ");
        nome = scanner.nextLine();

        System.out.print("Digite seu email: ");
        email = scanner.nextLine();

        System.out.print("Digite sua data de nascimento: ");
        dataNasc = scanner.nextLine();

        System.out.print("Digite seu login: ");
        login = scanner.nextLine();

        Usuario newUser = new Usuario(nome, email, dataNasc, login);

        array.add(newUser);
    }

    public static void seguirUsuario(ArrayList<Usuario> array) {

        Scanner scanner = new Scanner(System.in);

        String buscaLogin;

        Coletor usuario1Col;
        Coletor usuario2Col;

        Usuario usuario;

        if (array.size() >= 2) {
            System.out.print("Digite o login do usuario a ser seguido: ");
            buscaLogin = scanner.nextLine();
            usuario1Col = coletaUsuario(array, buscaLogin);
            System.out.print("Digite o login do usuario que ira seguilo: ");
            buscaLogin = scanner.nextLine();
            usuario2Col = coletaUsuario(array, buscaLogin);

            if (usuario1Col.existe && usuario2Col.existe) {
                usuario = array.get(usuario1Col.posicao);
                usuario.setSeguidores(usuario2Col.login);
            } else {
                if (!usuario1Col.existe && !usuario2Col.existe) {
                    System.out.println("Nenhum dos dois usuarios existem.");
                } else {
                    if (!usuario1Col.existe) {
                        System.out.println("O usuario " + usuario1Col.login + " não existe.");
                    } else {
                        System.out.println("O usuario " + usuario2Col.login + " não existe.");
                    }
                }
            }
        } else {
            System.out.println("Não ha usuarios suficientes para que se possam haver seguidores.");
        }
    }

    public static void cancelaSeguirUsuario(ArrayList<Usuario> array) {

        Scanner scanner = new Scanner(System.in);

        String buscaLogin;

        Coletor usuario1Col;
        Coletor usuario2Col;

        Usuario usuario;

        if (array.size() >= 2) {
            System.out.print("Digite o login do usuario a ser parado de seguir: ");
            buscaLogin = scanner.nextLine();
            usuario1Col = coletaUsuario(array, buscaLogin);
            System.out.print("Digite o login do usuario que ira cancelalo: ");
            buscaLogin = scanner.nextLine();
            usuario2Col = coletaUsuario(array, buscaLogin);

            if (usuario1Col.existe && usuario2Col.existe) {
                usuario = array.get(usuario1Col.posicao);

                Coletor seguidor = usuario.getSeguidor(usuario2Col.login);

                if (seguidor.existe) {
                    usuario.removeSeguidor(seguidor.posicao);
                    System.out.println("O usuario " + usuario2Col.login + " deixou de seguir " + usuario1Col.login);
                } else {
                    System.out.println(
                            "O usuario " + usuario2Col.login + " não é seguidor do usuario " + usuario1Col.login);
                }
            } else {
                if (!usuario1Col.existe && !usuario2Col.existe) {
                    System.out.println("Nenhum dos dois usuarios existem.");
                } else {
                    if (!usuario1Col.existe) {
                        System.out.println("O usuario " + usuario1Col.login + " não existe.");
                    } else {
                        System.out.println("O usuario " + usuario2Col.login + " não existe.");
                    }
                }
            }
        } else {
            System.out.println("Não ha usuarios suficientes para que se possam haver seguidores.");
        }
    }

    public static Coletor coletaUsuario(ArrayList<Usuario> array, String buscaLogin) {

        Coletor info;
        Usuario usuario;

        boolean existe = false;
        int posicao = -1;

        for (int i = 0; i < array.size(); i++) {

            usuario = array.get(i);

            if (buscaLogin.equals(usuario.getLogin())) {
                existe = true;
                posicao = i;
                break;
            }
        }

        info = new Coletor(buscaLogin, existe, posicao);

        return info;
    }

    public static boolean vazioLista(ArrayList<Usuario> array) {
        if (array.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void continua() {
        System.out.println();
        System.out.println("Pressione qualquer tecla para continuar...");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Aguarda a entrada do usuário

        System.out.println("Continuando o programa");
    }

    public static void limpaTela() throws IOException, InterruptedException {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
        // Limpa a tela no windows, no linux e no MacOS
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }
}
