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
        for (Usuario usuario : array) {
            System.out.println(usuario.getLogin());
            System.out.println(usuario.getNome());
            System.out.println("----------------");
        }
    }

    public static ArrayList<Usuario> cadastraUsuario(ArrayList<Usuario> Lista) {

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

        Lista.add(newUser);

        return Lista;
    }

    public static void continua() {
        System.out.println("Pressione qualquer tecla para continuar...");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Aguarda a entrada do usuário

        System.out.println("Continuando o programa");
    }

    public static void limpaTela() throws IOException, InterruptedException {
        // Limpa a tela no windows, no linux e no MacOS
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }
}
