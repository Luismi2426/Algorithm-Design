import java.util.*;

public class Binaria {
	
	public static boolean binariaRecursiva (int[] lista, int buscar, int primero, int limite, int ultimo){
		Arrays.sort(lista);
		boolean resultado = false;
		if (buscar==lista[primero]||buscar==lista[limite]||buscar==lista[ultimo]){
			resultado = true;
		}
		else if (buscar < lista[primero] || primero >= ultimo|| lista[ultimo] < buscar){
			resultado = false;
		}
		else{
			if (buscar<lista[limite]){
				ultimo = limite-1;
				primero = primero+1;
					
			}
			else if (buscar<lista[ultimo]){
				primero = limite+1;
				ultimo = ultimo-1;
			}
			int longitud = ultimo-primero;
			limite = primero+(longitud/2);
			resultado = binariaRecursiva(lista, buscar, primero, limite, ultimo);
		}
		return resultado;
	}
	
	
	public static boolean busquedaBinariaRecursiva(int[] lista, int buscar){
		int primero = 0;
		int ultimo = lista.length-1;
		int limite = ultimo/2;
		boolean solucion = binariaRecursiva(lista, buscar, primero, limite, ultimo);
		return solucion;
	}

	
	public static boolean binariaIterativa(int[] lista, int primero, int limite, int ultimo, int buscar){
		Arrays.sort(lista);
		boolean resultado = false;
		while (lista[primero]<= buscar && buscar <= lista[ultimo] && primero <= ultimo){
			if (buscar == lista[primero] || buscar == lista[limite] || buscar == lista[ultimo]){
				resultado = true;
				break;
			}
			else{
				if (buscar < lista[limite]){
					ultimo = limite-1;
					primero++;
					
				}
				else if (buscar < lista[ultimo]){
					primero = limite+1;
					ultimo--;
				}
				int longitud = ultimo-primero;
				limite = primero+(longitud/2);
			}
		}
		return resultado;
	}
	
	public static boolean busquedaBinariaIterativa(int[] lista, int buscar){
		int primero = 0;
		int ultimo = lista.length-1;
		int limite = ultimo/2;
		boolean resultado = binariaIterativa(lista, primero, limite, ultimo, buscar);
		return resultado;
	}
}
