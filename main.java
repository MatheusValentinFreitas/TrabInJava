import estruturas.*;
import utilitarios.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        Utilitarios menu = new Utilitarios();

        menu.menu();

        ArrayList<Usuario> Lista = new ArrayList<Usuario>();

        Usuario aluno = new Usuario(18);

        Lista.add(aluno);

        for(Usuario item : Lista){
            System.out.println(item.getId());
        }

        System.out.println("Hello World");
    }
}