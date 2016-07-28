import java.util.*;

public class Binaria2 {
	
	public static boolean binariaRecursiva (Comparable[] lista, Comparable buscar, int primero, int limite, int ultimo){
		Arrays.sort(lista);
		boolean resultado = false;
		if (buscar.equals(lista[primero])||buscar.equals(lista[limite])||buscar.equals(lista[ultimo])){
			resultado = true;
		}
		else if (buscar.compareTo(lista[primero])<0|| primero >= ultimo|| lista[ultimo].compareTo(buscar)<0){
			resultado = false;
		}
		else{
			if (buscar.compareTo(lista[limite])<0){
				ultimo = limite-1;
				primero = primero+1;
					
			}
			else if (buscar.compareTo(lista[ultimo])<0){
				primero = limite+1;
				ultimo = ultimo-1;
			}
			int longitud = ultimo-primero;
			limite = primero+(longitud/2);
			resultado = binariaRecursiva(lista, buscar, primero, limite, ultimo);
		}
		return resultado;
	}
	
	
	public static boolean busquedaBinariaRecursiva(Comparable[] lista, Comparable buscar){
		int primero = 0;
		int ultimo = lista.length-1;
		int limite = ultimo/2;
		boolean solucion = binariaRecursiva(lista, buscar, primero, limite, ultimo);
		return solucion;
	}

	
	public static boolean binariaIterativa(Comparable[] lista, Comparable buscar, int primero, int limite, int ultimo){
		Arrays.sort(lista);
		boolean resultado = false;
		while (buscar.compareTo(lista[primero])>=0 || primero >= ultimo|| lista[ultimo].compareTo(buscar)>=0){
			if (buscar.equals(lista[primero])||buscar.equals(lista[limite])||buscar.equals(lista[ultimo])){
				resultado = true;
				break;
			}
			else{
				if (buscar.compareTo(lista[limite])<0){
					ultimo = limite-1;
					primero++;
					
				}
				else if (buscar.compareTo(lista[ultimo])<0){
					primero = limite+1;
					ultimo--;
				}
				int longitud = ultimo-primero;
				limite = primero+(longitud/2);
			}
		}
		return resultado;
	}
	
	public static boolean busquedaBinariaIterativa(Comparable[] lista, Comparable buscar){
		int primero = 0;
		int ultimo = lista.length-1;
		int limite = ultimo/2;
		boolean resultado = binariaIterativa(lista, buscar, primero, limite, ultimo);
		return resultado;
	}
}
