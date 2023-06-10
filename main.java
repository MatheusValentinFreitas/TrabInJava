import estruturas.*;
import utilitarios.Controlador;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        ArrayList<Usuario> Lista = new ArrayList<Usuario>();

        int teste = -1;

        while (teste != 0) {
            teste = Controlador.menu();

            try {
                Controlador.limpaTela();
            } catch (Exception e) {
            }

            switch (teste) {

                case 1:
                    Controlador.cadastraUsuario(Lista);
                    Controlador.continua();
                    break;
                case 2:
                    Controlador.excluirUsuario(Lista);
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
                case 6:
                    Controlador.seguirUsuario(Lista);
                    Controlador.continua();
                    break;
                case 7:
                    Controlador.cancelaSeguirUsuario(Lista);
                    Controlador.continua();
                break;
                default:
                    break;
            }

            try {
                Controlador.limpaTela();
            } catch (Exception e) {
            }

        }
    }
}