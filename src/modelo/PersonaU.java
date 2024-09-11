package modelo;

public class PersonaU {
	
	

	private int id;
	private String nombre;
	private String apellido;
	private String numTlfno;
	private String correo;
	private String direccion;
	
	

	public PersonaU() {
		this.id=ModeloDeDatos.getNextId();
	}
	
	public PersonaU(int id ,String nombre, String apellido, String numTlfno, String correo, String direccion) {
		super();
		this.id=ModeloDeDatos.getNextId();
		this.nombre = nombre;
		this.apellido = apellido;
		this.numTlfno = numTlfno;
		this.correo = correo;
		this.direccion = direccion;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNumTlfno() {
		return numTlfno;
	}
	public void setNumTlfno(String numTlfno) {
		this.numTlfno = numTlfno;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Contacto :\n"
				+ "Id: "+ id +" \n"
				+ "Nombre: " + nombre + " \n"
				+ "Apellido: " + apellido + " \n"
				+ "Celular: " + numTlfno + " \n"
				+ "Correo: " + correo+" \n"
				+ "Direccion: " + direccion + " \n";
	}
	
}
