package simuladorMemoria;

/**
 * Created by lucas on 03/05/17.
 */
public class Memoria {

    private int rotulo;
    private int linha;
    private int tag;
    private int dado;

    Memoria(){}

   public Memoria (int tag,int linha,int rotulo,int dado){

        this.tag = tag;
        this.linha = linha;
        this.rotulo = rotulo;
        this.dado = dado;
    }
    public Memoria addEnderecoDireto(String endereco) {

        try {
            endereco = "000000000000" + endereco;

            int tag = Integer.parseInt(endereco.substring(endereco.length() - 2, endereco.length()), 2);
            int linha = Integer.parseInt(endereco.substring(endereco.length() - 10, endereco.length() - 2), 2);
            int rotulo = Integer.parseInt(endereco.substring(0, endereco.length() - 10), 2);
            int dado = Integer.parseInt(endereco, 2);

            Memoria a = new Memoria(tag, linha, rotulo, dado);
            return a;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }


    }



    public  Memoria addEnderecoAssociativo(String endereco){

        endereco="000000000000"+endereco;
        int palavra = Integer.parseInt(endereco.substring(endereco.length()-2,endereco.length()),2);
        int tag =  Integer.parseInt(endereco.substring(0,endereco.length()-2),2);

        Memoria a = new Memoria(palavra,0,tag,Integer.parseInt(endereco,2));

        return a;

    }


    public int getRotulo() {
        return rotulo;
    }

    public void setRotulo(int rotulo) {
        this.rotulo = rotulo;
    }
    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

}
