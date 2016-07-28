import java.io.*;
import java.util.*;

public class PruebaMochila{
	
	public static List<Producto> cargarProductosTxt(String nombreFichero) throws FileNotFoundException,IOException {    
		List<Producto> listaProductos=new ArrayList();
		String linea;
		BufferedReader lector=new BufferedReader(new FileReader(nombreFichero));
		while ((linea=lector.readLine())!=null) {
			StringTokenizer troceador=new StringTokenizer(linea,",");
			int peso=Integer.valueOf(troceador.nextToken());
			float precio=Float.valueOf(troceador.nextToken());
			listaProductos.add(new Producto(peso,precio));
		}       
		lector.close();
		return listaProductos;
	}
	
	public static void main(String[] args) throws IOException, IllegalArgumentException {
		try {
			List<Producto> lista = cargarProductosTxt("/home/luismi/Documentos/Universidad/DIAL/3 - Vuelta Atras/Problema Mochila Atras/datos.txt");  
			List<Mochila> seleccion = ProblemaMochilaAtras.mochila(lista, 10);
			List<Mochila> seleccionOptima = ProblemaMochilaAtras.mochilaOptima(lista, 10);
			System.out.println(seleccion);
			System.out.println(seleccionOptima);
		}
		catch(IllegalArgumentException e){
		System.err.println(e.getMessage());
		}
	}

}