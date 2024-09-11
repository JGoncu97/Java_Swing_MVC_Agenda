package Ventanas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import controlador.Coordinador;
import modelo.ModeloDeDatos;

public class VentanaPrincipal extends JFrame implements ActionListener {
	
	private ModeloDeDatos miAgenda;
	private Coordinador miCoordinador;
	private JLabel tituloAgenda;
	private JPanel panelPpal;
	private JButton vAgregar;
	private JButton vEliminar;
	private JButton vActualizar;
	private JButton vConsultar;
	private VentanaResultado ventanaResultado;
	private VentanaRegistro ventanaRegistro;
	
	public VentanaPrincipal() {
		miCoordinador = new Coordinador();
		iniciarComponente();
		setTitle("Agenda");
		setSize(600,400);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		ventanaResultado = new VentanaResultado();
		ventanaRegistro = new VentanaRegistro();
		
		
		ventanaRegistro.setCoordinador(miCoordinador);
		ventanaResultado.setCoordinador(miCoordinador);
		
	}

	private void iniciarComponente() {
		panelPpal = new JPanel();
	    panelPpal.setBackground(new Color(175, 216, 157));
	    panelPpal.setLayout(null);
	    
	    tituloAgenda = new JLabel();
	    tituloAgenda.setFont(new Font("Tempus Sans ITC", 1, 36)); // NOI18N
	    tituloAgenda.setHorizontalAlignment(SwingConstants.CENTER);
	    tituloAgenda.setText("Bienvenido a la AGENDA");
	    tituloAgenda.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    panelPpal.add(tituloAgenda);
	    tituloAgenda.setBounds(63, 80, 460, 60);

	    
	    vAgregar = new JButton("Agregar");
	    vAgregar.setBounds(60, 300, 100, 25);

	    vActualizar = new JButton("Actualizar");
	    vActualizar.setBounds(180, 300, 100, 25);

	    vConsultar = new JButton("Buscar");
	    vConsultar.setBounds(300, 300, 100, 25);

	    vEliminar = new JButton("Eliminar");
	    vEliminar.setBounds(420, 300, 100, 25);

	    vAgregar.addActionListener(this);
	    vActualizar.addActionListener(this);
	    vConsultar.addActionListener(this);
	    vEliminar.addActionListener(this);

	    panelPpal.add(vAgregar);
	    panelPpal.add(vActualizar);
	    panelPpal.add(vConsultar);
	    panelPpal.add(vEliminar);

	    add(panelPpal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vAgregar) {
			 
			ventanaRegistro.setVisible(true);
			
		}else if (e.getSource() == vConsultar) {
    	
    		
    		ventanaResultado.setVisible(true);  
        
    	
		} else if (e.getSource() == vEliminar) {
    	 String borrarId = JOptionPane.showInputDialog("¿Cuál es el ID que desea eliminar?");
            try {
                int id = Integer.parseInt(borrarId);
                if (miCoordinador != null && miCoordinador.getModelo() != null) {
                    miCoordinador.getModelo().borrarContacto(id);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Modelo de datos no inicializado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
    }else if (e.getSource()== vActualizar) {
    	 miCoordinador.getModelo().actualizarAgenda(miAgenda);
    	 
    }
	}
		
	public void setCoordinador(Coordinador miCoordinador) {
	    this.miCoordinador = miCoordinador;
	}

		
	}

