import java.util.*;

public class PruebaBinaria{
	
	public static void main (String[] args){
		int[] lista = {7,8,9,4,5,6,1,3,2,3};
		int buscar = 8;  
		Integer[] lista2 = {7,8,9,4,5,6,1,3,2,3};
		Integer buscar2 = 8; 
		boolean iterativa = Binaria.busquedaBinariaIterativa(lista,buscar);
		boolean recursiva = Binaria.busquedaBinariaRecursiva(lista,buscar);
		System.out.println("Recursiva: " + recursiva);
		System.out.println("Iterativa: " + iterativa);
		boolean iterativa2 = Binaria2.busquedaBinariaIterativa(lista2,buscar2);
		boolean recursiva2 = Binaria2.busquedaBinariaRecursiva(lista2,buscar2);
		System.out.println("Recursiva2: " + recursiva2);
		System.out.println("Iterativa2: " + iterativa2);
	}

}

