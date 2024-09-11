package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import controlador.Coordinador;

public class ModeloDeDatos extends PersonaU{
	 	private List<String> contactos;
	 	
	    static HashMap<Integer, PersonaU> miAgenda = new HashMap<>();

	    private Coordinador miCoordinador;

	    //Variable para generar el Id
	    private static int generadorId = 1; 

	    public ModeloDeDatos() {

	    }

	    
	    public static int getNextId() {
	        return generadorId++;
	    }

	    // Registrar contacto
	    public void registrarContacto(PersonaU usuario) {
	    	  	//Asignamos un id a el usuario
	    	 	usuario.setId(getNextId());
	           //Verificamos que el id no exista en la agenda
	           if (!miAgenda.containsKey(usuario.getId())) {
	        	   //Se agrega el registro a la agenda
	               miAgenda.put(usuario.getId(), usuario);
	               System.out.println("IDs registrados: " + miAgenda.keySet());
	           } else {
	               JOptionPane.showMessageDialog(null, "La persona ya se encuentra registrada");
	           }
	    }

	    // Actualizar contacto en la agenda
	    public void actualizarAgenda(PersonaU usuario) {
	    	//Solicitamos el id del contacto que deseamos actualizar
	        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario a actualizar"));
	        //Verificamos que el id suministrado se encuentre en la agenda
	        if (miAgenda.containsKey(id)) {
	        	
	        	//Accedemos al contacto registrado con el id y se lo asignamos a usuario Registrado
	            PersonaU usuarioExistente = miAgenda.get(id);
	            System.out.println("Actualizando el contacto con ID: " + id);

	            // Solicitar nuevos datos y mostramos los datos existentes en esa variable
	            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre", usuarioExistente.getNombre());
	            String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido", usuarioExistente.getApellido());
	            String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección", usuarioExistente.getDireccion());
	            String nuevoNumTlfno = JOptionPane.showInputDialog("Ingrese el nuevo número de teléfono", usuarioExistente.getNumTlfno());
	            String nuevoCorreo = JOptionPane.showInputDialog("Ingrese el nuevo correo", usuarioExistente.getCorreo());

	            // Asignar nuevos datos a la variable creada anterior mente
	            usuarioExistente.setNombre(nuevoNombre);
	            usuarioExistente.setApellido(nuevoApellido);
	            usuarioExistente.setDireccion(nuevaDireccion);
	            usuarioExistente.setNumTlfno(nuevoNumTlfno);
	            usuarioExistente.setCorreo(nuevoCorreo);
	            
	            //Enviamos los datos nuevos al HashMap para que se actualice
	            miAgenda.put(id, usuarioExistente);

	            JOptionPane.showMessageDialog(null, "Datos actualizados con éxito");
	            System.out.println("IDs disponibles en la agenda después de actualización: " + miAgenda.keySet());
	        } else {
	            JOptionPane.showMessageDialog(null, "Contacto no existe en la agenda");
	            System.out.println("IDs disponibles en la agenda: " + miAgenda.keySet());
	        }
	    }

	    
	    public List<String> consultarContacto(String criterio, String valor) {
	    	
	    	//Declaramos una lista vacia que puede almacenar cadena de testos 
	        List<String> contactosEncontrados = new ArrayList<>(); 
	        
	        //Declaramos una varia donde pasamos todas las letras de valor a minuscula
	        String valorLowerCase = valor.toLowerCase();
	        //Realizamos un ciclo forEach para recorrer la agenda y obtener sus valores
	        for (PersonaU persona : miAgenda.values()) {
		        	//Declaramos un variable para la comparacion de contenido
		            String datoComparar = "";
		            
		            //Condicional para comparar si criterio es igual a "nombre" mi parametro"
		            if ("nombre".equalsIgnoreCase(criterio)) {
		            	//Asigna el nombre de la persona obtenida por getNombre ah datoComparar
		                datoComparar = persona.getNombre().toLowerCase();
		                
		            } else if ("correo".equalsIgnoreCase(criterio)) {
		            	//Asigna el correo de la persona obtenida por getNombre ah datoComparar
		                datoComparar = persona.getCorreo().toLowerCase();
		                
		            }
	            
		            //Verifica si valorLowerCase se encuentra en datoComparar
	            if (datoComparar.contains(valorLowerCase)) {
	            	//Agregamos a la lista contactosEncontrados el toString de la persona relacionada con el nombre
	                contactosEncontrados.add(persona.toString());
	                
	            }
	        }
	        //Validacion para verificar si la lista esta vacia
	        if (contactosEncontrados.isEmpty()) {
	            contactosEncontrados.add("No se encontraron contactos que coincidan con el criterio.");
	        }
	        //Si la lista tiene contenido  entonces mande la lista
	        return contactosEncontrados; 
	    }

	    // Eliminar contacto
	    public void borrarContacto(int id) {
	    	
	    	//Verificamos que en la agenda se encuentre el registro segun la id
	        if (miAgenda.containsKey(id)) {
	        	
	            System.out.println("Eliminando el contacto con ID: " + id);
	            //Eliminamos el id de la agenda
	            miAgenda.remove(id);
	            JOptionPane.showMessageDialog(null, "Contacto eliminado con éxito");
	            System.out.println("IDs disponibles en la agenda después de eliminación: " + miAgenda.keySet());
	        } else {
	        	
	            JOptionPane.showMessageDialog(null, "El contacto no existe en la agenda");
	            
	            System.out.println("IDs disponibles en la agenda: " + miAgenda.keySet());
	        }
	    }

	    // Método para obtener los contactos consultados
	    public List<String> getContactos() {
	        return contactos;
	    }

	    // Establecer coordinador
	    public void setCoordinador(Coordinador miCoordinador) {
	        this.miCoordinador = miCoordinador;
	    }
	
}
