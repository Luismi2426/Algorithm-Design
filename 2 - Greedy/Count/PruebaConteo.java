import java.util.*;
import java.io.*;

public class PruebaConteo{
	
	public static List<Integer> cargarTxt(String nombreFichero)
			throws FileNotFoundException, IOException, IllegalArgumentException {    
		List<Integer> lista = new ArrayList();
		String linea;
		BufferedReader lector = new BufferedReader(new FileReader(nombreFichero));
		linea = lector.readLine();
		StringTokenizer troceador = new StringTokenizer(linea,",");
		while (troceador.hasMoreTokens()){
			int dato = Integer.valueOf(troceador.nextToken());
			lista.add(dato);
		}       
		lector.close();
		return lista;
	}
	
	public static void main (String[] args) throws IOException, IllegalArgumentException, CloneNotSupportedException{
		List<Integer> lista = cargarTxt("/home/luismi/Documentos/Universidad/DIAL/Ejercicios/lista.txt");
		int[] array = new int[lista.size()];
		for(int i = 0; i<lista.size(); i++){
			array[i] = lista.get(i);
		}
	    List<Integer> resultado = Conteo.conteoMaximo(array, array[0], array[0], 0, 0, 0);
	    System.out.println(resultado);

	}
}