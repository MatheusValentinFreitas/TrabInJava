import estruturas.*;
import utilitarios.Utilitarios;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        ArrayList<Usuario> Lista = new ArrayList<Usuario>();

        int teste = -1;

        while (teste != 0) {
            teste = Utilitarios.menu();

            try {
                Utilitarios.limpaTela();
            } catch (Exception e) {
            }

            switch (teste) {

                case 1:
                    Utilitarios.cadastraUsuario(Lista);
                    Utilitarios.continua();
                    break;
                case 2:
                    Utilitarios.excluirUsuario(Lista);
                    Utilitarios.continua();
                    break;
                case 3:
                    Utilitarios.imprimeLista(Lista);
                    Utilitarios.continua();
                    break;
                case 4:
                    Utilitarios.pesquisarUsuario(Lista);
                    Utilitarios.continua();
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