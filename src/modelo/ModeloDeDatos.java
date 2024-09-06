package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import controlador.Coordinador;

public class ModeloDeDatos extends PersonaU{
	
	HashMap<Integer,PersonaU> miAgenda;
	private Coordinador miCoordinador;
	private static int generadorId = 0;
	
	 	public ModeloDeDatos() {
	        miAgenda = new HashMap<>();
	    }
	 	
	 	public static int getNextId() {
	        return generadorId++;
	    }
	 	
	 	public void registrarContacto(PersonaU usuario) {
			if(!miAgenda.containsKey(usuario.getId())) {
				miAgenda.put(usuario.getId(), usuario);
			}else {
				JOptionPane.showMessageDialog(null,"La persona ya se encuentra registrada");
			}
	 	}
	 	
	 	public void actualizarAgenda(PersonaU usuario) {
	 		int id=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario a actualizar"));
	 		
	 		if(miAgenda.containsKey(id)) {
	 			PersonaU usuarioExistente= miAgenda.get(id);
	 			//Solicitamos los nuevos datos
	 			String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre", usuarioExistente.getNombre());
	 	        String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido", usuarioExistente.getApellido());
	 	        String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección", usuarioExistente.getDireccion());
	 	        String nuevoNumTlfno = JOptionPane.showInputDialog("Ingrese el nuevo número de teléfono", usuarioExistente.getNumTlfno());
	 	        String nuevoCorreo = JOptionPane.showInputDialog("Ingrese el nuevo correo", usuarioExistente.getCorreo());
	 	        
	 	        //Enviamos los datos nuevos
		 	    usuarioExistente.setNombre(nuevoNombre);
		 	    usuarioExistente.setApellido(nuevoApellido);
		 	    usuarioExistente.setDireccion(nuevaDireccion);
		 	    usuarioExistente.setNumTlfno(nuevoNumTlfno);
		 	    usuarioExistente.setCorreo(nuevoCorreo);
	 	        
	 	        
	 	        miAgenda.put(id, usuarioExistente);
	 	        
	 	        JOptionPane.showMessageDialog(null, "Datos actualizado con exito!!");
	 		}else {
	 			JOptionPane.showMessageDialog(null, "Contacto no existe en la agenda");
	 		}
	 	}
	
		public String consultarContacto(String criterio, String valor) {
			 List<String> contactos = new ArrayList<>();
			    for (PersonaU persona : miAgenda.values()) {
			        
			    	boolean coincidencia= false;
			    	if("nombre".equalsIgnoreCase(criterio)) {
			    		
			    		coincidencia= persona.getNombre().contains(valor);
			    	}else if("correo".equalsIgnoreCase(criterio)) {
			    		
			    		coincidencia = persona.getCorreo().contains(valor);
			    	}if(coincidencia) {
			    		contactos.add(persona.toString());
			    	}
			    	
			    	
			    }
			    if (contactos.isEmpty()) {
			        return "No se encontraron contactos que coincidan con el criterio.";
			    } else {
			    	 // Unir todas las cadenas con una nueva línea
			        return String.join("\n", contactos);
			    }
			   
			
		}
	
		public void borrarContacto(int id) {
			
			if (miAgenda.containsKey(id)) {
		        miAgenda.remove(id);
		        JOptionPane.showMessageDialog(null, "Contacto eliminado con éxito");
		    } else {
		        JOptionPane.showMessageDialog(null, "El contacto no existe en la agenda");
		    }
		}
	
		public void consultarPersonas() {
			
			System.out.println(miAgenda);
			
			Iterator<Integer> itera=miAgenda.keySet().iterator();
			
			while (itera.hasNext()) {
				int documento = (int) itera.next();
				System.out.println(documento+" - "+miAgenda.get(documento));
				
			}
		}
		

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}

	

	
	
}
