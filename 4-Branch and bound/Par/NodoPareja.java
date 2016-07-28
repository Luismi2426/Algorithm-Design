import java.util.*;

public class NodoPareja implements Cloneable, Comparable<NodoPareja>{
	private int[][] tabla;
	private int[] parejas;
	private int restantes;
	private int afinidad;
	
	public NodoPareja(int[][] tabla){
		this.tabla=tabla;
		this.parejas = new int[tabla.length];
		Arrays.fill(parejas, -1);
		this.restantes = tabla.length/2;
		this.afinidad = 0;
	}
	
	public int[] getParejas(){
		return this.parejas;
	}
	
	public void addPareja(int p1, int p2){
		if (p1==p2){
			throw new IllegalArgumentException();
		}
		boolean posible = (parejas[p1]==-1 && parejas[p2]==-1);
		if (posible){
			parejas[p1]=p2;
			parejas[p2]=p1;
			restantes--;
			afinidad+= tabla[p1][p2]+tabla[p2][p1];
		}
	}
	
	public boolean completo(){
		return this.restantes == 0;
	}
	
	public Object clone(){
		NodoPareja copia = new NodoPareja(this.tabla);
		copia.parejas = Arrays.copyOf(parejas, parejas.length);
		copia.restantes = this.restantes;
		copia.afinidad = this.afinidad;
		return copia;
	}
	
	public NodoPareja hijo(int p1, int p2){
		NodoPareja copia = (NodoPareja) this.clone();
		copia.addPareja(p1,p2);
		return copia;
	}
	
	public int costeEstimado(){
		int resultado = 0;
		if (this.completo()){
			resultado = afinidad;
		}
		else{
			resultado = Integer.MAX_VALUE;
		}
		return resultado;
	}
	
	public int compareTo(NodoPareja nodo){
		int resultado = 0;
		int diferencia = this.costeEstimado() - nodo.costeEstimado();
		if (diferencia<0){
			resultado = -1;
		}
		else if(diferencia>0){
			resultado = 1;
		}
		return resultado;
	}
}