package utilitarios;

import estruturas.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

import java.io.IOException;

public class Controlador {

    private static int registros = 1;

    private Controlador() {
    }

    public static void imprimeLista(ArrayList<Usuario> array) {

        if (!vazioLista(array)) {
            System.out.println("Impressão lista de Usuarios.");
            System.out.println();

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

            System.out.print("Digite o login de usuario que deja procurar: ");
            loginBusca = scanner.nextLine();

            Coletor busca = coletaUsuario(array, loginBusca);

            if (busca.existe) {
                Usuario usuario = array.get(busca.posicao);
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Email: " + usuario.getEmail());
                System.out.println("Data de nascimento: " + usuario.getDataNasc());
            } else {
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

            System.out.println("Digite o login de usuario que deja remover: ");
            loginBusca = scanner.nextLine();

            Coletor busca = coletaUsuario(array, loginBusca);

            if (busca.existe) {
                array.remove(busca.posicao);
                System.out.println("Usuario removido com sucesso.");
            } else {
                System.out.println("Usuario não encontrado");
            }
        } else {
            System.out.println("Não ha o que procurar.");
        }
    }

    public static void alteraUsuario(ArrayList<Usuario> array) {

        if (!vazioLista(array)) {

            Scanner scanner = new Scanner(System.in);
            String loginBusca;

            System.out.println("Digite o login de usuario que deja alterar: ");
            loginBusca = scanner.nextLine();

            Coletor busca = coletaUsuario(array, loginBusca);

            if (busca.existe) {
                Usuario usuario = array.get(busca.posicao);
                System.out.print("Digite o novo Nome: ");
                usuario.setNome(scanner.nextLine());
                System.out.print("Digite o novo Email: ");
                usuario.setEmail(scanner.nextLine());
                System.out.print("Digite a nova Data de nascimento: ");
                usuario.setDataNasc(scanner.nextLine());
            } else {
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

        Coletor validador;

        do {
            System.out.print("Digite seu login: ");
            login = scanner.nextLine();
            validador = coletaUsuario(array, login);

            if (validador.existe) {
                System.out.println("Esse login já existe favor inserir um outro login.");
            }
        } while (validador.existe);

        Usuario newUser = new Usuario(nome, email, dataNasc, login);

        array.add(newUser);
    }

    public static void seguirUsuario(ArrayList<Usuario> array) {

        Scanner scanner = new Scanner(System.in);

        String buscaLogin;

        Coletor usuario1Col;
        Coletor usuario2Col;

        Usuario usuario1;
        Usuario usuario2;

        if (array.size() >= 2) {
            System.out.print("Digite o login do usuario a ser seguido: ");
            buscaLogin = scanner.nextLine();
            usuario1Col = coletaUsuario(array, buscaLogin);
            System.out.print("Digite o login do usuario que ira seguilo: ");
            buscaLogin = scanner.nextLine();
            usuario2Col = coletaUsuario(array, buscaLogin);

            if (usuario1Col.existe && usuario2Col.existe) {
                usuario1 = array.get(usuario1Col.posicao);
                usuario2 = array.get(usuario2Col.posicao);
                if (usuario1.setSeguidor(usuario2Col.login)) {
                    System.out.println(
                            "O usuario " + usuario2Col.login + " agora esta seguindo o usuario " + usuario1Col.login);
                    usuario2.setSeguindo(usuario1Col.login);
                } else {
                    System.out.println("O usuario " + usuario2Col.login + " já segue " + usuario1Col.login);
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

    public static void cancelaSeguirUsuario(ArrayList<Usuario> array) {

        Scanner scanner = new Scanner(System.in);

        String buscaLogin;

        Coletor usuario1Col;
        Coletor usuario2Col;

        Usuario usuario1;
        Usuario usuario2;

        if (array.size() >= 2) {
            System.out.print("Digite o login do usuario a ser parado de seguir: ");
            buscaLogin = scanner.nextLine();
            usuario1Col = coletaUsuario(array, buscaLogin);
            System.out.print("Digite o login do usuario que ira cancelalo: ");
            buscaLogin = scanner.nextLine();
            usuario2Col = coletaUsuario(array, buscaLogin);

            if (usuario1Col.existe && usuario2Col.existe) {
                usuario1 = array.get(usuario1Col.posicao);
                usuario2 = array.get(usuario2Col.posicao);

                if (usuario1.removeSeguidor(usuario2Col.login)) {
                    System.out.println("O usuario " + usuario2Col.login + " deixou de seguir " + usuario1Col.login);
                    usuario2.removeSeguindo(usuario1Col.login);
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

    public static void mostraSeguidores(ArrayList<Usuario> array) {

        Scanner scanner = new Scanner(System.in);

        HashSet<String> seguidores;
        Coletor usuarioCol;
        Usuario usuario;
        String buscaString;

        System.out.print("Digite o login do usuario que deseje ver os seguidores: ");
        buscaString = scanner.nextLine();

        usuarioCol = coletaUsuario(array, buscaString);

        if (usuarioCol.existe) {
            usuario = array.get(usuarioCol.posicao);

            if (usuario.quantidadeSeguidores() > 0) {
                seguidores = usuario.getSeguidores();

                System.out.println("Seguidores de " + usuario.getLogin());

                Coletor usuarioSeguidor;
                for (String seguidor : seguidores) {
                    usuarioSeguidor = coletaUsuario(array, seguidor);
                    System.out.println("Login: " + usuarioSeguidor.login + " | Nome: " + usuarioSeguidor.nome);
                    System.out.println();
                }
            } else {
                System.out.println("Esse usuario não tem nenhum seguidor.");
            }
        } else {
            System.out.println("Esse usuario não existe.");
        }
    }

    public static void mostraSeguidos(ArrayList<Usuario> array) {

        Scanner scanner = new Scanner(System.in);

        HashSet<String> seguidos;
        Coletor usuarioCol;
        Usuario usuario;
        String buscaString;

        System.out.print("Digite o login do usuario que deseje ver quem esta seguindo: ");
        buscaString = scanner.nextLine();

        usuarioCol = coletaUsuario(array, buscaString);

        if (usuarioCol.existe) {
            usuario = array.get(usuarioCol.posicao);

            if (usuario.quantidadeSeguidos() > 0) {
                seguidos = usuario.getSeguidos();

                System.out.println("Seguidos de " + usuario.getLogin());

                Coletor usuarioSeguido;
                for (String seguido : seguidos) {
                    usuarioSeguido = coletaUsuario(array, seguido);
                    System.out.println("Login: " + usuarioSeguido.login + " | Nome: " + usuarioSeguido.nome);
                    System.out.println();
                }
            } else {
                System.out.println("Esse usuario não segue ninguem.");
            }
        } else {
            System.out.println("Esse usuario não existe.");
        }
    }

    public static void maisInfluente(ArrayList<Usuario> array) {

        HashMap<String, String> maiorInfluente = new HashMap<String, String>();
        int maior = 0;

        if (!vazioLista(array)) {

            for (Usuario usuario : array) {
                if (usuario.quantidadeSeguidores() > maior) {
                    maior = usuario.quantidadeSeguidores();
                    maiorInfluente.clear();
                    maiorInfluente.put(usuario.getLogin(), usuario.getNome());
                } else if (usuario.quantidadeSeguidores() == maior) {
                    maiorInfluente.put(usuario.getLogin(), usuario.getNome());
                }
            }

            if (maiorInfluente.size() > 0) {

                System.out.println("Maior influencer do sistema.");

                for (Usuario usuario : array) {
                    if (maiorInfluente.get(usuario.getLogin()) != null) {
                        System.out.println("Login: " + usuario.getLogin() + " | Nome: " + usuario.getNome());
                        System.out.println();
                    }
                }

                System.out.println("Quantidade total de seguidores: " + maior);
            } else {
                System.out.println("Nehum influenciador no sistema.");
            }
        } else {
            System.out.println("Nenhum usuario no sistema.");
        }
    }

    public static void registrarMensagem(ArrayList<Usuario> array, HashMap<String, Mensagem> mensagens) {

        Scanner scanner = new Scanner(System.in);

        String buscaLogin;
        Coletor usuarioCol;

        System.out.print("Digite o login de um usuario que deseje registrar uma mensagem: ");
        buscaLogin = scanner.nextLine();

        usuarioCol = coletaUsuario(array, buscaLogin);

        if (usuarioCol.existe) {
            Mensagem novaMensagem;
            String mensagem;

            System.out.print("Digite a mensagem que deseja registar: ");
            mensagem = scanner.nextLine();

            novaMensagem = new Mensagem(usuarioCol.login, mensagem, registros);

            mensagens.put(Integer.toString(registros), novaMensagem);

            registros++;

            System.out.println("Mensagem registrada com sucesso.");

        } else {
            System.out.println("Usuario não encontrado.");
        }
    }

    public static void comentarMensagem(ArrayList<Usuario> array, HashMap<String, Mensagem> mensagens) {

        Scanner scanner = new Scanner(System.in);

        String buscaLogin;
        Coletor usuarioCol;
        Usuario usuario;
        Mensagem mensagem;

        System.out.print("Digite o login do usuario que a mensagem sera comentada: ");
        buscaLogin = scanner.nextLine();

        usuarioCol = coletaUsuario(array, buscaLogin);

        if (usuarioCol.existe) {
            usuario = array.get(usuarioCol.posicao);
            int contMsgUsuario = 0;

            if (mensagens.size() > 0) {
                for (String chave : mensagens.keySet()) {
                    mensagem = mensagens.get(chave);
                    if (usuario.getLogin().equals(mensagem.getLogin())) {
                        System.out.println(
                                "Num: " + chave + " Login: " + mensagem.getLogin() + " Msg: " + mensagem.getRegistro());
                        contMsgUsuario++;
                    }
                }
                
                if (contMsgUsuario > 0) {
                    System.out.print("Digite o número da mensagem que deseje fazer o comentario: ");
                } else {
                    System.out.println("Esse usuario não tem nenhuma mensagem registrada no sistema.");
                }
            } else {
                System.out.println("Não existem mensagens registradas no sistema.");
            }
        } else {
            System.out.println("Usuario não encontrado.");
        }

    }

    public static void listarMensagens(ArrayList<Usuario> array, HashMap<String, Mensagem> mensagens) {

        Scanner scanner = new Scanner(System.in);

        String buscaLogin;
        Coletor usuarioCol;
        Usuario usuario;
        Mensagem mensagem;

        System.out.print("Digite o login de um usuario que deseje registrar uma mensagem: ");
        buscaLogin = scanner.nextLine();

        usuarioCol = coletaUsuario(array, buscaLogin);

        if (usuarioCol.existe) {
            usuario = array.get(usuarioCol.posicao);

            HashSet<String> seguidos = usuario.getSeguidores();

            for (String chave : mensagens.keySet()) {
                mensagem = mensagens.get(chave);
                if (usuario.getLogin().equals(mensagem.getLogin())) {
                    System.out.println(
                            "Num: " + chave + " Login: " + usuario.getLogin() + " Msg: " + mensagem.getRegistro());
                } else {
                    for (String seguido : seguidos) {
                        if (seguido.equals(mensagem.getLogin())) {
                            System.out.println("Num: " + chave + " Login: " + seguido + " Msg: "
                                    + mensagem.getRegistro());
                        }
                    }
                }
            }
        } else {
            System.out.println("Usuario não encontrado.");
        }
    }

    public static Coletor coletaUsuario(ArrayList<Usuario> array, String buscaLogin) {

        Coletor info;
        Usuario usuario;
        String nome = "";

        boolean existe = false;
        int posicao = -1;

        for (int i = 0; i < array.size(); i++) {

            usuario = array.get(i);

            if (buscaLogin.equals(usuario.getLogin())) {
                nome = usuario.getNome();
                existe = true;
                posicao = i;
                break;
            }
        }

        info = new Coletor(buscaLogin, existe, posicao, nome);

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
