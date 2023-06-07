import estruturas.*;
import utilitarios.Utilitarios;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        ArrayList<Usuario> Lista = new ArrayList<Usuario>();

        Usuario aluno = new Usuario("Matheus", "Matheus@gmail", "18/02/2001", "mateuzin_123");

        Usuario aluno1 = new Usuario("Antonio", "Antonio@gmail", "19/02/2001", "teuzin_123");
        
        Usuario aluno2 = new Usuario("Valentin", "Valentin@gmail", "20/02/2001", "deregjoson_123");

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