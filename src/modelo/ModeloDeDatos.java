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

	    
	    private static int generadorId = 1; 

	    public ModeloDeDatos() {

	    }

	    
	    public static int getNextId() {
	        return generadorId++;
	    }

	    // Registrar contacto
	    public void registrarContacto(String nombre, String apellido, String direccion, String numTlfno, String correo) {
	    	   PersonaU usuario = new PersonaU();

	           usuario.setId(getNextId());
	           usuario.setNombre(nombre);
	           usuario.setApellido(apellido);
	           usuario.setDireccion(direccion);
	           usuario.setNumTlfno(numTlfno);
	           usuario.setCorreo(correo);

	           if (!miAgenda.containsKey(usuario.getId())) {
	               miAgenda.put(usuario.getId(), usuario);
	               System.out.println("IDs registrados: " + miAgenda.keySet());
	           } else {
	               JOptionPane.showMessageDialog(null, "La persona ya se encuentra registrada");
	           }
	    }

	    // Actualizar contacto en la agenda
	    public void actualizarAgenda(PersonaU usuario) {
	        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario a actualizar"));

	        if (miAgenda.containsKey(id)) {
	            PersonaU usuarioExistente = miAgenda.get(id);
	            System.out.println("Actualizando el contacto con ID: " + id);

	            // Solicitar nuevos datos
	            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre", usuarioExistente.getNombre());
	            String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido", usuarioExistente.getApellido());
	            String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección", usuarioExistente.getDireccion());
	            String nuevoNumTlfno = JOptionPane.showInputDialog("Ingrese el nuevo número de teléfono", usuarioExistente.getNumTlfno());
	            String nuevoCorreo = JOptionPane.showInputDialog("Ingrese el nuevo correo", usuarioExistente.getCorreo());

	            // Asignar nuevos datos
	            usuarioExistente.setNombre(nuevoNombre);
	            usuarioExistente.setApellido(nuevoApellido);
	            usuarioExistente.setDireccion(nuevaDireccion);
	            usuarioExistente.setNumTlfno(nuevoNumTlfno);
	            usuarioExistente.setCorreo(nuevoCorreo);

	            miAgenda.put(id, usuarioExistente);

	            JOptionPane.showMessageDialog(null, "Datos actualizados con éxito");
	            System.out.println("IDs disponibles en la agenda después de actualización: " + miAgenda.keySet());
	        } else {
	            JOptionPane.showMessageDialog(null, "Contacto no existe en la agenda");
	            System.out.println("IDs disponibles en la agenda: " + miAgenda.keySet());
	        }
	    }

	    
	    public List<String> consultarContacto(String criterio, String valor) {
	        List<String> contactosEncontrados = new ArrayList<>(); 
	        String valorLowerCase = valor.toLowerCase();

	        for (PersonaU persona : miAgenda.values()) {
	            String datoComparar = "";
	            if ("nombre".equalsIgnoreCase(criterio)) {
	                datoComparar = persona.getNombre().toLowerCase();
	            } else if ("correo".equalsIgnoreCase(criterio)) {
	                datoComparar = persona.getCorreo().toLowerCase();
	            }

	            if (datoComparar.contains(valorLowerCase)) {
	                contactosEncontrados.add("ID: " + persona.getId() + " - " + persona.toString());
	            }
	        }

	        if (contactosEncontrados.isEmpty()) {
	            contactosEncontrados.add("No se encontraron contactos que coincidan con el criterio.");
	        }

	        return contactosEncontrados; // Devuelve la lista de contactos encontrados o un mensaje
	    }

	    // Eliminar contacto
	    public void borrarContacto(int id) {
	        if (miAgenda.containsKey(id)) {
	            System.out.println("Eliminando el contacto con ID: " + id);
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
