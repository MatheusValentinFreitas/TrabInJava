package estruturas;
import java.util.HashMap;

import estruturas.Comentarios;

public class Mensagem{

    private int id;
    private int numComentarios = 1;
    private String login;
    private String registro;

    private HashMap<String, Comentarios> comentarios = new HashMap<String, Comentarios>();

    public Mensagem(String login, String registro, int id) {
        this.id = id;
        this.login = login;
        this.registro = registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
}
