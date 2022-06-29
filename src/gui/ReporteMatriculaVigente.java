package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import arreglos.ArregloAlumno;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ReporteMatriculaVigente extends JDialog implements WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea txtArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteMatriculaVigente dialog = new ReporteMatriculaVigente();
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
	public ReporteMatriculaVigente() {
		addWindowListener(this);
		setTitle("Alumnos con matricula vigente");
		setBounds(100, 100, 640, 395);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 604, 334);
		getContentPane().add(scrollPane);
		
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		scrollPane.setViewportView(txtArea);

	}
	
	ArregloAlumno al = new ArregloAlumno();
	public void windowOpened(WindowEvent e) {
		imprimir("ALUMNOS CON MATRICULA VIGENTE......... (ESTADO: MATRICULADO)");
		imprimir(" ");
		for (int i=0; i<al.tamanio(); i++) {
			if (al.obtener(i).getEstado() == 1) {
				imprimir("Codigo del Alumno: " + al.obtener(i).getCodAlumno());
				imprimir("Nombre del Alumno: " + al.obtener(i).getNombres());
				imprimir("Apellido del Alumno: " + al.obtener(i).getApellidos());
				imprimir("Dni del Alumno: " + al.obtener(i).getDni());
				imprimir("Edad del Alumno: " + al.obtener(i).getEdad());
				imprimir("Estado del Alumno: " + al.obtener(i).Estado(al.obtener(i).getEstado()));
				imprimir(" ");
			}
		}
	}
	
	void imprimir(String s) {
		txtArea.append(s + "\n");
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
