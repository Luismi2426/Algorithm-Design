import java.util.*;

public class Grafo_Algoritmos {
   public static int[] recorridoAnchura(Grafo_MatrizPesos grafo,int origen) {
      int[] visitados=new int[grafo.getNumeroVertices()];
      for (int j=0;j<grafo.getNumeroVertices();j++) 
         visitados[j]=-1;    
      int ordenVisita=0;
      Queue<Integer> pendientes=new LinkedList<Integer>();
      if (visitados[origen]<0) {
         visitados[origen]=ordenVisita++;
         pendientes.add(new Integer(origen));
         while (!pendientes.isEmpty()) {
            int vertice=((Integer)pendientes.poll()).intValue();
            for (int j=0;j<grafo.getNumeroVertices();j++) {
               double peso=grafo.getArista(vertice,j);
               if (!Double.isInfinite(peso))
                  if (visitados[j]<0) {
                     visitados[j]=ordenVisita++;
                     pendientes.add(new Integer(j));
                  }  
            }
         }
      }
      return visitados;
   }  
   public static double[] caminosMinimos(Grafo_MatrizPesos grafo,int origen) {
      double[] costeCaminos=new double[grafo.getNumeroVertices()];
      Set<Integer> pendientes=new HashSet<Integer>();
      for (int j=0;j<grafo.getNumeroVertices();j++)
         pendientes.add(new Integer(j));
      pendientes.remove(new Integer(origen));
      for (int j=0;j<grafo.getNumeroVertices();j++)
         costeCaminos[j]=grafo.getArista(origen,j);
      while (!pendientes.isEmpty()) {
         int verticeMinimo=-1;
         double minimoParcial=Double.POSITIVE_INFINITY;
         for (Iterator<Integer> iterador=pendientes.iterator(); iterador.hasNext();) { 
            int j=iterador.next().intValue(); 
            if (minimoParcial>costeCaminos[j]) {
               minimoParcial=costeCaminos[j];
               verticeMinimo=j;
            }
         }   
         pendientes.remove(new Integer(verticeMinimo));  
         for (Iterator<Integer> iterador=pendientes.iterator(); iterador.hasNext();) { 
            int j=iterador.next().intValue(); 
            costeCaminos[j]=Math.min(costeCaminos[j],costeCaminos[verticeMinimo]+grafo.getArista(verticeMinimo,j));     
         }    
      } 
      return costeCaminos;
   }
}
