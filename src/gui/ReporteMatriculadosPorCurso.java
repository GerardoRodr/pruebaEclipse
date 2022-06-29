package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;

import javax.swing.JTextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ReporteMatriculadosPorCurso extends JDialog implements WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea txtArea;
	private JScrollPane scrollPane;
	
	public int almacenador = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteMatriculadosPorCurso dialog = new ReporteMatriculadosPorCurso();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ReporteMatriculadosPorCurso() {
		addWindowListener(this);
		setTitle("Alumnos con matr\u00EDcula vigente");
		setBounds(100, 100, 640, 395);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 604, 334);
		getContentPane().add(scrollPane);
		
		txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		txtArea.setEditable(false);

	}
	
	ArregloAlumno al = new ArregloAlumno();
	ArregloMatricula am = new ArregloMatricula();
	ArregloCurso ac = new ArregloCurso();
	
	public void windowOpened(WindowEvent e) {
		imprimir("ALUMNOS MATRICULADOS POR CURSO");
		imprimir(" ");
		almacenador = am.obtener(0).getCod_curso();
		
		for (int i = 0; i<ac.tamanio();i++) {
			
			int codCurso =ac.obtener(i).getCodCurso();
			imprimir("Curso: "+ ac.obtener(i).getAsignatura());
			imprimir("	Codigo de Curso: "+ codCurso);
			imprimir("		Lista de Alumnos:");
			imprimir("");
			
				for (int j=0; j<am.tamanio();j++ ) {
					
					if (codCurso == am.obtener(j).getCod_curso()) {
						int codAlumno = am.obtener(j).getCod_alumno();
						imprimir("		Codigo del Alumno: "+al.buscar(codAlumno).getCodAlumno());
						imprimir("		Nombre del Alumno: "+al.buscar(codAlumno).getNombres());
						imprimir("		Apellido del Alumno: "+al.buscar(codAlumno).getApellidos());
						imprimir("");
						
					}
				}
		
		}
		
			
			
		}
		
		
	
	
	void imprimir(String s) {
		txtArea.append(s + "\n");
	}
	
	String obtenerNombre() {
		for (int i=0; i<al.tamanio(); i++) {
			if (am.obtener(i).getCod_alumno() == al.obtener(i).getCodAlumno()) {
				return al.obtener(i).getNombres();
			}
		}
		
		return null;
	}
	
	
	
	String obtenerAsignatura() {
		for (int i=0; i<am.tamanio(); i++) {
			if (am.obtener(i).getCod_curso() == ac.obtener(i).getCodCurso()) {
				return ac.obtener(i).getAsignatura();
			}
		}
		
		return null;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
