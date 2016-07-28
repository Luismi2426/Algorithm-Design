// Diseño de Algoritmos 14/15
// Luis Miguel Barbero Juvera

import java.util.*;

public class SeleccionActividades{
	
	//Comprueba si dos actividades estan solapadas (true = Solapadas // false = No solapadas)
	public static boolean solaparse(Actividad act1, Actividad act2){
		boolean resultado = true;
		if ((act1.getComienzo() >= act2.getFinalizacion()) || (act2.getComienzo() >= act1.getFinalizacion())){
			resultado = false;
		}
		return resultado;
	}
	
	public static List<Actividad> seleccion(List<Actividad> listaActividades){
		int longitud = listaActividades.size();
		//Ordenar la lista con las actividades por instante de finalizacion
		Collections.sort(listaActividades, Actividad.FinComparator);
		//Crear una lista donde guardar las actividades escogidas
		List<Actividad> seleccion = new ArrayList();
		//Crear un iterador y meter la primera actividad en la seleccion
		ListIterator<Actividad> iterador = listaActividades.listIterator(0);
		seleccion.add(iterador.next());
		
		//Introducir mas actividades si no se solapan
		while(iterador.hasNext()){
			Actividad ultima = seleccion.get(seleccion.size()-1);
			Actividad candidato = iterador.next();
			if (!solaparse(ultima,candidato)){
				seleccion.add(candidato);
			}
		}
		return seleccion;
	}
}
