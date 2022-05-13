package jcolonia.daw2021.SumatorioMVC2021;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Iker Sierra Plaza
 * 
 * Gestiona la vista del menú mostrando sus opciones y pidiendo la opción elegida al usuario por pantalla.
 */
public class VistaMenúBásico extends Vista {

	/**
	 * Las opciones del menú.
	 */
	private String[] textoOpciones;

	/**
	 * Texto visible para identificar la vista.
	 */
	private String título = getTítulo();

	/**
	 * La opción elegida del menú.
	 */
	private int opciónElegida;

	/**
	 * Hereda el título y la entrada de la clase Vistas.
	 * Se le pasan las opciones del menú en un String [].
	 * 
	 * @param título El título de la opción del menú.
	 * @param sc La entrada por pantalla.
	 * @param textoOpciones Las opciones numeradas visibles en el menú.
	 */
	public VistaMenúBásico(String título, Scanner sc, String[] textoOpciones) {
		super(título, sc);
		this.textoOpciones = new String[textoOpciones.length];
		this.título = título;
		for (int i = 0; i < textoOpciones.length; i++) {
			this.textoOpciones[i] = textoOpciones[i];
		}
	}

	/**
	 * Muestra las opciones del menu.
	 */
	public void mostrarOpciones() {
		int i = 1;
		for (String vuelta : textoOpciones) {
			System.out.printf("%d- %s%n", i, vuelta);
			i++;
		}
		System.out.printf("%n");
		System.out.println("0- Salir");
	}
	
	/**
	 * Solicita la opción al usuario.La opción tiene que ser un entero dentro del
	 * rango del array. Si no es una opción válida vuelve a pedirla.
	 * 
	 * @return opciónElegida el número de la opción elegida
	 */
	public int pedirOpción() {
		String líneaTexto;
		int número;

		System.out.print("Introduce la opción del menú elegida: ");
		boolean númeroCorrecto = false;
		Scanner entrada = getEntrada();

		while (!númeroCorrecto) {
			
			try {
				líneaTexto = entrada.nextLine();
				número = Integer.parseInt(líneaTexto);
				
				if (número < 0 || número > textoOpciones.length) {
					System.out.println("No ha elegido una opción válida.");
				} else {
					númeroCorrecto = true;
					opciónElegida = número;
				}
			} catch (NumberFormatException | NoSuchElementException ex) {
				System.out.println("No es una de las opciones válidas.");
			}
		}
		return opciónElegida;
	}
	
	
}
