import java.io.*;
import java.util.*;

public class ProblemaMochila {
   public static List<Producto> cargarProductos(String nombreFichero) 
                                throws ClassNotFoundException,IOException {
      ObjectInputStream lector=new ObjectInputStream(new FileInputStream(nombreFichero));
      List<Producto> listaProductos=(List<Producto>)lector.readObject();
      lector.close();
      return listaProductos;
   }
   public static void almacenarProductos(List<Producto> listaProductos,String nombreFichero)
                      throws IOException {
      ObjectOutputStream escritor=new ObjectOutputStream(new FileOutputStream(nombreFichero)); 
      escritor.writeObject(listaProductos);
      escritor.flush();
      escritor.close();
   }
   public static List<Producto> cargarProductosTxt(String nombreFichero) 
                                throws FileNotFoundException,IOException {    
      List<Producto> listaProductos=new ArrayList();
      String linea;
      BufferedReader lector=new BufferedReader(new FileReader(nombreFichero));
      while ((linea=lector.readLine())!=null) {
         StringTokenizer troceador=new StringTokenizer(linea,",");
         int peso=Integer.valueOf(troceador.nextToken());
         float precioUnitario=Float.valueOf(troceador.nextToken())/peso;
         listaProductos.add(new Producto(peso,precioUnitario));
      }       
      lector.close();
      return listaProductos;
   }
  
   public static List<Producto> mochila(List<Producto> listaProductos,int pesoMochila) {
      Collections.sort(listaProductos);
      List<Producto> lista=new ArrayList();
      ListIterator<Producto> iterador=listaProductos.listIterator(listaProductos.size());
      while (iterador.hasPrevious() && pesoMochila>0) {
         Producto producto=iterador.previous();
         int pesoProducto=producto.getPeso();
         if (pesoMochila>=pesoProducto) {
            lista.add(new Producto(pesoProducto,producto.getPrecioUnitario()));
            pesoMochila=pesoMochila-pesoProducto;
         }
         else {
            lista.add(new Producto(pesoMochila,producto.getPrecioUnitario()));
            pesoMochila=0;
         }        
      }
      if (pesoMochila>0)
         return new ArrayList();    
      else return lista;
   }
}
