package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Matricula;

public class ArregloMatricula {
	//Atributos
		private ArrayList<Matricula> matricula;
	//Constructir
		public ArregloMatricula() {
			matricula =new ArrayList <Matricula>();
			cargarMatriculas();
		}
		
	//operaciones
		
		public void adicionar(Matricula x) {
			matricula.add(x);
			grabarMatriculas();
		}
		public int tamanio() {
			return matricula.size();
		}
		public Matricula obtener(int i) {
			return matricula.get(i);
		}
		public Matricula buscar(int numMatricula) {
			for (int i=0; i<tamanio(); i++)
				if (obtener(i).getNum_matricula() == numMatricula)
					return obtener(i);
			return null;
		}
		public void eliminar(Matricula x) {
			matricula.remove(x);
			grabarMatriculas();
		}
		public void actualizarArchivo() {
			grabarMatriculas();
		}
		private void grabarMatriculas() {
			try {
				PrintWriter pw;
				String linea;
				Matricula x;
				pw = new PrintWriter(new FileWriter("Matricula.txt"));
				for (int i=0; i<tamanio(); i++) {
					x = obtener(i);
					linea = x.getNum_matricula() + ";" +
							x.getCod_alumno()+";"+
							x.getCod_curso()+";"+
							x.getFecha()+";"+
							x.getHora();
					
					pw.println(linea);
				}
				pw.close();	
			}
			catch (Exception e) {
			}
		}
		
		//Carga lo que está guardado en el .txt y lo registra en el arraylist
		private void cargarMatriculas() {
			try {
				BufferedReader br;
				String linea;
				String[] s;
				int nummatricula,codalumno, codcurso;
				String fecha, hora;
				br = new BufferedReader(new FileReader("Matricula.txt"));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					nummatricula	= Integer.parseInt(s[0].trim());
					codalumno 		= Integer.parseInt(s[1].trim());
					codcurso 		= Integer.parseInt(s[2].trim());
					fecha 			= s[3].trim();
					hora			= s[4].trim();
					
					
					adicionar(new Matricula(nummatricula,codalumno,codcurso,fecha,hora));
				}
				br.close();
			}
			catch (Exception e) {
			}
		}
		
		public int codigoCorrelativo() {
			if (tamanio() == 0)
				return 100001;
			else
				return obtener(tamanio()-1).getNum_matricula() + 1;
		}
}

