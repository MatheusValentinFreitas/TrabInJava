package estruturas;

import java.util.HashSet;

public class Rede {
    private HashSet<String> seguidores = new HashSet<String>();
    private HashSet<String> seguidos = new HashSet<String>();

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

    public void imprimeSeguidores() {
        for (String seguidor : seguidores) {
            System.out.println(seguidor);
        }
    }

    public void imprimeSeguindo() {
        for (String seguindo : seguidos) {
            System.out.println(seguindo);
        }
    }
}
