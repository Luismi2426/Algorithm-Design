import java.util.*;

public class PruebaTernaria{
	
	public static void main (String[] args){
		int[] lista = {7,9,4,5,6,1,3,2,3};
		int buscar = 8;  
	    boolean recursiva = Ternaria.busquedaTernariaRecursiva(lista,buscar);
	    boolean iterativa = Ternaria.busquedaTernariaIterativa(lista,buscar);
	    System.out.println("Recursiva: " + recursiva);
	    System.out.println("Iterativa: " + iterativa);
	}

}

