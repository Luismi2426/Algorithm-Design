import java.util.*;

public class PruebaOrdenacion{
	
	public static void main (String[] args){
		int[] lista = {7,2,3,4,5,6,2,2,2,1,1,4,5,3};
		List<Integer> list = new ArrayList();
	    for (int i=0;i < lista.length;i++){
	        list.add(lista[i]);
	    }
	    System.out.println("Sin orden: " + list);
		Ordenacion.ordenacionMezcla(lista);
		list = new ArrayList();
	    for (int i=0;i < lista.length;i++){
	        list.add(lista[i]);
	    }
	    System.out.println("Con orden: " + list);
	}

}