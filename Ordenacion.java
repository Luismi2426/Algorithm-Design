import java.util.*;

public class Ordenacion {
	
	public static void ordenacionMezcla(int[] lista){
		int[] solucion = new int[lista.length];
		ordenacion(lista, solucion, 0, lista.length-1);
	}
	
	public static void ordenacion(int[] lista, int[] solucion, int inferior, int superior){
		if (inferior<superior){
			int medio = (superior+inferior)/2;
			ordenacion(lista, solucion, inferior, medio);
			ordenacion(lista, solucion, medio+1, superior);
			mezcla(lista, solucion, inferior, medio+1, superior);
		}
	}

	public static void mezcla (int[] lista, int[] solucion, int inferior1, int inferior2, int superior2){
		int superior1 = inferior2-1;
		int elementos = superior2 - inferior1 +1;
		int posicion = inferior1;
		while (inferior1 <= superior1 && inferior2 <= superior2){
			if (lista[inferior1] < lista[inferior2]){
				solucion[posicion++] = lista[inferior1++];
				//posicion++;
				//inferior1++;
			}
			else {
				solucion[posicion++] = lista[inferior2++];	
				//posicion++;
				//inferior2++;
			}
		}
		while (inferior1<=superior1){
			solucion[posicion] = lista[inferior1];
			posicion++;
			inferior1++;
		}
		while (inferior2<=superior2){
			solucion[posicion] = lista[inferior2];
			posicion++;
			inferior2++;
		}

        for(int i=0; i<elementos; i++, superior2--){
            lista[superior2] = solucion[superior2];
        }
	}
}
