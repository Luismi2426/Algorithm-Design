import java.util.*;
import java.io.*;

public class PruebaSaigon{

   public static int cargarTxt(String nombreFichero) 
   		throws FileNotFoundException, IOException, IllegalArgumentException {    
	   String linea;
	   BufferedReader lector = new BufferedReader(new FileReader(nombreFichero));
	   linea = lector.readLine();
	   int discos = Integer.valueOf(linea);
	   lector.close();
	   return discos;
   }

	public static void main(String[] args) throws IOException, IllegalArgumentException, CloneNotSupportedException {
		try{
			int discos = cargarTxt("/media/alumno/KINGSTON/DIAL/Practica/Saigon/discos.txt");
			
	   		List<Movimiento> resultadoHanoi = Hanoi.hanoi(discos);
	   		System.out.println("Hanoi: "+resultadoHanoi.size());
	   		System.out.println("Hanoi: " + resultadoHanoi);
	   		
	   		List<Movimiento> resultadoSaigon = Saigon.saigon(discos);
	   		System.out.println("Saigon: "+resultadoSaigon.size());
	   		System.out.println("Saigon: " + resultadoSaigon);
   		}
   		catch(IllegalArgumentException e){
			System.err.println(e.getMessage());
		}
	}
}
	
