package estruturas;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private String dataNasc;
    private String login;
    private ArrayList<String> seguidores = new ArrayList<String>();

    public Usuario(String nome, String email, String dataNasc, String login) {
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
        this.login = login;
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

    public void setSeguidores(String seguidor) {
        seguidores.add(seguidor);
    }

    public void removeSeguidor(int posicao){
        seguidores.remove(posicao);
    }

    public Coletor getSeguidor(String buscaSeguidor){
        Coletor info;

        boolean existe = false;
        int posicao = -1;

        for(int i = 0; i < seguidores.size(); i++){

            if(buscaSeguidor.equals(seguidores.get(i))){
                existe = true;
                posicao = i;
                break;
            }
        }

        info = new Coletor(buscaSeguidor, existe, posicao);

        return info;
    }

    public void imprimeSeguidores(){
        for(String seguidor: seguidores){
            System.out.println(seguidor);
        }
    }
}