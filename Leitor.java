package simuladorMemoria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Leitor {

	final static int b = 1;
	final static int B = 8;
	final static int Kb = 1024;
	
	private int mem;
	private String mMem;
	private int palavra;
	private String mPal;
	private int cache;
	private String mCac;
	private int linhas;

	private int nLinhasCa;


	public  int numLinhasCache(){

		return 256;//(getCache()*Kb)/(getPalavra()*getLinhas());
	}
	
	Leitor(){
		
	}
	Leitor(int mem,String mMem,int palavra,String mPal,int cache,String mCac,int linhas){

		this.mem = mem;
		this.mMem = mMem;
		this.palavra = palavra;
		this.mPal = mPal;
		this.cache = cache;
		this.mCac = mCac;
		this.linhas = linhas;
		this.nLinhasCa = 256;
	}
	public Leitor addDados(String endereco){
		
		int mem = 0,palavra= 0,cache= 0,linhas= 0;
		String mMem="",mPal="",mCac="";
		String[] linha;

		int flag = 0;
		
		try{
			@SuppressWarnings("resource")
			BufferedReader arquivo  = new BufferedReader(new FileReader(endereco));
			
			while(arquivo.ready()){
				linha = (arquivo.readLine()).split(" ");
				if(flag==0){
					mem = Integer.parseInt(linha[2]);
					mMem = linha[3];
				}else if(flag==1){
					palavra = Integer.parseInt(linha[2]);
					mPal = linha[3];
				}else if(flag==2){
					cache = Integer.parseInt(linha[2]);
					mCac = linha[3];
				}else{
					linhas = Integer.parseInt(linha[2]);
				}
				flag++;
			
			}
		}catch(Exception e){
			 System.out.println("O arquivo não esta configurado corretamnte\n");
		}
		//int i = (cache * Kb)/ (p * a.getLinhas());

		Leitor a = new Leitor(mem,mMem,palavra,mPal,cache,mCac,linhas);

		return a;
	}

	public void addMemoria(String teste,int contro){

		ArrayList<Memoria> memoria = new ArrayList<Memoria>();
		Memoria a = new Memoria();

		try {
			BufferedReader leitor = new BufferedReader(
					new FileReader(teste));

			while (leitor.ready()){

				if(contro==0){
					memoria.add(a.addEnderecoDireto(Integer.toBinaryString(
							Integer.parseInt(leitor.readLine()))));
				}else {
					memoria.add(a.addEnderecoAssociativo(Integer.toBinaryString(
							Integer.parseInt(leitor.readLine()))));
				}
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		try{
			Sistema sistema = new Sistema();
			sistema.setMemoria(memoria);
		}catch (Exception e){
			System.out.println(e);
		}

	}

	public int getnLinhasCa() {
		return nLinhasCa;
	}

	public void setnLinhasCa(int nLinhasCa) {
		this.nLinhasCa = nLinhasCa;
	}

	public String getmMem() {
		return mMem;
	}
	public void setmMem(String mMem) {
		this.mMem = mMem;
	}
	public String getmPal() {
		return mPal;
	}
	public void setmPal(String mPal) {
		this.mPal = mPal;
	}
	public String getmCac() {
		return mCac;
	}
	public void setmCac(String mCac) {
		this.mCac = mCac;
	}
	public int getMem() {
		return mem;
	}
	public void setMem(int mem) {
		this.mem = mem;
	}
	public int getPalavra() {
		return palavra;
	}
	public void setPalavra(int palavra) {
		this.palavra = palavra;
	}
	public int getCache() {
		return cache;
	}
	public void setCache(int cache) {
		this.cache = cache;
	}
	public int getLinhas() {
		return linhas;
	}
	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}
}
