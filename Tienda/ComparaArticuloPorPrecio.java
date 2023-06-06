package Tienda;

import java.util.Comparator;

public class ComparaArticuloPorPrecio implements Comparator<Articulo> {

    @Override
    public int compare(Articulo a1, Articulo a2) {
        if (a1.getPvp() < a2.getPvp()) {
            return -1;
        } else if (a1.getPvp() > a2.getPvp()) {
            return 1;
        } else {
            return 0;
        }
    }
}

