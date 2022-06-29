package arreglos;
import clases.Alumno;

import java.io.*;
import java.util.ArrayList;

public class ArregloAlumno {
	//Atributos
		private ArrayList <Alumno> alumno;
	//Constructor
		public ArregloAlumno() {
			alumno = new ArrayList <Alumno>();
			cargarDatos();
		}
		
	//operaciones
		public void adicionar(Alumno x) {
			alumno.add(x);
			grabarDatos();
		}
	    public int tamanio() {
			return alumno.size();
		}
		public Alumno obtener(int i) {
			return alumno.get(i);
		}
		public Alumno buscar(int codigo) {
			for (int i=0; i<tamanio(); i++)
				if (obtener(i).getCodAlumno() == codigo)
					return obtener(i);
			return null;
		}
		public void eliminar(Alumno x) {
			alumno.remove(x);
			grabarDatos();
		}
		public void actualizarArchivo() {
			grabarDatos();
		}
		private void grabarDatos() {
			try {
				PrintWriter pw;
				String linea;
				Alumno x;
				pw = new PrintWriter(new FileWriter("Alumnos.txt"));
				for (int i=0; i<tamanio(); i++) {
					x = obtener(i);
					linea = x.getCodAlumno() + ";" +
							x.getDni()+";"+
							x.getNombres()+";"+
							x.getApellidos()+";"+
							x.getEdad()+";"+
							x.getCelular()+";"+
							x.getEstado();
					pw.println(linea);
				}
				pw.close();	
			}
			catch (Exception e) {
			}
		}
		private void cargarDatos() {
			try {
				BufferedReader br;
				String linea;
				String[] s;
				int codigoAlumno,edad, celular, estado;
				String nombres, apellidos, dni;
				br = new BufferedReader(new FileReader("Alumnos.txt"));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					codigoAlumno	= Integer.parseInt(s[0].trim());
					dni 			= s[1].trim();
					nombres 		= s[2].trim();
					apellidos 		= s[3].trim();
					edad			= Integer.parseInt(s[4].trim());
					celular	 		= Integer.parseInt(s[5].trim());
					estado			= Integer.parseInt(s[6].trim());
					
					adicionar(new Alumno(codigoAlumno,dni,nombres,apellidos,edad,celular,estado));
				}
				br.close();
			}
			catch (Exception e) {
			}
		}
		//  Operaciones p�blicas complementarias
		public int codigoCorrelativo() {
			if (tamanio() == 0)
				return 202010001;
			else
				return obtener(tamanio()-1).getCodAlumno() + 1;
		}
}
