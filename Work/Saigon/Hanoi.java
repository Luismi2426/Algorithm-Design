import java.util.*;

public class Hanoi{
	
	public static List<Movimiento> solucionHanoi(List<Movimiento> lista, int discos, String origen, String destino, String auxiliar){
		if (discos==1){
			lista.add(new Movimiento(origen, destino));
		}
		
		else if (discos>1){
			solucionHanoi(lista, discos-1, origen, auxiliar, destino);
			lista.add(new Movimiento(origen, destino));
			solucionHanoi(lista, discos-1, auxiliar, destino, origen);
		}
		return lista;
	}
	
	public static List<Movimiento> hanoi(int discos){
		List<Movimiento> lista = new ArrayList();
	   	List<Movimiento> resultado = solucionHanoi(lista, discos, "Origen", "Destino", "Aux");
	   	return resultado;
	}
	
}
