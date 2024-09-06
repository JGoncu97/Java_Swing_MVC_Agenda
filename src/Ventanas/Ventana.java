package Ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.Coordinador;
import modelo.ModeloDeDatos;
import modelo.PersonaU;


public class Ventana extends JFrame implements ActionListener {
	private ModeloDeDatos miAgenda;
	private JPanel miPanel;
	private JTextArea textArea; 
	private JLabel etiNombre;
	private JTextField txtNombre;
	private JLabel etiApellido;
	private JTextField txtApellido;
	private JLabel etiNumTlfno;
	private JTextField txtNumTlfno;
	private JLabel etiCorreo;
	private JTextField txtCorreo;
	private JLabel etiDireccion;
	private JTextField txtDireccion;
	private JButton btnAgregar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private Coordinador miCoordinador;
	private JScrollPane scrollPane;
	private JButton btnActualizar;
	
	
	public  Ventana() {
		iniciarComponente();
		setTitle("Agenda Telefonica");
		setSize(600,500);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
		
	}
	
	private void iniciarComponente() {
		miPanel= new JPanel();
		miPanel.setLayout(null);
		
		
		etiNombre = new JLabel("Nombre");
		txtNombre= new JTextField(6);
		etiNombre.setBounds(60, 40, 50, 25);
		txtNombre.setBounds(60,60,100,25);
		
		etiApellido= new JLabel("Apellido");
		txtApellido= new JTextField(6);
		etiApellido.setBounds(60, 80, 50, 25);
		txtApellido.setBounds(60,100,100,25);
		
		etiNumTlfno= new JLabel("Numero Celular");
		txtNumTlfno= new JTextField(6);
		etiNumTlfno.setBounds(60,120,100,25);
		txtNumTlfno.setBounds(60,140,100,25);
		
		etiCorreo = new JLabel("Correo");
		txtCorreo= new JTextField(6);
		etiCorreo.setBounds(60,160,60,25);
		txtCorreo.setBounds(60,180,100,25);
		
		etiDireccion= new JLabel("Direccion");
		txtDireccion= new JTextField(6);
		etiDireccion.setBounds(60,200,70,25);
		txtDireccion.setBounds(60,220,100,25);
		
		textArea= new JTextArea();
		textArea.setBounds(240,60,250,200);
		textArea.setLineWrap(true); // Ajustar el texto a la línea
		textArea.setWrapStyleWord(true); // Ajustar las palabras en lugar de cortar palabras
		textArea.setEditable(false); // Solo para mostrar, no editable
		
		scrollPane = new JScrollPane(textArea); 
	    scrollPane.setBounds(240, 60, 250, 200);
		
		btnAgregar= new JButton("Agregar");
		btnAgregar.setBounds(60,400,100,25);
		
		btnBuscar= new JButton("Buscar");
		btnBuscar.setBounds(180,400,100,25);
		
		btnEliminar= new JButton("Eliminar");
		btnEliminar.setBounds(300,400,100,25);
		
		btnActualizar= new JButton("Actualizar");
		btnActualizar.setBounds(420,400,100,25);	
		
		btnActualizar.addActionListener(this);
		btnAgregar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnEliminar.addActionListener(this);
		
		miPanel.add(etiNombre);
		miPanel.add(txtNombre);
		miPanel.add(etiApellido);
		miPanel.add(txtApellido);
		miPanel.add(etiNumTlfno);
		miPanel.add(txtNumTlfno);
		miPanel.add(etiCorreo);
		miPanel.add(txtCorreo);
		miPanel.add(etiDireccion);
		miPanel.add(txtDireccion);
		miPanel.add(btnAgregar);
		miPanel.add(btnBuscar);
		miPanel.add(btnEliminar);
		miPanel.add(scrollPane);
		miPanel.add(btnActualizar);
		
		add(miPanel);
		
	}
	private void registrar() {
		PersonaU miP=new PersonaU();
		miP.setNombre(txtNombre.getText());
		miP.setApellido(txtApellido.getText());
		miP.setDireccion(txtDireccion.getText());
		miP.setNumTlfno(txtNumTlfno.getText());
		miP.setCorreo(txtCorreo.getText());
		
		
		miCoordinador.getModelo().registrarContacto(miP);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
	        registrar();
	        txtNombre.setText("");
	        txtApellido.setText("");
	        txtNumTlfno.setText("");
	        txtDireccion.setText("");
	        txtCorreo.setText("");
	        JOptionPane.showMessageDialog(null, "Registro Exitoso");
	    } else if (e.getSource() == btnBuscar) {
	    	
	    	if (miCoordinador != null && miCoordinador.getModelo() != null) {
	    		String criterio = JOptionPane.showInputDialog("Buscar por (nombre/correo):");
	            String valor = JOptionPane.showInputDialog("Ingrese el valor de búsqueda:");
	            String resultado = miCoordinador.getModelo().consultarContacto(criterio, valor);
	            textArea.setText(resultado);
            } else {
                JOptionPane.showMessageDialog(this, "Modelo de datos no inicializado.");
            }
	    	
	    } else if (e.getSource() == btnEliminar) {
	    	 String borrarId = JOptionPane.showInputDialog("¿Cuál es el ID que desea eliminar?");
	            try {
	                int id = Integer.parseInt(borrarId);
	                if (miCoordinador != null && miCoordinador.getModelo() != null) {
	                    miCoordinador.getModelo().borrarContacto(id);
	                    textArea.setText("");
	                } else {
	                    JOptionPane.showMessageDialog(this, "Modelo de datos no inicializado.");
	                }
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(this, "ID inválido.");
	            }
	    }else if (e.getSource()== btnActualizar) {
	    	 miCoordinador.getModelo().actualizarAgenda(miAgenda);
	    	 textArea.setText("");
	    }
		
	}

	

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}

}
