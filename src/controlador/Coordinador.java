package controlador;

import Ventanas.Ventana;
import modelo.ModeloDeDatos;

public class Coordinador {

	
	
	
	private Ventana miVentana;
	private ModeloDeDatos miModelo;

	public void setVentana(Ventana miVentana) {
		// TODO Auto-generated method stub
		this.miVentana= miVentana;
	}

	public void setModelo(ModeloDeDatos miModelo) {
		// TODO Auto-generated method stub
		this.miModelo = miModelo;
	}

	public ModeloDeDatos getModelo() {
	    return miModelo;
	}
	public Ventana getVentana() {
	    return miVentana;
	}

	
	

}
