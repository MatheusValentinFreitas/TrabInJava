package utilitarios;

import estruturas.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Utilitarios {

    private Utilitarios() {
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
        System.out.println("0 - Sair.");

        opcao = scanner.nextInt();

        return opcao;
    }

    public static void imprimeLista(ArrayList<Usuario> array) {

        if (!vazioLista(array)) {
            for (Usuario usuario : array) {
                System.out.println(usuario.getLogin());
                System.out.println(usuario.getNome());
                System.out.println("----------------");
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

            System.out.println("Digite o login de usuario que deja procurar: ");
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

    public static boolean vazioLista(ArrayList<Usuario> array) {
        if (array.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void continua() {
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
