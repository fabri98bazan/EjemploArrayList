package ar.edu.unju.ar.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.ar.model.Chofer;
import ar.edu.unju.ar.model.Taxi;

public class main {

	public static Scanner sc=new Scanner(System.in);
	private static List<Chofer> choferes;
	private static List<Taxi> taxis;
	
	public static void main(String[] args) {
		int opc=0;
		precargaChoferes();
		taxis = new ArrayList<>();
		do
		{
			System.out.println("\n*************");
			System.out.println("1. Alta de taxi");
			System.out.println("2. Mostrar choferes");
			System.out.println("3. Mostrar taxis");
			System.out.println("4. Eliminar taxi");
			System.out.println("5. Modificar taxi");
			System.out.println("6. Limpiar lista");
			System.out.println("7. Ordenar Lista");
			System.out.println("8. Salir");
			System.out.println("\n****************");
			System.out.print("Ingrese opcion: ");
			opc=sc.nextInt();
			switch(opc)
			{
				case 1:
					agregarTaxi();
					break;
				case 2:
					mostrarchoferes();
					break;
				case 3:
					mostrarTaxis();
					break;
				case 4:
					eliminarTaxi();
					break;
				case 5: 
					modificarTaxi();
					break;
				case 6:
					taxis.clear();
					break;
				case 7:
					ordenarTaxis();
					break;
				case 8:
					System.out.println("Fin del programa");
					break;
				default: System.out.println("Opcion incorrecta");
			}
		}while(opc!=8);
		
	}

	/**
	 * Se agregar objetos al ArrayList
	 */
	
	public static void precargaChoferes()
	{
		if(choferes == null)
		{
			choferes= new ArrayList<>();
		}
		choferes.add(new Chofer(10,"Maria"));
		choferes.add(new Chofer(20,"Marcos"));
		choferes.add(new Chofer(30,"Luis"));
		choferes.add(new Chofer(40,"Laura"));
		choferes.add(new Chofer(50,"Pedro"));
	}
	
	/**
	 * muestra todos los objetos guardados en el arraylist de choferes
	 */
	public static void mostrarchoferes()
	{
		System.out.println("-----LISTA DE CHOFERES------");
		choferes.forEach(c->System.out.println(c));
	}
	
	/**
	 * agrega objetos taxi a un arraylist
	 */
	
	public static void agregarTaxi()
	{
		Taxi taxi= new Taxi();
		System.out.print("Ingrese matricula de taxi: ");
		taxi.setMatricula(sc.next());
		System.out.print("Ingrese el código de chofer: ");
		int codigochofer=sc.nextInt();
		Chofer chofer=buscarChofer(codigochofer);
		if(chofer==null)
			System.out.println("El chofer no existe");
		else
		{
			taxi.setChofer(chofer);
			taxis.add(taxi);
			System.out.println("Se agrego el objeto taxi...");
		}
	}
	
	/**
	 * busca un objeto chofer dentro del arraylist
	 * arraylist de choferes
	 * @param cod
	 * @return
	 */
	public static Chofer buscarChofer(int cod)
	{
		Chofer choferEncontrado=null;
		
		for(Chofer chof: choferes)
		{
			if(chof.getCod()==cod)
			{
				choferEncontrado=chof;
				break;
			}
		}
		return choferEncontrado;
	}
	
	/**
	 *  muestra todos los objetos del arraylist
	 */
	public static void mostrarTaxis()
	{
		System.out.println("-----LISTA DE TAXIS------");
		taxis.forEach(t->System.out.println(t));
	}
	
	/**
	 * elimina un objeto taxi del
	 * arrayList de taxis
	 */
	
	public static void eliminarTaxi()
	{
		System.out.println("Ingrese la matricula del taxi a eliminar: ");
		String matricula=sc.next();
		Iterator<Taxi> iterator=taxis.iterator();
		if(!taxis.isEmpty())
		{
			while(iterator.hasNext())
			{
				Taxi taxi= iterator.next();
				if(taxi.getMatricula().equals(matricula))
				{
					iterator.remove();
					System.out.println("Se eliminó el taxi con matricula "+matricula);
				}
			}
		}else
			System.out.println("Lista de taxis vacia");
		
	}
	
	
	/**
	 * modificar datos de un taxi, el chofer
	 */
	public static void modificarTaxi()
	{
		System.out.println("-----MODIFICAR TAXI------");
		System.out.print("Ingrese la matricula del taxi: ");
		String matricula=sc.next();
		for(Taxi tax: taxis)
		{
			if(tax.getMatricula().equals(matricula))
			{
				System.out.print("Ingrese nuevo codigo del chofer: ");
				int codigoChofer=sc.nextInt();
				Chofer chofer=buscarChofer(codigoChofer);
				tax.setChofer(chofer);
				System.out.println("Se modifico el chofer");
			}
		}
	}
	
	/**
	 * ordenar la lista de taxis
	 */
	public static void ordenarTaxis()
	{
		System.out.println("---TAXIS ORDENADOS---");
		taxis.sort(Comparator.comparing(Taxi::getMatricula));
		taxis.forEach(t->System.out.println(t));
	}
	
	
	
}
