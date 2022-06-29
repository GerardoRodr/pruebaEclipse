package arreglos;

import java.io.*;
import java.util.ArrayList;

import clases.Retiro;

	public class ArregloRetiro {
		//Atributos
			private ArrayList<Retiro> retiro;
		//Constructir
			public ArregloRetiro() {
				retiro =new ArrayList <Retiro>();
				cargarRetiros();
			}
			
		//operaciones
			
			public void adicionar(Retiro x) {
				retiro.add(x);
				grabarDatos();
			}
			public int tamanio() {
				return retiro.size();
			}
			public Retiro obtener(int i) {
				return retiro.get(i);
			}
			public Retiro buscar(int numRetiro) {
				for (int i=0; i<tamanio(); i++)
					if (obtener(i).getNumRetiro() == numRetiro)
						return obtener(i);
				return null;
			}
			public void eliminar(Retiro x) {
				retiro.remove(x);
				grabarDatos();
			}
			public void actualizarArchivo() {
				grabarDatos();
			}
			private void grabarDatos() {
				try {
					PrintWriter pw;
					String linea;
					Retiro x;
					pw = new PrintWriter(new FileWriter("Retiro.txt"));
					for (int i=0; i<tamanio(); i++) {
						x = obtener(i);
						linea = x.getNumRetiro() + ";" +
								x.getNumMatricula()+";"+
								x.getFecha()+";"+
								x.getHora();
						pw.println(linea);
					}
					pw.close();	
				}
				catch (Exception e) {
				}
			}
			private void cargarRetiros() {
				try {
					BufferedReader br;
					String linea;
					String[] s;
					int numRetiro,numMatricula;
					String fecha, hora;
					br = new BufferedReader(new FileReader("Retiro.txt"));
					while ((linea = br.readLine()) != null) {
						s = linea.split(";");
						numRetiro		= Integer.parseInt(s[0].trim());
						numMatricula 	= Integer.parseInt(s[1].trim());
						fecha 			= s[2].trim();
						hora			= s[3].trim();
					
						adicionar(new Retiro(numRetiro,numMatricula,fecha,hora));
					}
					br.close();
				}
				catch (Exception e) {
				}
			}
			public int codigoCorrelativo() {
				if (tamanio() == 0)
					return 200001;
				else
					return obtener(tamanio()-1).getNumRetiro() + 1;
			}
	}

