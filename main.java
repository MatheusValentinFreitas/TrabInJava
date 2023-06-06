import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static class Usuario {
        public int id;
        public String nome;
        public String email;
        public String dataNasc;
        public String login;

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
    public static void main(String[] args) {

        ArrayList<Usuario> Lista = new ArrayList<Usuario>();

        Usuario aluno = new Usuario(18);

        Lista.add(aluno);

        for(Usuario item : Lista){
            System.out.println(item.getId());
        }

        System.out.println("Hello World");
    }
}