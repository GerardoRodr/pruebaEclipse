package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloMatricula;
import arreglos.ArregloRetiro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import arreglos.*;
public class MatriculasyRetiros extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblConsultar;
	private JComboBox<String> comboBox;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JTextArea textArea;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MatriculasyRetiros dialog = new MatriculasyRetiros();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MatriculasyRetiros() {
		setTitle("Matriculas y Retiros");
		setBounds(100, 100, 352, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblConsultar = new JLabel("Consultar: ");
			lblConsultar.setBounds(10, 11, 71, 14);
			contentPanel.add(lblConsultar);
		}
		{
			comboBox = new JComboBox<String>();
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Matricula", "Retiro"}));
			comboBox.setBounds(91, 7, 90, 22);
			contentPanel.add(comboBox);
		}
		{
			lblNumero = new JLabel("Numero: ");
			lblNumero.setBounds(10, 36, 71, 14);
			contentPanel.add(lblNumero);
		}
		{
			txtNumero = new JTextField();
			txtNumero.setBounds(91, 33, 90, 20);
			contentPanel.add(txtNumero);
			txtNumero.setColumns(10);
		}
		{
			btnConsultar = new JButton("Consultar");
			btnConsultar.addActionListener(this);
			btnConsultar.setBounds(220, 7, 106, 23);
			contentPanel.add(btnConsultar);
		}
		{
			textArea = new JTextArea();
			textArea.setBounds(10, 61, 316, 189);
			contentPanel.add(textArea);
		}
	
		
		
	}

	ArregloRetiro		ar = new ArregloRetiro();
	ArregloMatricula	am = new ArregloMatricula();
	ArregloAlumno		al = new ArregloAlumno();
	
	
	public void actionPerformed(ActionEvent e) {

		int indice=comboBox.getSelectedIndex();
		int codigo = leercodigo();
				
		switch (indice) {
			case 0:
				if (am.buscar(codigo) != null) {
					mensaje("Busqueda Realizado con exito");
					imprimir("Matricula Encontrada... ");
					imprimir("Codigo de matricula: " + am.buscar(codigo).getNum_matricula());
					int alumno = am.buscar(codigo).getCod_alumno();
					imprimir("Codigo del Alumno: " + alumno);
					imprimir("Fecha de la  Matricula: " + am.buscar(codigo).getFecha());
					imprimir("Hora de la Matricula: " + am.buscar(codigo).getHora());
					
					imprimir("Datos Del Alumno Matriculado: ... ");
					imprimir("Nombre del Alumno: " + al.buscar(alumno).getNombres());
					imprimir("Apellido del Alumno: " + al.buscar(alumno).getApellidos());
					imprimir("Dni del Alumno: " + al.buscar(alumno).getDni());
					imprimir("Edad del Alumno: " + al.buscar(alumno).getEdad());
					imprimir("Estado del Alumno: " + al.buscar(alumno).Estado(al.buscar(alumno).getEstado()));
					}
				else {
					error("El codigo no existe pruebe nuevamente",txtNumero);
				}
				break;
				
				// 100001
			case 1:
				if (ar.buscar(codigo) != null) {
					mensaje("Busqueda Realizado con exito");
					imprimir("Retiro Encontrado... ");
					imprimir("Codigo de Retiro: " + ar.buscar(codigo).getNumRetiro());
					int matricula = ar.buscar(codigo).getNumMatricula();
					imprimir("Codigo de Matricula: " + matricula);
					imprimir("Fecha del Retiro: " + ar.buscar(codigo).getFecha());
					imprimir("Hora del Retiro: " + ar.buscar(codigo).getHora());
					
					//DATOS DE LA MATRICULA
					
					imprimir("Datos De la matricula del Alumno: ... ");
					imprimir("Matricula Encontrada... ");
					imprimir("Codigo de matricula: " + am.buscar(codigo).getNum_matricula());
					int alumno = am.buscar(codigo).getCod_alumno();
					imprimir("Codigo del Alumno: " + alumno);
					imprimir("Fecha de la  Matricula: " + am.buscar(codigo).getFecha());
					imprimir("Hora de la Matricula: " + am.buscar(codigo).getHora());
				
					//DATOS DEL ALUMNO
					
					imprimir("Datos Del Alumno: ... ");
					imprimir("Nombre del Alumno: " + al.buscar(alumno).getNombres());
					imprimir("Apellido del Alumno: " + al.buscar(alumno).getApellidos());
					imprimir("Dni del Alumno: " + al.buscar(alumno).getDni());
					imprimir("Edad del Alumno: " + al.buscar(alumno).getEdad());
					imprimir("Estado del Alumno: " + al.buscar(alumno).Estado(al.buscar(alumno).getEstado()));
					
				}
				
				else {
					error("El codigo no existe pruebe nuevamente",txtNumero);
				}
				break;
		}	
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informacion", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	void imprimir(String s) {
		textArea.append(s + "\n");
	}
	public int leercodigo() {
		return Integer.parseInt(txtNumero.getText().trim());
	}
}


