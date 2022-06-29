package arreglos;
import clases.Curso;

import java.io.*;
import java.util.ArrayList;

public class ArregloCurso {
	//Atributos
	private ArrayList <Curso> curso;
		
//Constructor
	public ArregloCurso() {
		curso = new ArrayList <Curso>();
		cargarCursos();
	}
	
//opercursoiones
	public void adicionar(Curso x) {
		curso.add(x);
		grabarCursos();
	}
    public int tamanio() {
		return curso.size();
	}
	public Curso obtener(int i) {
		return curso.get(i);
	}
	public Curso buscar(int codigo) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getCodCurso() == codigo)
				return obtener(i);
		return null;
	}
	public void eliminar(Curso x) {
		curso.remove(x);
		grabarCursos();
	}
	public void actualizarArchivo() {
		grabarCursos();
	}
	private void grabarCursos() {
		try {
			PrintWriter pw;
			String linea;
			Curso x;
			pw = new PrintWriter(new FileWriter("Cursos.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodCurso()+";"+
						x.getAsignatura()+";"+
						x.getCiclo()+";"+
						x.getCreditos()+";"+
						x.getHoras();
				pw.println(linea);
			}
			pw.close();	
		}
		catch (Exception e) {
		}
	}
	private void cargarCursos() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codCurso, ciclo, creditos, horas;
			String asignatura ;
			br = new BufferedReader(new FileReader("Cursos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codCurso		= Integer.parseInt(s[0].trim());
				asignatura		= s[1].trim();
				ciclo	 		= Integer.parseInt(s[2].trim());
				creditos 		= Integer.parseInt(s[3].trim());
				horas			= Integer.parseInt(s[4].trim());
				
				adicionar(new Curso(codCurso,asignatura,ciclo,creditos,horas));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
}
