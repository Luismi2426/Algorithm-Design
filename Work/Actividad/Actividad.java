// Diseño de Algoritmos 14/15
// Luis Miguel Barbero Juvera

import java.util.*;

public class Actividad implements Comparable<Actividad>, Cloneable{
    private int comienzo;
    private int finalizacion;

    public Actividad(int comienzo, int finalizacion) {
    	if (comienzo >= finalizacion || comienzo<0) throw new IllegalArgumentException("Final - Comienzo");
        this.comienzo = comienzo;
        this.finalizacion = finalizacion;
    }
    
    public int getComienzo(){
    	return this.comienzo;
    }
    
    public int getFinalizacion(){
    	return this.finalizacion;
    }
    
    //Orden natural: Tiempo de inicio - Duracion
    public int compareTo(Actividad actividad){
    	int resultado = 0;
        if ((this.comienzo < actividad.comienzo) || (this.comienzo == actividad.comienzo && 
        		this.finalizacion < actividad.finalizacion)){
        	resultado = -1;      
        }
        else if ((this.comienzo > actividad.comienzo) || (this.comienzo == actividad.comienzo && 
        		this.finalizacion > actividad.finalizacion)){
        	resultado = 1;
        }
        return resultado;
    }
    
    public boolean equals(Object objeto){
    	boolean resultado = false;
    	if (objeto instanceof Actividad){
    		Actividad aux = (Actividad) objeto;
    		resultado = (this.comienzo == aux.comienzo) && (this.finalizacion == aux.finalizacion);
    	}
    	return resultado;
    }
    
    public int hashCode(){
    	return 31*comienzo+finalizacion;
    }
 
    public Object clone() throws CloneNotSupportedException{
    	Actividad clon = new Actividad(this.comienzo, this.finalizacion);
    	return clon;
    }
    
    public String toString(){
    	String cadena= "";
    	cadena += "(" + this.comienzo + "-" + this.finalizacion + ")";
        return cadena;
     }
    
    //Comparador: Por tiempo de finalizacion
	public static Comparator<Actividad> FinComparator = new Comparator<Actividad>(){
		
		public int compare(Actividad act1, Actividad act2) {
			
			int comienzo1 = act1.getComienzo();
			int comienzo2 = act2.getComienzo();
			int finalizacion1 = act1.getFinalizacion();
			int finalizacion2 = act2.getFinalizacion();
			int resultado = 0;
			
			if ((finalizacion1 < finalizacion2) || (finalizacion1 == finalizacion2 &&
					comienzo1 < comienzo2)){
				resultado = -1;      
			}
			else if ((finalizacion1 > finalizacion2) || (finalizacion1 == finalizacion2 &&
					comienzo1 > comienzo2)){
				resultado = 1;
			}	
			return resultado;
		}
	};
}
