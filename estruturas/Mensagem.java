package estruturas;

import java.util.HashMap;

public class Mensagem {

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

    public void imprimeComentarios() {
        Comentarios comentario;
        for (String chave : comentarios.keySet()) {
            comentario = comentarios.get(chave);
            System.out.println(
                    "Num: " + chave + " Login: " + comentario.getLogin() + " Msg: " + comentario.getRegistro());
        }
    }

    public void insereComentario(String login, String registro) {
        Comentarios novoComentario;

        novoComentario = new Comentarios(login, registro, numComentarios);

        comentarios.put(Integer.toString(numComentarios), novoComentario);

        numComentarios++;
    }

    public void removeComentarioUsuario(String login) {

        Comentarios comentario;

        for (String chave : comentarios.keySet()) {
            comentario = comentarios.get(chave);

            if (login.equals(comentario.getLogin())) {
                comentarios.remove(chave);
            }
        }
    }

    public int coletaOcorrenciaAssunto(String assunto) {

        Comentarios comentario;
        int qtdOcorrencia = 0;

        for (String chave : comentarios.keySet()) {
            comentario = comentarios.get(chave);

            if (comentario.getRegistro().contains(assunto)) {
                qtdOcorrencia++;
            }
        }

        return qtdOcorrencia;

    }

    public int numerosComentarios() {
        return comentarios.size();
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
