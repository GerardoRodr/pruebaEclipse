package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnMantenimiento;
	private JMenu mnInicio;
	private JMenu mnReporte;
	private JMenu mnConsulta;
	private JMenu mnRegistro;
	private JMenuItem mntmAlumno;
	private JMenuItem mntmCurso;
	private JMenuItem mntmMatricula;
	private JMenuItem mntmRetiro;
	private JMenuItem mntmAlumnosyCursos;
	private JMenuItem mntmMatriculayRetiros;
	private JMenuItem mntmAlumnosConMatriculaPendiente;
	private JMenuItem mntmAlumnosConMatriculaVigente;
	private JSeparator separator;
	private JSeparator separator_3;
	private JSeparator separator_2;
	private JSeparator separator_1;
	private JMenuItem mntmSalir;
	private JMenuItem mntmAlumnosMatriculadosPorCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setTitle("Centro de Estudios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnInicio.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.addActionListener(this);
		mnMantenimiento.add(mntmAlumno);
		
		separator = new JSeparator();
		mnMantenimiento.add(separator);
		
		mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(this);
		mnMantenimiento.add(mntmCurso);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.addActionListener(this);
		menuBar.add(mnRegistro);
		
		mntmMatricula = new JMenuItem("Matricula");
		mntmMatricula.addActionListener(this);
		mnRegistro.add(mntmMatricula);
		
		separator_1 = new JSeparator();
		mnRegistro.add(separator_1);
		
		mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.addActionListener(this);
		mnRegistro.add(mntmRetiro);
		
		mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mntmAlumnosyCursos = new JMenuItem("Alumnos y cursos");
		mntmAlumnosyCursos.addActionListener(this);
		mnConsulta.add(mntmAlumnosyCursos);
		
		separator_2 = new JSeparator();
		mnConsulta.add(separator_2);
		
		mntmMatriculayRetiros = new JMenuItem("Matricula y retiros");
		mntmMatriculayRetiros.addActionListener(this);
		mnConsulta.add(mntmMatriculayRetiros);
		
		mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		mntmAlumnosConMatriculaPendiente = new JMenuItem("Alumnos con matricula pendiente");
		mntmAlumnosConMatriculaPendiente.addActionListener(this);
		mnReporte.add(mntmAlumnosConMatriculaPendiente);
		
		separator_3 = new JSeparator();
		mnReporte.add(separator_3);
		
		mntmAlumnosConMatriculaVigente = new JMenuItem("Alumnos con matricula vigente");
		mntmAlumnosConMatriculaVigente.addActionListener(this);
		mnReporte.add(mntmAlumnosConMatriculaVigente);
		
		mntmAlumnosMatriculadosPorCurso = new JMenuItem("Alumnos matriculados por cursos");
		mntmAlumnosMatriculadosPorCurso.addActionListener(this);
		
		JSeparator separator_4 = new JSeparator();
		mnReporte.add(separator_4);
		mnReporte.add(mntmAlumnosMatriculadosPorCurso);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

		public void actionPerformed(ActionEvent e) {
		
			if(e.getSource() == mntmSalir) {
				System.exit(0);
			}
			if(e.getSource() == mntmAlumno) {
				DigAlumno a = new DigAlumno();
				a.setVisible(true);	
			}
			if(e.getSource() == mntmCurso) {
				DigCurso a 				= new DigCurso();
				a.setVisible(true);	
			}
			if(e.getSource() == mntmMatricula) {
				DigMatricula a 			= new DigMatricula();
				a.setVisible(true);	
			}
			if(e.getSource() == mntmRetiro) {
				DigRetiro a 			= new DigRetiro();
				a.setVisible(true);	
			}
			if(e.getSource() == mntmAlumnosyCursos) {
				AlumnosyCursos a 		= new AlumnosyCursos();
				a.setVisible(true);	
			}
			if(e.getSource() == mntmMatriculayRetiros) {
				MatriculasyRetiros a	 = new MatriculasyRetiros();
				a.setVisible(true);	
			}
			if(e.getSource() == mntmAlumnosConMatriculaPendiente) {
				ReporteMatriculaPendiente a = new ReporteMatriculaPendiente();
				a.setVisible(true);	
			}
			if(e.getSource() == mntmAlumnosConMatriculaVigente) {
				ReporteMatriculaVigente a = new ReporteMatriculaVigente();
				a.setVisible(true);	

			}
			if(e.getSource() == mntmAlumnosMatriculadosPorCurso) {
				ReporteMatriculadosPorCurso a = new ReporteMatriculadosPorCurso();
				a.setVisible(true);	

			}
			
		
	}
}
