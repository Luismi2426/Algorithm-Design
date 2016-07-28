import java.util.*;

public class Monedas{
	public static List<String> monedas(int[] sistema, int cambio){
		Arrays.sort(sistema);
		int posicion = sistema.length-1;
		List<String> listaCambio = new ArrayList();
		while (posicion>=0 && cambio>0){
			int numeroMonedas = cambio/sistema[posicion]; 
			listaCambio.add(sistema[posicion]+"-"+numeroMonedas);
			cambio = cambio%sistema[posicion];
			posicion--;
		}
		return listaCambio;
	}
}