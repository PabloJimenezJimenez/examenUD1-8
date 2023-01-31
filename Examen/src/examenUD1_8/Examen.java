package examenUD1_8;


import java.util.*;

public class Examen {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int total;
		String listaCompraJuan;
		String[]listaJuanseparado;
		ArrayList<String> listadoJuan;
		TreeSet<String>listadoMarta= new TreeSet<>();
		TreeMap<String, Integer> precio= new TreeMap<>();
		//Pido a Juan que me introduzca la lista
		System.out.println("Hola Juan, introduce tu lista de la compra:");
		listaCompraJuan=sc.nextLine();
		//Separo la lista por las comas usando split
		listaJuanseparado=listaCompraJuan.split(",");
		//Llamo a la funcion listadoJuan
		listadoJuan=listadoJuan(listaJuanseparado);
		//Imprimo la lista de Juan
		System.out.println("Listado Juan: "+listadoJuan);
		System.out.println();
		//Imprimo el listado de Marta
		System.out.println("Listado de Marta:");
		//Llamo a la funcion listadoMarta
		listadoMarta=listadoMarta(listadoJuan);
		System.out.println(listadoMarta);
		System.out.println();
		System.out.println("Rosa pasa los articulos por su caja");
		//Llamo a la función ponerValor
		precio=ponerValor(listadoMarta);
		System.out.println();
		//Imprimo el ticket de la compra
		System.out.println("Ticket de compra");
		//Llamo al procedimiento mostrarTreeMap
		mostrarTreeMap(precio);
		//Llamo a la función total
		total=totalCompra(precio);
		//Imprimo el total
		System.out.printf("TOTAL %6d€",total);
		

	}
	
	//Creo un funcion de tipo ArrayList que reciba un array de string como argumento y me devuelva 
	//una lista de tipo string.
	public static ArrayList<String> listadoJuan(String[]listaJuanseparado){
		ArrayList<String> listadoJuan= new ArrayList<>();
		//Añado el array a la lista
		listadoJuan.addAll(Arrays.asList(listaJuanseparado));
		//Llamo a la funcion listadoFinalJuan
		ArrayList<String> listadoFinalJuan=listadoFinalJuan(listadoJuan);
		return listadoFinalJuan;
	}
	
	//Creo una funcion de tipo ArrayList que reciba como argumento un ArrayList y me devuelva un 
	//ArrayList con los mismo elementos pero con mas estetica.
	public static ArrayList<String> listadoFinalJuan(ArrayList<String> listadoJuan){
		ArrayList<String> listadoFinalJuan= new ArrayList<>();
		for(int i=0;i<listadoJuan.size();i++) {
			String producto=listadoJuan.get(i);
			//Quito los espacios en blanco
			producto=producto.trim();
			//Pongo en minuscula toda la palabra
			producto=producto.toLowerCase();
			//Cambio la primera letra por mayuscula
			producto=producto.replaceFirst(producto.substring(0, 1), producto.substring(0,1).toUpperCase());
			listadoFinalJuan.add(producto);
		}
		return listadoFinalJuan;
	}
	
	//Creo una función que reciba como argumento un ArrayList y me devuelva un TreeSet
	public static TreeSet<String>listadoMarta(ArrayList<String> listadoJuan){
		TreeSet<String>listadoMarta= new TreeSet<>();
		//Añado la lista
		listadoMarta.addAll(listadoJuan);
		return listadoMarta;
	}
	
	//Creo una funcion que reciba por argumento un TreeSet y me devuelva un TreeMap con la
	//key de tipo String y el value de tipo Integer
	public static TreeMap<String, Integer> ponerValor(TreeSet<String>listadoMarta){
		ArrayList<String>listaCompra= new ArrayList<>();
		//Añado el treeSet a  una lista
		listaCompra.addAll(listadoMarta);
		TreeMap<String, Integer> precio= new TreeMap<>();
		// Hago un for para poner los valores en el TreeMap. La key sera el nombre del producto
		//y el valor lo que vaya introduciendo la cajera.
		for(int i=0;i<listadoMarta.size();i++) {
			System.out.print(listaCompra.get(i)+" ");
			precio.put(listaCompra.get(i), sc.nextInt());
			
		}
		return precio;
	}
	
	//Creo un procedimiento para mostrar el TreeMap
	public static void mostrarTreeMap(TreeMap<String, Integer>listaPrecio) {
		for (Map.Entry<String, Integer> elem : listaPrecio.entrySet()) {
			System.out.printf("%-9s %d€ \n",elem.getKey(),elem.getValue());
		}
	}
	
	//Creo una funcion de tipo int que reciba como argumento un diccionario y me devuelva la 
	//suma de todos los valores
	public static int totalCompra(TreeMap<String, Integer>listaPrecio) {
		int total=0;
		//Recorro el diccionario
		for (Map.Entry<String, Integer> elem : listaPrecio.entrySet()) {
			//sumo a total el valor del elemento
			total+=elem.getValue();
		}
		return total;
	}
}
