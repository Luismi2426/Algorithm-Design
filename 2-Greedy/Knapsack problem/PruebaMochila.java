import java.io.*;
import java.util.*;

public class PruebaMochila{
	public static void main(String[] args) throws IOException, IllegalArgumentException {
		try {
			List<Producto> lista = ProblemaMochila.cargarProductosTxt("/home/luismi/Documentos/Universidad/DIAL/2 - Voraz/Problema Mochila/datos.txt");  
			List<Producto> seleccion = ProblemaMochila.mochila(lista, 10);
			System.out.println(seleccion.toString());
		}
		catch(IllegalArgumentException e){
		System.err.println(e.getMessage());
		}
	}
}
