import java.util.*;

public class Conteo {
	
	public static List<Integer> conteoMaximo(int[] lista, int maximo, int minimo, int conteoMax, int conteoMin, int posicion){
		
		if (posicion == lista.length){
			List<Integer> resultado = new ArrayList<Integer>();
			resultado.add(maximo);
			resultado.add(conteoMax);
			resultado.add(minimo);
			resultado.add(conteoMin);
			return resultado;
		}
		
		else {
			if (lista[posicion]==maximo){
				conteoMax++;
			}
			else if (lista[posicion]>maximo){
				maximo = lista[posicion];
				conteoMax = 1;
			}
			
			if (lista[posicion]==minimo){
				conteoMin++;
			}
			else if (lista[posicion]<minimo){
				minimo = lista[posicion];
				conteoMin = 1;	
			}

			posicion++;
			List<Integer> resultado = conteoMaximo(lista, maximo, minimo, conteoMax, conteoMin, posicion);
			return resultado;
		}		
	}	
}