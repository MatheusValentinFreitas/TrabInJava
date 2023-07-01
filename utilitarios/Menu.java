package utilitarios;

import estruturas.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    private static ArrayList<Usuario> Lista = new ArrayList<Usuario>();

    private static HashMap<String, Mensagem> Mensagens = new HashMap<String, Mensagem>();    

    private Menu() {
    }

    public static void menuControler() {
        int funcionalidade = -1;

        while (true) {
            funcionalidade = funcionalidades();

            try {
                Controlador.limpaTela();
            } catch (Exception e) {
            }

            switch (funcionalidade) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    usuario();
                    break;
                case 2:
                    seguidores();
                    break;
                case 3:
                    mensagens();
                    break;
                case 4:
                    rede();
                    break;
                default:
                    System.out.println("Digite um valor valido.");
                    Controlador.continua();
                    break;
            }

            try {
                Controlador.limpaTela();
            } catch (Exception e) {
            }
        }
    }

    public static int funcionalidades() {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        System.out.println("Escolha uma funcionalidade: ");
        System.out.println("1 - Usuário.");
        System.out.println("2 - Seguidores.");
        System.out.println("3 - Mensagens.");
        System.out.println("4 - Rede.");
        System.out.println("0 - Sair.");

        opcao = scanner.nextInt();

        return opcao;
    }

    public static void usuario() {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        System.out.println("1 - Cadastrar usuário.");
        System.out.println("2 - Excluir usuário.");
        System.out.println("3 - Listar usuários.");
        System.out.println("4 - Pesquisar.");
        System.out.println("5 - Alterar.");

        opcao = scanner.nextInt();

        try {
            Controlador.limpaTela();
        } catch (Exception e) {
        }

        switch (opcao) {
            case 1:
                Controlador.cadastraUsuario(Lista);
                Controlador.continua();
                break;
            case 2:
                Controlador.excluirUsuario(Lista, Mensagens);
                Controlador.continua();
                break;
            case 3:
                Controlador.imprimeLista(Lista);
                Controlador.continua();
                break;
            case 4:
                Controlador.pesquisarUsuario(Lista);
                Controlador.continua();
                break;
            case 5:
                Controlador.alteraUsuario(Lista);
                Controlador.continua();
                break;
            default:
                System.out.println("Opção não valida.");
                Controlador.continua();
                break;
        }

        try {
            Controlador.limpaTela();
        } catch (Exception e) {
        }
    }

    public static void seguidores() {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        System.out.println("1 - Seguir.");
        System.out.println("2 - Cancelar seguir.");

        opcao = scanner.nextInt();

        try {
            Controlador.limpaTela();
        } catch (Exception e) {
        }

        switch (opcao) {
            case 1:
                Controlador.seguirUsuario(Lista);
                Controlador.continua();
                break;
            case 2:
                Controlador.cancelaSeguirUsuario(Lista);
                Controlador.continua();
                break;
            default:
                System.out.println("Opção não valida.");
                Controlador.continua();
                break;
        }

        try {
            Controlador.limpaTela();
        } catch (Exception e) {
        }
    }

    public static void mensagens() {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        System.out.println("1 - Registrar mensagem.");
        System.out.println("2 - Comentar mensagem.");
        System.out.println("3 - Ver mensagens.");

        opcao = scanner.nextInt();

        try {
            Controlador.limpaTela();
        } catch (Exception e) {
        }

        switch (opcao) {
            case 1:
                Controlador.registrarMensagem(Lista, Mensagens);
                Controlador.continua();
                break;
            case 2:
                Controlador.comentarMensagem(Lista, Mensagens);
                Controlador.continua();
                break;
            case 3:
                Controlador.listarMensagens(Lista, Mensagens);
                Controlador.continua();
                break;
            default:
                System.out.println("Opção não valida.");
                Controlador.continua();
                break;
        }

        try {
            Controlador.limpaTela();
        } catch (Exception e) {
        }
    }

    public static void rede() {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        System.out.println("1 - Seguidores.");
        System.out.println("2 - Seguidos.");
        System.out.println("3 - Mais influente.");
        System.out.println("4 - Ocorrência de assunto.");

        opcao = scanner.nextInt();

        try {
            Controlador.limpaTela();
        } catch (Exception e) {
        }

        switch (opcao) {
            case 1:
                Controlador.mostraSeguidores(Lista);
                Controlador.continua();
                break;
            case 2:
                Controlador.mostraSeguidos(Lista);
                Controlador.continua();
                break;
            case 3:
                Controlador.maisInfluente(Lista);
                Controlador.continua();
                break;
            case 4:
                Controlador.ocorrenciaAssunto(Mensagens);
                Controlador.continua();
            break;
            default:
                System.out.println("Opção não valida.");
                Controlador.continua();
                break;
        }

        try {
            Controlador.limpaTela();
        } catch (Exception e) {
        }
    }
}
