import java.util.*;

public class Mochila implements Cloneable{
	private List<Producto> contenido;
	private int peso;
	private int precio;
	
	public Mochila(){
		this.contenido = new ArrayList();
		this.peso = 0;
		this.precio = 0;
	}
	
	public void addProducto(Producto producto){
		this.contenido.add(producto);
		this.peso += producto.getPeso();
		this.precio += producto.getPrecioUnitario();
	}
	
	public int getPeso(){
		return this.peso;
	}
	
	public int getPrecio(){
		return this.precio;
	}
	
	public Object clone(){
		Mochila resultado = new Mochila();
		for(int i=0; i<this.contenido.size(); i++){
			Producto producto = this.contenido.get(i);
			resultado.addProducto(producto);
		}
		return resultado;
	}
	
	public String toString(){
		return "((((peso: "+ this.peso + ", precio: " + this.precio + ", contenido: " + this.contenido + "))))";
	}
}