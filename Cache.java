package simuladorMemoria;

import java.util.ArrayList;

/**
 * Created by lucas on 02/05/17.
 */
public class Cache {

    private boolean v;
    private int rotulo;
    private int tag ;
    private int[] dados;

    public Cache(int nBlocos) {

        this.v = false;
        this.tag = -1;
        this.rotulo = -1;
        this.dados = new int[nBlocos];

    }

    public boolean isV() {
        return v;
    }

    public void setV(boolean v) {
        this.v = v;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getDados(int i) {
        return this.dados[i];
    }

    public void setDados(int i,int dado) {
        this.dados[i] = dado;
    }

    public int getRotulo() {
        return rotulo;
    }

    public void setRotulo(int rotulo) {
        this.rotulo = rotulo;
    }


}
