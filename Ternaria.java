import java.util.*;

public class Ternaria {
	
	public static boolean ternariaRecursiva (int[] lista, int buscar, int primero, int ind1, int ind2, int ultimo){
		Arrays.sort(lista);
		boolean resultado = false;
		if (buscar==lista[primero]||buscar==lista[ind1]||buscar==lista[ind2]||buscar==lista[ultimo]){
			resultado = true;
		}
		else if (buscar < lista[primero] || primero >= ultimo|| lista[ultimo] < buscar){
			resultado = false;
		}
		else{
			if (buscar<lista[ind1]){
				ultimo = ind1-1;
				primero++;	
			}
			else if (buscar<lista[ind2]){
				primero = ind1+1;
				ultimo = ind2-1;
			}
			else if (buscar<lista[ultimo]){
				primero = ind2+1;
				ultimo--;
			}
			int longitud = ultimo-primero;
			ind1 = primero + longitud/3;
			ind2 = primero + longitud*2/3;
			resultado = ternariaRecursiva(lista, buscar, primero, ind1, ind2, ultimo);
		}
		return resultado;
	}
	
	
	public static boolean busquedaTernariaRecursiva(int[] lista, int buscar){
		int primero = 0;
		int ultimo = lista.length-1;
		int ind1 = ultimo/3;
		int ind2 = 2*ultimo/3;
		boolean solucion = ternariaRecursiva(lista, buscar, primero, ind1, ind2, ultimo);
		return solucion;
	}

	public static boolean ternariaIterativa (int[] lista, int buscar, int ind1, int ind2){
		int primero = 0;
		boolean resultado = false;
		int ultimo = lista.length-1;
		while (primero <= ultimo && buscar >=lista[primero] && lista[ultimo] >= buscar){
			if (buscar==lista[primero]||buscar==lista[ind1]||buscar==lista[ind2]||buscar==lista[ultimo]){
				resultado = true;
				break;
			}	
			else{
				if (buscar<lista[ind1]){
					ultimo = ind1-1;
					primero++;	
				}
				else if (buscar<lista[ind2]){
					primero = ind1+1;
					ultimo = ind2-1;
				}
				else if (buscar<lista[ultimo]){
					primero = ind2+1;
					ultimo--;
				}
				int longitud = ultimo-primero;
				ind1 = primero+longitud/3;
				ind2 = primero+longitud*2/3;
			}
		}
		return resultado;
	}
	
	public static boolean busquedaTernariaIterativa(int[] lista, int buscar){
	Arrays.sort(lista);
	int ultimo = lista.length-1;
	int ind1 = ultimo/3;
	int ind2 = 2*ultimo/3;
	return ternariaIterativa(lista, buscar, ind1, ind2);
	}

}
