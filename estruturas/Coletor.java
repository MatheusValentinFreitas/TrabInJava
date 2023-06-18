package estruturas;

public class Coletor {
    public String login;
    public String nome;
    public boolean existe;
    public int posicao;
    
    public Coletor(String login, Boolean existe, int posicao, String nome){
        this.login = login;
        this.existe = existe;
        this.posicao = posicao;
        this.nome = nome;
    }
}