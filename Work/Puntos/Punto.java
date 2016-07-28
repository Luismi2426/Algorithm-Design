import java.util.*;

public class Punto implements Comparable<Punto>, Cloneable{
	private int x;
	private int y;
	
	public Punto (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setX(int valor) {
		this.x = valor;
	}
	
	public void setY(int valor) {
		this.y = valor;
	}
	
	//0 = Horizontal, 1 = Vertical
	public void mover (int direccion){
		switch(direccion){
			case 0: this.x = this.x + 1;
					break;
			case 1: this.y = this.y + 1;
					break;
		}
	}
	
    public int compareTo(Punto punto){
    	int resultado = 0;
        if (this.x <= punto.getX() && this.y < punto.getY() || this.x < punto.getX() && this.y <= punto.getY()){
        	resultado = -1;
        }
        else if (this.x > punto.getX() || this.y > punto.getY()){
        	resultado = 1;
        }
        return resultado;
    }
    
    public boolean equals(Object objeto){
    	boolean resultado = false;
    	if (objeto instanceof Punto){
    		Punto aux = (Punto) objeto;
    		resultado = (this.x == aux.getX()) && (this.y == aux.getY());
    	}
    	return resultado;
    }
    
    public int hashCode(){
    	return 31*x+y;
    }
	
	public Object clone() throws CloneNotSupportedException{
		Punto clon = new Punto(this.getX(),this.getY());
		return clon;
	}
	
	public String toString(){
    	String cadena= "";
    	cadena += "(" + this.x + "," + this.y + ")";
        return cadena;
	}
}