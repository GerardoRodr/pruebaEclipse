package clases;

public class Alumno {
	//Atributos
	private int codAlumno, edad, celular,estado;
	private String apellidos, dni, nombres;

	//CONSTRUCTOR
	public Alumno(int codAlumno, String dni, String nombres, String apellidos, int edad, int celular, int estado) {
		super();
		this.codAlumno = codAlumno;
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;
	}

	//getters ans setters
	public  int getCodAlumno() {
		return codAlumno;
	}
	
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	
	public String Estado(int estado){
		String mensaje = "";	
		switch (estado) {
			case 0:
				mensaje = "Registrado";
				break;
			case 1:
				mensaje = "Matriculado";
				break;
			case 2:
				mensaje = "Retirado";
				break;
		}

		return mensaje;		
	}
}
		
