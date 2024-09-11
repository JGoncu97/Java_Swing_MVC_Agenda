package aplicacion;

import Ventanas.VentanaPrincipal;
import Ventanas.VentanaRegistro;
import Ventanas.VentanaResultado;
import controlador.Coordinador;
import modelo.ModeloDeDatos;
import modelo.PersonaU;

public class Principal {
	public static void main(String[]args) {
		 //Declaramos las clases
        Coordinador miCoordinador = new Coordinador();
        VentanaRegistro miVentana = new VentanaRegistro();
        ModeloDeDatos miModelo = new ModeloDeDatos();
        VentanaPrincipal miPpal = new VentanaPrincipal();
        VentanaResultado miResultado = new VentanaResultado();
        
        //establecemos las relaciones
        miVentana.setCoordinador(miCoordinador);
        miModelo.setCoordinador(miCoordinador);
        miPpal.setCoordinador(miCoordinador);
        miResultado.setCoordinador(miCoordinador);
        
        // Enviarle una instancia de cada clase al coordinador;
        miCoordinador.setVentana(miVentana);
        miCoordinador.setModelo(miModelo);
        miCoordinador.setVentanaP(miPpal);
        miCoordinador.setVentanaR(miResultado);
        
        miPpal.setVisible(true);
	}
}
