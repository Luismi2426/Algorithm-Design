import java.util.*; 
import java.io.*;

public class PruebaPunto{

	public static Punto cargarTxt(String nombreFichero)
			throws FileNotFoundException, IOException, IllegalArgumentException {    
		String linea;
		BufferedReader lector = new BufferedReader(new FileReader(nombreFichero));
		linea = lector.readLine();
		StringTokenizer troceador = new StringTokenizer(linea,",");
		int x = Integer.valueOf(troceador.nextToken());
		int y = Integer.valueOf(troceador.nextToken());
		Punto destino = new Punto(x,y);
		lector.close();
		return destino;
	}

	public static void main(String[] args) throws IOException, IllegalArgumentException, CloneNotSupportedException {
		try {
			
			Punto destino = cargarTxt("/media/alumno/KINGSTON/DIAL/Practica/Puntos/destino.txt");  
		    List<List<Punto>> seleccion = SeleccionCamino.listaCaminos(destino); 
		    for (int i=0; i<seleccion.size();i++){
		    	System.out.println("Camino: " + seleccion.get(i).toString());
		    }
		    System.out.println("Numero caminos: " + seleccion.size());
		}
		catch(IllegalArgumentException e){
			System.err.println(e.getMessage());
		}
		
	}
}
