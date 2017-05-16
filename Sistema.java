package simuladorMemoria;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lucas on 07/05/17.
 */
public class Sistema {


    private static Leitor dados = new Leitor();

    private static int[] LFU = new int[dados.numLinhasCache()];
    private static int[] LRU = new int[dados.numLinhasCache()];
    private static Cache[] cache = new Cache[dados.numLinhasCache()];

    private static ArrayList<Memoria> listaAcessos;
    private static int tMem = dados.getMem();
    private static int tCach = dados.getCache();
    private static int miss = 0;
    private static int hit = 0;
    private static int tamanhoCache = 256;//dados.getnLinhasCa();
    private static int nLinhaC = 256;//dados.getnLinhasCa();

    Sistema(){
         //Leitor dados = new Leitor();

        setCache();
        setLFU();
        setLRU();
        this.tamanhoCache =dados.getnLinhasCa() ;
    }

    public void setCache(){
        for(int i=0;i<getnLinhaC();i++)
            cache[i] = new Cache(4);
    }

    public void aDireto(ArrayList<Memoria> memoria, Cache[] cache){

        for(Memoria i : memoria){

            try{
                if((cache[i.getLinha()].getRotulo() == -1) || cache[i.getLinha()].getRotulo() != i.getRotulo()){
                    setMiss();
                    cache[i.getLinha()].setRotulo(i.getRotulo());


                }else {
                    setHit();
                }
            }catch (Exception a){
                System.out.println(a);
            }
        }
    }

    public void setLFU(){
        for(int i = 0;i<getTamanhoCache();i++){
            LFU[i] = 1;
        }
    }

    public void setLRU(){
        for(int i = 0;i<getTamanhoCache();i++){
            LRU[i] = 1;
        }
    }

    public void contador(ArrayList<Memoria> memoria, Cache[] cache){

        for(Memoria i : memoria) {

            if((buscaCache(i.getRotulo(),cache))!=-1){
                setHit();
            }else{
                setMiss();
                if(getTamanhoCache()>0){
                    setValor(getTamanhoCache(),i.getTag(),i.getRotulo());;
                    setTamanhoCache(1,-1);
                }else {
                    setTamanhoCache(0,dados.numLinhasCache()-1);
                    setValor(getTamanhoCache(),i.getTag(),i.getRotulo());

                }

            }

        }
    }

    public static void randomico(ArrayList<Memoria> memoria, Cache[] cache) {

        Random gerador = new Random();

        for(Memoria i : memoria) {
            if ((buscaCache(i.getRotulo(), cache))!=-1) {
                setHit();
            } else {
                setMiss();
                int linha = gerador.nextInt(getnLinhaC());//dados.getnLinhasCa());
                setValor(linha,i.getTag(),i.getRotulo());
            }
        }
    }

    public void LFU(ArrayList<Memoria> memoria, Cache[] cache){
        for(Memoria i : memoria) {

            int indice = buscaCache(i.getRotulo(), cache);

            if (indice != -1) {
                setHit();
                LFU[indice]+=1;
            } else {
                setMiss();
                if(getTamanhoCache()>0){
                    setValor(getTamanhoCache(),i.getTag(),i.getRotulo());
                    setTamanhoCache(1,-1);
                }else{
                    int pos = menorRepeticao();
                    setValor(pos,i.getTag(),i.getRotulo());
                    LFU[pos] = 1;
                }
            }
        }
    }

    public void LRU(ArrayList<Memoria> memoria, Cache[] cache){
        for(Memoria i : memoria) {

            int indice = buscaCache(i.getRotulo(), cache);
           // System.out.println(getTamanhoCache());
            if (indice != -1) {
                setHit();
            } else {
                setMiss();
                if(getTamanhoCache()>0){
                    setValor(getTamanhoCache(),i.getTag(),i.getRotulo());

                    setTamanhoCache(1,-1);
                }else{
                    int pos = maiorTempo();
                    setValor(pos,i.getTag(),i.getRotulo());
                    LRU[pos] = 0;
                    reflash(pos);
                }
            }
        }
    }

    public static int buscaCache(int valor, Cache[] cache){
        for (int i = 0;i<getnLinhaC();i++){
            if(cache[i].getRotulo() == valor)
                return i;
        }

        return -1;

    }
    public static int menorRepeticao() {
        double menor = Double.MAX_VALUE;
        int indice = -1;
        for (int i = 0; i <LFU.length; i++) {
            if (LFU[i] <= menor) {
                menor = LFU[i];
                indice = i;
            }
        }
        return indice;
    }
    public static int maiorTempo() {
        double maior = Double.MIN_VALUE;
        int indice = -1;
        for (int i = 0; i <LRU.length; i++) {
            if (LRU[i] >= maior) {
                maior = LRU[i];
                indice = i;
            }
        }
        return indice;
    }

    public void reflash(int pos){
        for(int i = 0;i<getnLinhaC();i++){
            if(i!=pos)
            LRU[i] +=1;
        }

    }

    public static void setValor(int indice,int tag,int rotulo){

        cache[indice].setRotulo(rotulo);
        cache[indice].setV(true);
        cache[indice].setTag(tag);

    }

    public void setMemoria(ArrayList<Memoria> memoria) {
        this.listaAcessos = memoria;
    }

    public ArrayList <Memoria> getMemoria() {
        return listaAcessos;
    }
    public static int[] getLFU() {
        return LFU;
    }

    public static void setLFU(int[] LFU) {
        Sistema.LFU = LFU;
    }

    public static int getnLinhaC() {
        return nLinhaC;
    }

    public static void setnLinhaC(int nLinhaC) {
        Sistema.nLinhaC = nLinhaC;
    }

    public static Cache[] getCache() {
        return cache;
    }

    public static void setCache(Cache[] cache) {
        Sistema.cache = cache;
    }

    public static ArrayList <Memoria> getListaAcessos() {
        return listaAcessos;
    }

    public static void setListaAcessos(ArrayList <Memoria> listaAcessos) {
        Sistema.listaAcessos = listaAcessos;
    }

    public static int getMiss() {
        int aux = miss;
        miss=0;
        return aux;
    }

    public static void setMiss() {
        Sistema.miss +=1;
    }

    public static int getHit() {
        int aux = hit;
        hit=0;
        return aux;
    }

    public static void setHit() {
        Sistema.hit +=1;
    }


    public int getTamanhoCache() {
        return tamanhoCache;
    }

    public void setTamanhoCache(int contr,int valor) {
        if(contr ==1) this.tamanhoCache +=valor;
        else {
            this.tamanhoCache = valor;
        }
    }

    public static int gettMem() {
        return tMem;
    }

    public static void settMem(int tMem) {
        Sistema.tMem = tMem;
    }

    public static int gettCach() {
        return tCach;
    }

    public static void settCach(int tCach) {
        Sistema.tCach = tCach;
    }


}
