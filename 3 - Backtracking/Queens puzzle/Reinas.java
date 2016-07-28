import java.util.*;

public class Reinas {
	private static void reinasRecursivo (int columnaActual, int[] distribucionActual, List listaDistribucionActual){
		int n = distribucionActual.length;
		if(columnaActual == n){
			listaDistribucionActual.add(distribucionActual);
		}
		
		else{
			for (int i=0; i<n; i++){
				distribucionActual[columnaActual] = i;
				if (distribucionFactible(distribucionActual, columnaActual)){
					int columnaAuxiliar = columnaActual;
					int[] distribucionAuxiliar = Arrays.copyOf(distribucionActual, distribucionActual.length);
					reinasRecursivo(columnaAuxiliar+1, distribucionAuxiliar, listaDistribucionActual);
				}
			}
		}	
	}
	
	public static boolean distribucionFactible(int[] distribucion, int columna){
		boolean resultado = true;
		for (int i=0; i<columna; i++){
			if(distribucion[i]==distribucion[columna]){
				resultado = false;
			}
			else if(distribucion[i]+i == distribucion[columna]+columna ||
					distribucion[i]-i == distribucion[columna]-columna){
				resultado = false;
			}	
		}
		return resultado;
	}
	
	public static void main (String [] args) {
		int[] distribucion = new int[5];
		int columna = 0;
		List lista = new ArrayList();
		reinasRecursivo(columna, distribucion, lista);
		for(int i=0; i<lista.size(); i++){
			List listilla = new ArrayList();
			int[] array = (int[]) lista.get(i);
			for (int j=0;j<array.length;j++){
				listilla.add(array[j]);	
			}
			System.out.println(listilla);
		}
		
		
	}
}