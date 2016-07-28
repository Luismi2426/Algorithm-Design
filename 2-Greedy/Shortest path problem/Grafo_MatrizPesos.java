import java.text.DecimalFormat;

public class Grafo_MatrizPesos {
   private int numeroVertices;
   private int numeroAristas;
   private double[][] matrizAdyacencia;
    
   /* Grafo vacio */
   public Grafo_MatrizPesos(int numeroVertices) {
      if (numeroVertices<=0) throw new IllegalArgumentException("Parametro fuera de rango");
      this.numeroVertices=numeroVertices;
      this.numeroAristas=0;
      this.matrizAdyacencia=new double[numeroVertices][numeroVertices];
      for (int origen=0;origen<this.numeroVertices;origen++)  
         for (int destino=0;destino<this.numeroVertices;destino++)
            this.matrizAdyacencia[origen][destino]=Double.POSITIVE_INFINITY;    
   }
   /* Grafo aleatorio */
   public Grafo_MatrizPesos(int numeroVertices,int numeroAristas) {
      this(numeroVertices);
      if ((numeroAristas<=0)||(numeroAristas>numeroVertices*numeroVertices)) 
         throw new IllegalArgumentException("Parametro fuera de rango");
      while (this.numeroAristas!=numeroAristas) {
         int origen=(int)(numeroVertices*Math.random());
         int destino=(int)(numeroVertices*Math.random());
         double peso=numeroVertices*Math.random();
         addArista(origen,destino,peso);        
      }
   }
   public int getNumeroVertices() { return this.numeroVertices; }
   public int getNumeroAristas()  { return this.numeroAristas; }
   public double getArista(int origen,int destino) { 
      return this.matrizAdyacencia[origen][destino]; 
   }
   public boolean addVertice() {
      double[][] auxiliar=new double[this.numeroVertices+1][this.numeroVertices+1];
      for (int origen=0;origen<this.numeroVertices;origen++)  
         for (int destino=0;destino<this.numeroVertices;destino++)
            auxiliar[origen][destino]=this.matrizAdyacencia[origen][destino];
      for (int origen=0;origen<this.numeroVertices;origen++)  
         auxiliar[origen][this.numeroVertices]=Double.POSITIVE_INFINITY; 
      for (int destino=0;destino<this.numeroVertices;destino++)
         auxiliar[this.numeroVertices][destino]=Double.POSITIVE_INFINITY;  
      this.numeroVertices++;
      this.matrizAdyacencia=auxiliar;
      return true; 
   }
   public boolean addArista(int origen,int destino,double peso) { 
      double aristaDefinida=this.matrizAdyacencia[origen][destino]; 
      if (Double.isInfinite(aristaDefinida)) numeroAristas++;
      this.matrizAdyacencia[origen][destino]=peso;
      return Double.isInfinite(aristaDefinida);
   }
   public String toString() {
      String cadena="";
      DecimalFormat df = new DecimalFormat("#,###,##0.00");
      for (int origen=0;origen<this.numeroVertices;origen++) {
         cadena+=(origen+": ");       
         for (int destino=0;destino<this.numeroVertices;destino++)
            if (!Double.isInfinite(this.matrizAdyacencia[origen][destino]))
               cadena+=("["+destino+": "+df.format(this.matrizAdyacencia[origen][destino])+"] ");    
         cadena+="\n";    
      }
      return cadena;
   }
}
