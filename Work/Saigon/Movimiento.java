import java.util.*;

public class Movimiento{
	private String origen;
	private String destino;
	
	public Movimiento(String origen, String destino){
		this.origen = origen;
		this.destino = destino;
	}
	
	public String toString(){
		String cadena= "";
		cadena += "(" + this.origen + "," + this.destino + ")";
    	return cadena;
	}
}