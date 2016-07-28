import java.util.*;
import java.io.*;

public class PruebaMonedas{
	
	public static List<Integer> cargarTxt(String nombreFichero)
			throws FileNotFoundException, IOException, IllegalArgumentException {    
		List<Integer> lista = new ArrayList();
		String linea;
		BufferedReader lector = new BufferedReader(new FileReader(nombreFichero));
		while ((linea = lector.readLine()) != null){
			StringTokenizer troceador = new StringTokenizer(linea,",");
			while (troceador.hasMoreTokens()){
				int dato = Integer.valueOf(troceador.nextToken());
				lista.add(dato);
			}
		}       
		lector.close();
		return lista;
	}
	
	public static void main (String[] args) throws IOException, IllegalArgumentException, CloneNotSupportedException{
		List<Integer> lista = cargarTxt("/home/luismi/Documentos/Universidad/DIAL/Ejercicios/monedas.txt");
		int[] array = new int[lista.size()];
		int cambio = lista.get(0);
		lista.remove(0);
		for(int i = 0; i<lista.size(); i++){
			array[i] = lista.get(i);
		}
	    List<String> resultado = Monedas.monedas(array, cambio);
	    System.out.println(cambio);
	    System.out.println(lista);
	    System.out.println(resultado);

	}
}