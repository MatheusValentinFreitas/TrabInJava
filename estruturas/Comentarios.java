package estruturas;

public class Comentarios {

    private int id;
    private String login;
    private String registro;

    Comentarios(String login, String registro, int id) {
        this.login = login;
        this.registro = registro;
        this.id = id;
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
