package Ventanas;

import java.awt.Color;
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


public class VentanaRegistro extends JFrame implements ActionListener {
	
	private JPanel miPanel;
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
	private JButton btnCancelar;

	private Coordinador miCoordinador;
	
	
	
	public  VentanaRegistro() {
		iniciarComponente();
		setTitle("Registrar un contacto");
		setSize(350,500);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
		
	}
	
	private void iniciarComponente() {
		miPanel= new JPanel();
		miPanel.setBackground(new Color(204, 204, 2));
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
		
		
		
		btnAgregar= new JButton("Registrar");
		btnAgregar.setBounds(60,400,100,25);
		
		btnCancelar= new JButton("Cancelar");
		btnCancelar.setBounds(180,400,100,25);
	
		btnAgregar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
		
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
		miPanel.add(btnCancelar);
		
		add(miPanel);
		
	}
	private void registrar() {
	        
	        // Utilizar el método del modelo para registrar el contacto
	        miCoordinador.getModelo().registrarContacto(
	            txtNombre.getText(),
	            txtApellido.getText(),
	            txtDireccion.getText(),
	            txtNumTlfno.getText(),
	            txtCorreo.getText()
	        );
	   
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
	    }else if(e.getSource()== btnCancelar) {
	    	
	    	this.setVisible(false);
	    	
	    }
		
	}

	

	public void setCoordinador(Coordinador miCoordinador) {
	    this.miCoordinador = miCoordinador;
	}

}
