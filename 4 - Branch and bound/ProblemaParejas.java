import java.util.*;

public class ProblemaParejas{
	
	public static int[] asignarParejas(int[][] tabla){
		PriorityQueue <NodoPareja> cola = new PriorityQueue<NodoPareja>();
		NodoPareja nodoActual = new NodoPareja(tabla);
		NodoPareja nodoMejor = new NodoPareja(tabla);
		
		for (int i=0; i<tabla.length/2; i++){
			nodoMejor.addPareja(i, i+tabla.length/2);
			do{
				for(int p1=0; p1<tabla.length; p1++){
					for(int p2=0; p2<tabla.length; p2++){
						NodoPareja nodoHijo = nodoActual.hijo(p1,p2);
						if (nodoHijo.compareTo(nodoMejor)>0){
							if (nodoHijo.completo()){
								nodoMejor = nodoHijo;
							}
							else{
								cola.add(nodoHijo);
							}
						}
						else{
							nodoActual=cola.poll();
						}
					}
				}
			}
			while(!nodoActual.completo());
		}
		
		return nodoMejor.getParejas();
	}

}