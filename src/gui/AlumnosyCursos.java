package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;


import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import java.awt.event.ActionEvent;


public class AlumnosyCursos extends JDialog implements ActionListener, KeyListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBox;
	private JLabel lblConsultar;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AlumnosyCursos dialog = new AlumnosyCursos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlumnosyCursos() {
		setTitle("Alumnos y Cursos");
		setBounds(100, 100, 382, 390);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblConsultar = new JLabel("Consultar:");
			lblConsultar.setBounds(10, 11, 69, 14);
			contentPanel.add(lblConsultar);
		}
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Alumno", "Curso"}));
		comboBox.setBounds(89, 7, 98, 22);
		contentPanel.add(comboBox);
		
		lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(10, 36, 69, 14);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(89, 33, 98, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(248, 7, 108, 23);
		contentPanel.add(btnConsultar);
		
		txtArea = new JTextArea();
		txtArea.setBounds(10, 61, 346, 279);
		contentPanel.add(txtArea);
		txtArea.setEditable(false);
		
	}
		ArregloAlumno al = new ArregloAlumno();
		ArregloCurso ac = new ArregloCurso();
		
		private JTextArea txtArea;
	
		public void actionPerformed(ActionEvent e) {

			if (txtCodigo.getText().length()==0) {
				error("Ingrese algun codigo",txtCodigo);
			} else {
			
				int indice=comboBox.getSelectedIndex();
				int codigo = leercodigo();
				
			switch (indice) {
				case 0:
					
					if (al.buscar(codigo) != null) {
						
						limpieza();
						mensaje("Busqueda Realizado con exito", 1);
						imprimir("Alumno Encontrado... ");
						imprimir("Codigo del Alumno: " + al.buscar(codigo).getCodAlumno());
						imprimir("Nombre del Alumno: " + al.buscar(codigo).getNombres());
						imprimir("Apellido del Alumno: " + al.buscar(codigo).getApellidos());
						imprimir("Dni del Alumno: " + al.buscar(codigo).getDni());
						imprimir("Edad del Alumno: " + al.buscar(codigo).getEdad());
						imprimir("Estado del Alumno: " + al.buscar(codigo).Estado(al.buscar(codigo).getEstado()));
					}
					else {
						error("El codigo no existe pruebe nuevamente",txtCodigo);
					}
					break;
					
					// 202010001
				case 1:
					if (ac.buscar(codigo) != null) {
						
						limpieza();
						mensaje("Busqueda Realizado con exito", 1);
						imprimir("Curso Encontrado... ");
						imprimir("Codigo del Curso: " 	+ ac.buscar(codigo).getCodCurso());
						imprimir("Nombre del Curso: "	+ ac.buscar(codigo).getAsignatura());
						imprimir("Ciclo del Curso: " 	+ ac.buscar(codigo).getCiclo());
						imprimir("Creditos del Curso: " + ac.buscar(codigo).getCreditos());
						imprimir("Horas del Curso: " 	+ ac.buscar(codigo).getHoras());
					}
					else {
						error("El codigo no existe pruebe nuevamente",txtCodigo);
					}
					break;
			}	
		}
			
		}
		
		void mensaje(String s, int i) {
			JOptionPane.showMessageDialog(this, s, "Informacion", i);
		}
		void error(String s, JTextField txt) {
			mensaje(s, 0);
			txt.setText("");
			txt.requestFocus();
		}
		
		void imprimir(String s) {
			txtArea.append(s + "\n");
		}
		public int leercodigo() {
			return Integer.parseInt(txtCodigo.getText().trim());
		}
		
		void limpieza() {
			txtArea.setText("");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
}
