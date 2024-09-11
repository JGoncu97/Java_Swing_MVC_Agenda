package controlador;

import java.util.List;

import Ventanas.VentanaPrincipal;
import Ventanas.VentanaRegistro;
import Ventanas.VentanaResultado;
import modelo.ModeloDeDatos;

public class Coordinador {

	 	private VentanaPrincipal miPpal;
	    private VentanaRegistro miVentana;
	    private ModeloDeDatos miModelo;
	    private VentanaResultado miResultado;
	   
	    
	    public Coordinador() {
	    	
	    	miModelo = new ModeloDeDatos();
	    	
	    	
	    }

	    public void setVentana(VentanaRegistro miVentana) {
	        this.miVentana = miVentana;
	    }

	    public void setModelo(ModeloDeDatos miModelo) {
	        this.miModelo = miModelo;
	    }

	    public ModeloDeDatos getModelo() {
	        return miModelo;
	    }

	    public VentanaRegistro getVentana() {
	        return miVentana;
	    }

	    public void setVentanaP(VentanaPrincipal miPpal) {
	        this.miPpal = miPpal;
	    }

	    public void setVentanaR(VentanaResultado miResultado) {
	        this.miResultado = miResultado;
	    }

		
		
		public List<String> consultarPersona(String criterio, String valor) {
			// Aquí deberías recibir una lista de contactos en lugar de un único String
		    List<String> contactosEncontrados = miModelo.consultarContacto(criterio, valor);
		    return contactosEncontrados; // Devuelves la lista de contactos
		}
	    
	
}
