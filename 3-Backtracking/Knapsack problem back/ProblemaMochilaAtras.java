import java.util.*;

public class ProblemaMochilaAtras{
	public static void mochilaRecursivo(List<Producto> lista, int pesoMaximo, int posicion, Mochila mochila, List<Mochila> listaMochila){
		if (posicion == lista.size()){
			listaMochila.add(mochila);
		}
		else{
			Mochila mochilaAux = (Mochila) mochila.clone();
			mochilaRecursivo(lista, pesoMaximo, posicion+1, mochilaAux, listaMochila);
			if(mochila.getPeso()+lista.get(posicion).getPeso()<=pesoMaximo){
				Mochila mochilaAux2 = (Mochila) mochila.clone();
				mochilaAux2.addProducto(lista.get(posicion));
				mochilaRecursivo(lista, pesoMaximo, posicion+1, mochilaAux2, listaMochila);
			}
		}
	}
	
	public static List<Mochila> mochila(List<Producto> lista, int peso){
		Mochila mochila = new Mochila();
		List listaMochila = new ArrayList<Mochila>();
		mochilaRecursivo(lista, peso, 0, mochila, listaMochila);
		return listaMochila;
	}

	public static void mochilaRecursivoOptimo(List<Producto> lista, int pesoMaximo, int posicion, Mochila[] optima, Mochila mochila, List<Mochila> listaMochila){
		
		if (posicion == lista.size()){
			if (mochila.getPrecio() > optima[0].getPrecio()){
				listaMochila.clear();
				listaMochila.add((Mochila) mochila.clone());
				optima[0] = (Mochila) mochila.clone();
			}
			
		}
		else{
			Mochila mochilaAux = (Mochila) mochila.clone();
			mochilaRecursivoOptimo(lista, pesoMaximo, posicion+1, optima, mochilaAux, listaMochila);
			if(mochila.getPeso()+lista.get(posicion).getPeso()<=pesoMaximo){
				Mochila mochilaAux2 = (Mochila) mochila.clone();
				mochilaAux2.addProducto(lista.get(posicion));
				mochilaRecursivoOptimo(lista, pesoMaximo, posicion+1, optima, mochilaAux2, listaMochila);
			}
		}
	}
	
	public static List<Mochila> mochilaOptima(List<Producto> lista, int peso){
		Mochila mochila = new Mochila();
		Mochila[] optima = new Mochila[1];
		optima[0] = new Mochila();
		List listaMochila = new ArrayList<Mochila>();
		mochilaRecursivoOptimo(lista, peso, 0, optima, mochila, listaMochila);
		return listaMochila;
	}
	

}

