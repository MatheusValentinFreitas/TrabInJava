import estruturas.*;
import utilitarios.Utilitarios;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        ArrayList<Usuario> Lista = new ArrayList<Usuario>();

        Usuario aluno = new Usuario(1);

        aluno.setNome("Matheus");

        Usuario aluno1 = new Usuario(2);

        aluno1.setNome("Antônio");

        Usuario aluno2 = new Usuario(3);

        aluno2.setNome("Valentin");

        Lista.add(aluno);
        Lista.add(aluno1);
        Lista.add(aluno2);

        int teste = -1;

        while (teste != 0) {
            teste = Utilitarios.menu();
            try {
                Utilitarios.limpaTela();
            } catch (Exception e) {
            }

            switch (teste) {

                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    Utilitarios.imprimeLista(Lista);
                    Utilitarios.continua();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:

                    break;
                default:
                    break;
            }
            try {
                Utilitarios.limpaTela();
            } catch (Exception e) {
            }

        }
    }
}