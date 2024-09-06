package aplicacion;

import Ventanas.Ventana;
import controlador.Coordinador;
import modelo.ModeloDeDatos;
import modelo.PersonaU;

public class Principal {
	public static void main(String[]args) {
		//Declaramos las clases
		Coordinador miCoordinador;
		Ventana miVentana;
		ModeloDeDatos miModelo;
	
		//instanciamos las clases(Crear: los objetos de las clases)
		miCoordinador= new Coordinador();
		
		miVentana= new Ventana();
		miModelo= new ModeloDeDatos();
		
		//establecemos las relaciones
		miVentana.setCoordinador(miCoordinador);
		miModelo.setCoordinador(miCoordinador);
		
		//Enviarle una instancia de cada clase al coordinador;
		miCoordinador.setVentana(miVentana);
		miCoordinador.setModelo(miModelo);
		
		miVentana.setVisible(true);
	}
}
