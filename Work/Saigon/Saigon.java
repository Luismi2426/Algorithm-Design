import java.util.*;

public class Saigon {
	
	public static List<Movimiento> solucionSaigon(List<Movimiento> lista, int discos, String origen, String destino, String aux1, String aux2){
    	if(discos>=1 && discos<=3){
			Hanoi.solucionHanoi(lista, discos, origen, destino, aux1);  		
    	}
    	
    	else if(discos>3){
    		int k = discos/2;
    		solucionSaigon(lista, discos-k, origen, aux2, aux1, destino);
    		Hanoi.solucionHanoi(lista, k, origen, destino, aux1);
        	solucionSaigon(lista, discos-k, aux2, destino, aux1, origen);
    	}
    	return lista;
	}
	
	public static List<Movimiento> saigon(int discos){
		List<Movimiento> lista = new ArrayList();
	   	List<Movimiento> resultado = solucionSaigon(lista, discos, "Origen", "Destino", "Aux1", "Aux2");
	   	return resultado;
	}

}



