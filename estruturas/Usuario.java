package estruturas;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String dataNasc;
    private String login;

    public Usuario(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public String getLogin() {
        return login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}