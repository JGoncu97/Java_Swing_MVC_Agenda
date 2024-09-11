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
	    	//Inicializacion de MiModelo en Coordinador para que todas las clases manejen el mismo Modelo
	    	miModelo = new ModeloDeDatos();
	    	
	    	
	    }
	    
	    //Coordinador con Ventana Principal
	    public void setVentanaP(VentanaPrincipal miPpal) {
	        this.miPpal = miPpal;
	    }
	    //Coordinador con Ventana resultado
	    public void setVentanaR(VentanaResultado miResultado) {
	        this.miResultado = miResultado;
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

	    

		public List<String> consultarPersona(String criterio, String valor) {
			// Recibimos la lista de contactos 
		    List<String> contactosEncontrados = miModelo.consultarContacto(criterio, valor);
		    //Mandamos la lista de contactos
		    return contactosEncontrados; 

		}
	    
	
}
