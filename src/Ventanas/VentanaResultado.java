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
	
	
	private JTextArea textArea; 
	private JPanel panelResultado;
	private JScrollPane scrollPane;
	private Coordinador miCoordinador;
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
	
	public void mostrarResultados(String resultado) {
	    if (resultado != null) {
	        textArea.setText(resultado);
	    } else {
	        textArea.setText("No se encontraron contactos que coincidan con el criterio.");
	    }
	}


	

	public void setCoordinador(Coordinador miCoordinador) {
	    this.miCoordinador = miCoordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConsultar) {
			  textArea.setText(""); // Limpiar el área de texto
		        String valor = "";
		        List<String> resultados; // Cambiamos el tipo a List<String>
		        int criterio = Integer.parseInt(JOptionPane.showInputDialog("¿Cómo desea realizar su búsqueda? \n\n"
		                + "1. Nombre \n"
		                + "2. Correo \n\n"
		                + "Respuesta:\n"));
		        
		        if (criterio == 1) {
		            String nombre = "nombre";
		            valor = JOptionPane.showInputDialog("Ingrese el " + nombre + " del contacto que desea encontrar:");
		            resultados = miCoordinador.consultarPersona(nombre, valor); // Devuelve una lista de resultados
		            
		        } else if (criterio == 2) {
		            String correo = "correo";
		            valor = JOptionPane.showInputDialog("Ingrese el " + correo + " del contacto que desea encontrar:");
		            resultados = miCoordinador.consultarPersona(correo, valor); // Devuelve una lista de resultados
		        } else {
		            JOptionPane.showMessageDialog(null, "Opción inválida");
		            return; // Salir del método si la opción es inválida
		        }

		        // Crear un StringBuilder para juntar todos los resultados
		        StringBuilder sb = new StringBuilder();
		        if (resultados.isEmpty()) {
		            sb.append("No se encontraron contactos que coincidan con el criterio.");
		        } else {
		            for (String resultado : resultados) {
		                sb.append(resultado).append("\n"); // Agregar cada resultado a la cadena
		            }
		        }

		        // Mostrar los resultados en el textArea
		        textArea.setText(sb.toString());
		        
    		
		}else if(e.getSource()== btnSalir) {
			this.setVisible(false);
		}
	}


	
}
