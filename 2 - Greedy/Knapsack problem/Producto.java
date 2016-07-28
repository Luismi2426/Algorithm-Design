import java.util.*;

public class Producto implements Comparable<Producto>{
	private int peso;
	private float precioUnitario;
	
	public Producto(int peso, float precioUnitario){
		if (peso<=0 || precioUnitario<0){
			throw new IllegalArgumentException("Parametros incorrectos");
		}
		this.peso=peso;
		this.precioUnitario=precioUnitario;
	}
	
	public int getPeso(){
		return this.peso;
	}
	
	public float getPrecioUnitario(){
		return this.precioUnitario;
	}
	
	public int compareTo(Producto producto){
		int resultado = 0;
		if (this.precioUnitario < producto.getPrecioUnitario()){
			resultado = -1;
		}
		else if (this.precioUnitario > producto.getPrecioUnitario()){
			resultado = 1;
		}
		return resultado;
	}
	
	public boolean equals (Object objeto){
		boolean resultado = false;
		if (objeto instanceof Producto) {
			Producto auxiliar = (Producto) objeto;
			resultado = (this.precioUnitario == auxiliar.getPrecioUnitario());
		}
		return resultado;
	}
	
	public int hashCode(){
		return (int) this.precioUnitario*29;
	}
	
	public String toString(){
		return "("+this.peso+", "+this.precioUnitario+")";
	}
}
