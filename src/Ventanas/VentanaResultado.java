package Ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import controlador.Coordinador;
import modelo.ModeloDeDatos;

public class VentanaResultado extends JFrame implements ActionListener  {
	
	private Coordinador miCoordinador;
	
	private JTextArea textArea; 
	private JPanel panelResultado;
	private JScrollPane scrollPane;
	private JButton btnConsultar;
	private JButton btnSalir;
	
	
	public VentanaResultado() {
		
		
		iniciarComponente();
		setTitle("Resultados");
		setSize(400,400);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	
	private void iniciarComponente() {
		
		panelResultado = new JPanel();
		panelResultado.setBackground(new Color (97, 161, 70));
		panelResultado.setLayout(null);
		
		textArea= new JTextArea();
		textArea.setBounds(240,60,250,200);
		textArea.setLineWrap(true); // Ajustar el texto a la línea
		textArea.setWrapStyleWord(true); // Ajustar las palabras en lugar de cortar palabras
		textArea.setEditable(false); // Solo para mostrar, no editable
		
		scrollPane = new JScrollPane(textArea); 
	    scrollPane.setBounds(60, 60, 250, 200);
	    
	    btnConsultar= new JButton("Consultar");
		btnConsultar.setBounds(60,300,100,25);
		btnConsultar.addActionListener(this);
		
		btnSalir= new JButton("Salir");
		btnSalir.setBounds(180,300,100,25);
		btnSalir.addActionListener(this);
	    
	    panelResultado.add(scrollPane);
	    panelResultado.add(btnConsultar);
	    panelResultado.add(btnSalir);
	    
	    add(panelResultado);
		
		
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConsultar) {
			//Limpia el cambo de texto antes de la consulta
			  textArea.setText("");
			  
		        String valor = "";
		        List<String> resultados; 
		        
		        //Preguntar el metodo de busqueda por numero
		        int criterio = Integer.parseInt(JOptionPane.showInputDialog("¿Cómo desea realizar su búsqueda? \n\n"
		                + "1. Nombre \n"
		                + "2. Correo \n\n"
		                + "Ingrese un numero:\n"));
		        
		        if (criterio == 1) {
		            String nombre = "nombre";
		            valor = JOptionPane.showInputDialog("Ingrese el " + nombre + " del contacto que desea encontrar:");
		         // Devuelve una lista de resultados
		            resultados = miCoordinador.consultarPersona(nombre, valor); 
		            
		        } else if (criterio == 2) {
		            String correo = "correo";
		            valor = JOptionPane.showInputDialog("Ingrese el " + correo + " del contacto que desea encontrar:");
		         // Devuelve una lista de resultados
		            resultados = miCoordinador.consultarPersona(correo, valor); 
		        } else {
		            JOptionPane.showMessageDialog(null, "Opción inválida");
		         // Salir del método si la opción es inválida
		            return; 
		        }

		        // Crear un StringBuilder para juntar todos los resultados
		        StringBuilder cadena = new StringBuilder();
		        //Validacion de que resultados no esta vacio
		        if (resultados.isEmpty()) {
		        	//Si esta vacio agrega a cadena el mensaje que estara en el TextArea
		            cadena.append("No se encontraron contactos que coincidan con el criterio.");
		        } else {
		        	//Recorre en un ciclo forEach el resultado
		            for (String resultado : resultados) {
		            	// Agregar cada resultado a la cadena
		                cadena.append(resultado).append("\n"); 
		            }
		        }

		        // Mostrar los resultados en el textArea
		        textArea.setText(cadena.toString());
		        
    		
		}else if(e.getSource()== btnSalir) {
			this.setVisible(false);
		}
	}


	public void setCoordinador(Coordinador miCoordinador) {
	    this.miCoordinador = miCoordinador;
	}
	
}
