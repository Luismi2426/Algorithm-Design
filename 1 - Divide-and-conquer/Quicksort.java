import java.util.Random;
public class Quicksort {
    public static Comparable [] generarSecuencia(int longitud) {
        Random generador=new Random();
        Comparable [] solucion=new Comparable[longitud];
        for (int i=0;i<longitud;i++) 
            solucion[i]=generador.nextInt(11);
        return solucion;
    }
    public static Comparable [] generarSecuencia(int [] secuencia) {
        Comparable [] solucion=new Comparable[secuencia.length];
        for (int i=0;i<secuencia.length;i++) 
            solucion[i]=new Integer(secuencia[i]);
        return solucion;
    }
    private static Comparable getPivote(Comparable [] secuencia,int lInferior,int lSuperior) {
        int medio=(lInferior+lSuperior)/2;
        Comparable primero=secuencia[lInferior];
        Comparable central=secuencia[medio];
        Comparable ultimo=secuencia[lSuperior];
        if (primero.compareTo(central)>0) {
            Comparable auxiliar=primero; primero=central; central=auxiliar; }
        if (primero.compareTo(ultimo)>0) {
            Comparable auxiliar=primero; primero=ultimo; ultimo=auxiliar; }
        if (central.compareTo(ultimo)>0) {
            Comparable auxiliar=central; central=ultimo; ultimo=auxiliar; }
        return central;
    }
    public static void ordenacionRapida(Comparable [] secuencia,int lInferior,int lSuperior) {
        int lInf=lInferior; 
        int lSup=lSuperior;
        if (lInf<lSup) {
            Comparable pivote=getPivote(secuencia,lInf,lSup);
            System.out.println(lInferior+" "+lSuperior+" PIVOTE:"+pivote);
            System.out.println(Quicksort.toString(secuencia));
            while (lInf<=lSup) {
                while (secuencia[lInf].compareTo(pivote)<0)
                    lInf++;
                while (secuencia[lSup].compareTo(pivote)>0)
                    lSup--;
                if (lInf<=lSup) {
                    Comparable auxiliar=secuencia[lInf]; 
                    secuencia[lInf]=secuencia[lSup]; 
                    secuencia[lSup]=auxiliar; 
                    lInf++; lSup--;
                }
            }
            Quicksort.ordenacionRapida(secuencia,lInferior,lSup);
            Quicksort.ordenacionRapida(secuencia,lInf,lSuperior);
        }
    }
    public static String toString(Comparable [] secuencia) {
        String resultado="[";
        if (secuencia.length==0)
           resultado+="]";
        else { 
           for (int i=0;i<secuencia.length-1;i++) 
              resultado+=secuencia[i]+", ";
           resultado+=secuencia[secuencia.length-1]+"]";    
        }
        return resultado;
    }
}
