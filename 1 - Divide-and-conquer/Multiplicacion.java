import java.util.*;


public class Multiplicacion {

    public static long productoClasico(long factor1, long factor2, int n) {
        long[] array1 = new long[n];
        long[] array2 = new long[n];
        
        for (int i=0; i<n; i++) {
            long resto1 = factor1%10;
            factor1 = factor1/10;
            array1[i] = resto1;

            long resto2 = factor2%10;
            factor2 = factor2/10;
            array2[i] = resto2;
        }

        long total = 0;
        long aux = 1;

        for (int j=0; j<n; j++) {
            long valor1 = array1[j];
            long aux2 = 1;
            for (int k=0; k<n; k++) {
                long valor2 = array2[k];
                long valor = valor1*valor2*aux;
                total = total + valor*(aux2);
                aux2 = aux2*10;
            }
            aux = aux*10;
        }

        return total;
    }



    public static long productoKaratsuba(long factor1, long factor2, int n){
        long total = 0;

        if (n>3) {
            long factor11 = factor1;
            long factor21 = factor2;
            long factor12;
            long factor22;
            long aux = 1;

            for (int i=0; i<n/2; i++) {
                factor11 = factor11/10;
                factor21 = factor21/10;
                aux = aux*10;
            }

            factor12 = factor1-(factor11*aux);
            factor22 = factor2-(factor21*aux);

            long z0 = factor12*factor22; 
            long z2 = factor11*factor21;
            long z1 = (factor11+factor12)*(factor21+factor22)-z2-z0;
                        
            long b1 = (long) Math.pow(10,n/2);
            long b2 = (long) Math.pow(10,n/2 *2);                     

            total = z2*b2 + z1*b1 + z0;
            
        }

        else {
            total = total = productoClasico(factor1, factor2, n);
        }

        return total;
    }   

    
    public static void main(String [] args) {

        Scanner usuario = new Scanner(System.in);

        System.out.print("Factor1: ");
        long a = usuario.nextLong();
        
        System.out.print("Factor2: ");
        long b = usuario.nextLong();

        System.out.print("Digitos de los factores: ");
        int c = usuario.nextInt();
       

        long karat   = Multiplicacion.productoKaratsuba(a,b,c);
        long clasico = Multiplicacion.productoClasico(a,b,c);
	long auto    = a*b;

        System.out.print("Son iguales: ");
        System.out.println(auto == clasico);
        System.out.print("Karatusuba: ");
        System.out.println(karat);
        System.out.print("Clasico: ");
        System.out.println(clasico);  
	System.out.print("Auto: ");
        System.out.println(auto); 
    }
}
