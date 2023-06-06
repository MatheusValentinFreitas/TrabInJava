package utilitarios;
import java.util.Scanner;

public class Utilitarios {
    public int menu(){

        Scanner scanner = new Scanner(System.in);

        int opcao;

        System.out.println("Escolha uma opção: ");
        System.out.println("Cadastrar usuário.");
        System.out.println("Excluir usuário.");
        System.out.println("Listar usuário.");
        System.out.println("Pesquisar.");
        System.out.println("Alterar.");

        opcao = scanner.nextInt();


        return opcao;
    }

}
