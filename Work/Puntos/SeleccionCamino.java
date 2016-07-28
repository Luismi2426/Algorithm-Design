import java.util.*;

public class SeleccionCamino {
	
	//Mueve un punto en una direccion dada y comprueba si eso movimiento vale o no
	public static boolean siguiente (Punto punto, int direccion, Punto destino){
		if (direccion>2 || direccion<0) 
			throw new IllegalArgumentException ("Direccion no valida");
		punto.mover(direccion);
		boolean posible = false;
		
		if (!(punto.compareTo(destino) == 1)){
			posible = true;
		}
		else {
			punto.setX(-1);
			punto.setY(-1);
		}
		return posible;
	}
	
	public static List<List<Punto>> seleccionRecursiva (Punto actual, Punto destino, 
			List<Punto> camino, List<List<Punto>> seleccion) throws CloneNotSupportedException {
		
		if (actual.equals(destino)) {
			seleccion.add(camino);
		}
		
		else {
			for (int i=0; i<2; i++){
				List<Punto> caminoAux = new ArrayList<Punto>(camino);
				Punto puntoAux = (Punto) actual.clone();
				if (siguiente(puntoAux, i, destino)){
					caminoAux.add(puntoAux);
					seleccionRecursiva(puntoAux, destino, caminoAux, seleccion);
				}
			}
		}
		return seleccion;	
	}

	public static List<List<Punto>> listaCaminos (Punto destino) throws CloneNotSupportedException{
		Punto origen = new Punto(0,0);
		List<Punto> camino = new ArrayList();
		List<List<Punto>> seleccion = new ArrayList(new ArrayList());
		return seleccionRecursiva(origen, destino, camino, seleccion);
	}
}