// Diseño de Algoritmos 14/15
// Luis Miguel Barbero Juvera
 
import java.util.*; 
import java.io.*;

public class PruebaActividad{

	public static List<Actividad> cargarTxt(String nombreFichero)
			throws FileNotFoundException, IOException, IllegalArgumentException {    
		List<Actividad> listaActividades = new ArrayList();
		String linea;
		BufferedReader lector = new BufferedReader(new FileReader(nombreFichero));
		while ((linea = lector.readLine()) != null) {
			StringTokenizer troceador = new StringTokenizer(linea,",");
			int comienzo = Integer.valueOf(troceador.nextToken());
			int finalizacion = Integer.valueOf(troceador.nextToken());
			listaActividades.add(new Actividad(comienzo,finalizacion));
		}       
		lector.close();
		return listaActividades;
	}

	public static void main(String[] args) throws IOException, IllegalArgumentException {
		try {
			List<Actividad> lista = cargarTxt("/media/alumno/KINGSTON/DIAL/Practica/Actividad/datosActividad.txt");  
		    List<Actividad> seleccion = SeleccionActividades.seleccion(lista);
		    System.out.println(seleccion.toString());
		}
		catch(IllegalArgumentException e){
			System.err.println(e.getMessage());
		}
		
	}
}
