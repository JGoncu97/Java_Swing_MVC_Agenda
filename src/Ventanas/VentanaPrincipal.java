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
	//Declaramos la ventanas para abrir las ventanas desde mi Ventana Principal
	private VentanaResultado ventanaResultado;
	private VentanaRegistro ventanaRegistro;
	
	public VentanaPrincipal() {
		miCoordinador = new Coordinador();
		iniciarComponente();
		setTitle("Agenda");
		setSize(600,400);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		//Inicio a mis ventanas hijas
		ventanaResultado = new VentanaResultado();
		ventanaRegistro = new VentanaRegistro();
		
		//Inicializo la conexion de mis ventanas hijas con el coordinador para el flujo de informacion
		ventanaRegistro.setCoordinador(miCoordinador);
		ventanaResultado.setCoordinador(miCoordinador);
		
	}

	private void iniciarComponente() {
		//Agregamos los estilos y medidas de cada componente
		panelPpal = new JPanel();
	    panelPpal.setBackground(new Color(175, 216, 157));
	    panelPpal.setLayout(null);
	    
	    tituloAgenda = new JLabel();
	    tituloAgenda.setFont(new Font("Tempus Sans ITC", 1, 36)); 
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
	    
	    //Agregamos el escuchados a los botones
	    vAgregar.addActionListener(this);
	    vActualizar.addActionListener(this);
	    vConsultar.addActionListener(this);
	    vEliminar.addActionListener(this);
	    
	    //Agregamos los componentes a el Panel
	    panelPpal.add(vAgregar);
	    panelPpal.add(vActualizar);
	    panelPpal.add(vConsultar);
	    panelPpal.add(vEliminar);
	    
	    //Agregamos al panel a la interface
	    add(panelPpal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Condicional de si el escuchar los botones y darles acciones en el Panel
		if(e.getSource()==vAgregar) {
			 
			//Abrir la Ventana de registro
			ventanaRegistro.setVisible(true);
			
		}else if (e.getSource() == vConsultar) {
    	
    		//Abrir la Ventana de Consulta
    		ventanaResultado.setVisible(true);  
        
    	
		} else if (e.getSource() == vEliminar) {
			//Preguntar que usuario segun el ID desea borrar de la agenda
    	 String borrar = JOptionPane.showInputDialog("¿Cuál es el ID que desea eliminar?");
    	 //Try catch para controlar el numberException
            try {
            	//Tomamos el dato recibido por borrar , y se lo enviamos a id que lo transforma en un entero
                int id = Integer.parseInt(borrar);
                //Condicional para verificar que el coordinador y el modelo obtenido por el coordinador  no este vacio
                if (miCoordinador != null && miCoordinador.getModelo() != null) {
                	//Borra el contacto que se encuentra en el modelo
                    miCoordinador.getModelo().borrarContacto(id);
                    
                } else {
                	//Mensaje que se envia si no encuentra el modelo
                    JOptionPane.showMessageDialog(this, "Modelo de datos no inicializado.");
                }
                //Si no cumple con try entonces entre por el error 
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
		}else if (e.getSource()== vActualizar) {
    	
    	//Llame al coordinador y obtengo el modelo de dactos y  ingreso al metodo Actualizar usando el mapa
    	 miCoordinador.getModelo().actualizarAgenda(miAgenda);
    	 
    }
		
	}
		
	public void setCoordinador(Coordinador miCoordinador) {
	    this.miCoordinador = miCoordinador;
	}

		
	}

