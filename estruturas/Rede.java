package estruturas;

import java.util.HashSet;

public class Rede {
    private HashSet<String> seguidores = new HashSet<String>();
    private HashSet<String> seguidos = new HashSet<String>();

    public boolean verificaSeguidor(String login) {
        return seguidores.contains(login);
    }

    public boolean verificaSeguido(String login) {
        return seguidos.contains(login);
    }

    public int quantidadeSeguidores() {
        return seguidores.size();
    }

    public int quantidadeSeguidos() {
        return seguidos.size();
    }

    public boolean setSeguidor(String seguidor) {
        if (!seguidores.contains(seguidor)) {
            seguidores.add(seguidor);
            return true;
        } else {
            return false;
        }
    }

    public boolean setSeguindo(String seguindo) {
        if (!seguidos.contains(seguindo)) {
            seguidos.add(seguindo);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeSeguidor(String seguidor) {
        if (seguidores.contains(seguidor)) {
            seguidores.remove(seguidor);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeSeguindo(String seguindo) {
        if (seguidos.contains(seguindo)) {
            seguidos.remove(seguindo);
            return true;
        } else {
            return false;
        }
    }

    public HashSet<String> getSeguidores() {
        return seguidores;
    }

    public HashSet<String> getSeguidos() {
        return seguidos;
    }
}
