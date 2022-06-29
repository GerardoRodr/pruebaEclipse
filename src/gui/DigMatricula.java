package gui;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;
import clases.Matricula;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.format.DateTimeFormatter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;  

public class DigMatricula extends JDialog implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblmatricula;
	private JTextField txtMatricula;
	private JLabel lblCodigoAlumno;
	private JLabel lblCodigoCurso;
	private JLabel lblHora;
	private JTextField txtCodigoAlumno;
	private JTextField txtCodigoCurso;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnModificar;
	private JButton btnEliminar;
	private DefaultTableModel modelo;
	private JButton btnAdicionar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DigMatricula dialog = new DigMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DigMatricula() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				habilitarEntradas(false);
				btnAceptar.setEnabled(false);
			}
		});
		setTitle("Matricula");
		setBounds(100, 100, 604, 317);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblmatricula = new JLabel("N° Matricula: ");
			lblmatricula.setBounds(10, 11, 99, 14);
			contentPanel.add(lblmatricula);
		}
		{
			txtMatricula = new JTextField();
			txtMatricula.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char validar = e.getKeyChar();
					
					if(Character.isLetter(validar)) {
						Toolkit.getDefaultToolkit().beep();
						e.consume();
						error("Ingrese Solo Numeros", txtMatricula);
					}
				}
			});
			txtMatricula.setBounds(138, 8, 86, 20);
			contentPanel.add(txtMatricula);
			txtMatricula.setColumns(10);
		}
		{
			lblCodigoAlumno = new JLabel("Codigo de Alumno: ");
			lblCodigoAlumno.setBounds(10, 36, 124, 14);
			contentPanel.add(lblCodigoAlumno);
		}
		{
			lblCodigoCurso = new JLabel("Codigo de Curso: ");
			lblCodigoCurso.setBounds(10, 61, 99, 14);
			contentPanel.add(lblCodigoCurso);
		}
		{
			JLabel lblFecha = new JLabel("Fecha: ");
			lblFecha.setBounds(10, 86, 99, 14);
			contentPanel.add(lblFecha);
		}
		{
			lblHora = new JLabel("Hora: ");
			lblHora.setBounds(10, 111, 99, 14);
			contentPanel.add(lblHora);
		}
		{
			txtCodigoAlumno = new JTextField();
			txtCodigoAlumno.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char validar = e.getKeyChar();
					
					if(Character.isLetter(validar)) {
						Toolkit.getDefaultToolkit().beep();
						e.consume();
						error("Ingrese Solo Numeros", txtCodigoAlumno);
					}
				}
			});
			txtCodigoAlumno.setBounds(138, 33, 86, 20);
			contentPanel.add(txtCodigoAlumno);
			txtCodigoAlumno.setColumns(10);
		}
		{
			txtCodigoCurso = new JTextField();
			txtCodigoCurso.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char validar = e.getKeyChar();
					
					if(Character.isLetter(validar)) {
						Toolkit.getDefaultToolkit().beep();
						e.consume();
						error("Ingrese Solo Numeros", txtCodigoCurso);
					}
				}
			});
			txtCodigoCurso.setBounds(138, 58, 86, 20);
			contentPanel.add(txtCodigoCurso);
			txtCodigoCurso.setColumns(10);
		}
		{
			txtFecha = new JTextField();
			txtFecha.setBounds(138, 83, 86, 20);
			contentPanel.add(txtFecha);
			txtFecha.setColumns(10);
		}
		{
			txtHora = new JTextField();
			txtHora.setBounds(138, 108, 86, 20);
			contentPanel.add(txtHora);
			txtHora.setColumns(10);
		}
		{
			btnConsultar = new JButton("Consultar");
			btnConsultar.addActionListener(this);
			btnConsultar.setBounds(489, 32, 89, 23);
			contentPanel.add(btnConsultar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setBounds(489, 57, 89, 23);
			contentPanel.add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(489, 82, 89, 23);
			contentPanel.add(btnEliminar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 136, 568, 131);
			contentPanel.add(scrollPane);
			
			table = new JTable() {
				private static final long serialVersionUID = 1L;

		        public boolean isCellEditable(int row, int column) {                
		                return false;               
		        };
			};
			table.addMouseListener(this);
			table.setCellSelectionEnabled(true);
			table.setColumnSelectionAllowed(true);
			scrollPane.setViewportView(table);
			
			modelo = new DefaultTableModel();
			//Posible bug de caracter mi estimado wil jejejejej
			modelo.addColumn("N° Matricula");
			modelo.addColumn("Codigo Alumno");
			modelo.addColumn("Codigo Curso");
			modelo.addColumn("Fecha");
			modelo.addColumn("Hora");
			
			table.setModel(modelo);
			
			Limpieza();
			ajustarAnchoColumnas();
			listar();
			editarFila();

			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.addActionListener(this);
			btnAdicionar.setBounds(489, 7, 89, 23);
			contentPanel.add(btnAdicionar);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(233, 7, 89, 23);
			contentPanel.add(btnAceptar);
		}
	
		
	}
	
	//Declaracion global
	ArregloMatricula	ma = new ArregloMatricula();
	ArregloCurso 		ac = new ArregloCurso();
	ArregloAlumno 		al = new ArregloAlumno();
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
	}
	
	public void actionPerformedBtnAceptar(ActionEvent e) {
		
		int numMatricula = leerNumMatricula();
		
		try {
			int CodigoAlumno =leerCodigoAlumno();

				if(al.buscar(CodigoAlumno) != null ) {
					if(al.buscar(CodigoAlumno).getEstado() < 2) {
						try{
							int CodigoCurso = leerCodigoCurso();
							if(ac.buscar(CodigoCurso) != null) {
								
								String fecha=leerFecha(),hora=leerHora();
								
								
								
								if (btnAdicionar.isEnabled() == false) {
									Matricula nuevo = new Matricula(numMatricula, CodigoAlumno, CodigoCurso, fecha, hora);
									ma.adicionar(nuevo);
									btnAdicionar.setEnabled(true);
									btnAceptar.setEnabled(false);
								}
								if (btnModificar.isEnabled() == false) {
									Matricula p = ma.buscar(numMatricula);
									p.setCod_alumno(CodigoAlumno);
									p.setCod_curso(CodigoCurso);
									ma.actualizarArchivo();
									btnModificar.setEnabled(true);
									btnAceptar.setEnabled(false);
								}
								listar();
								habilitarEntradas(false);
								
							}else {
								mensaje("El codigo de curso no existe");
							}
							
						}catch(Exception e1) {
							mensaje("Ingrese un codigo de Curso");
						}	
					}else {
						mensaje("No se puede registrar un alumno retirado");
					}
					
				}					
				 else {
					mensaje ("El codigo no existe");
				 }
		}catch(Exception e1) {
			mensaje("Ingrese un codigo de estudiante");
		}
	}
	
	public void actionPerformedBtnAdicionar(ActionEvent e) {
		btnAdicionar.setEnabled(false);
		btnAceptar.setEnabled(true);
		txtMatricula.requestFocus();
		Limpieza();
		txtFecha.setText(leerFecha());
		txtHora.setText(leerHora());
		habilitarEntradas(true);
	}
	
	public void actionPerformedBtnConsultar(ActionEvent e) {
		habilitarEntradas(false);
		habilitarBotones(true);
		btnConsultar.setEnabled(true);
		txtMatricula.setEnabled(true);
		txtMatricula.setEditable(true);
		
		int numMatricula = leerNumMatricula();
		Matricula x = ma.buscar(numMatricula);
		if (x != null) {
			txtCodigoAlumno.setText(String.valueOf(x.getCod_alumno()));
			txtCodigoCurso.setText(String.valueOf(x.getCod_curso()));
			txtFecha.setText(x.getFecha());
			txtHora.setText(x.getHora());
		} else {
			mensaje("El codigo no existe");
			Limpieza();
		}
	}
	
	public void actionPerformedBtnModificar(ActionEvent e) {
		 btnAdicionar.setEnabled(true);
		 btnModificar.setEnabled(false);
		 
		 if (ma.tamanio() == 0) {
			 btnAceptar.setEnabled(false);
			 habilitarEntradas(false);
			 mensaje("No existen Alumnos");
		 } else {
			 editarFila();
			 btnAceptar.setEnabled(true);
			 habilitarEntradas(true);
			 txtMatricula.setEditable(false);
			 txtCodigoAlumno.requestFocus();
		 }
	}
	
	public void actionPerformedBtnEliminar(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (ma.tamanio() == 0) {
			mensaje("No existen Alumnos");
		} else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("ï¿½Desea eliminar el registro?");
			if (ok == 0) {
				ma.eliminar(ma.buscar(leerNumMatricula()));
				listar();
				editarFila();
			}
		}
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(15));  	// Nï¿½ DigMatricula
		tcm.getColumn(1).setPreferredWidth(anchoColumna(15));  	// Codigo Alumno
		tcm.getColumn(2).setPreferredWidth(anchoColumna(15));  	// Codigo Curso
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  	// Fecha
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10));  	// Hora
	}
	
	void habilitarEntradas(boolean sino) {
		txtMatricula.setEditable(sino);
		txtCodigoAlumno.setEditable(sino);
		txtCodigoCurso.setEditable(sino);
		txtFecha.setEditable(sino);
		txtHora.setEditable(sino);
	}
	
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
	}
	
	public int leerNumMatricula() {
		return Integer.parseInt(txtMatricula.getText().trim());
	}
	
	public int leerCodigoAlumno() {
		return Integer.parseInt(txtCodigoAlumno.getText().trim());
	}
	
	public int leerCodigoCurso() {
		return Integer.parseInt(txtCodigoCurso.getText().trim());
	}
	
	public String leerFecha() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dtf.format(java.time.LocalDate.now());
	}
	
	public String leerHora() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		return dtf.format(java.time.LocalTime.now());
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informacion", 0);
	}
	
	void Limpieza() {
		txtMatricula.setText("" + ma.codigoCorrelativo());
		txtCodigoAlumno.setText("");
		txtCodigoCurso.setText("");
		txtFecha.setText("");
		txtHora.setText("");
	} 
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (modelo.getRowCount() == ma.tamanio() - 1)
			posFila = ma.tamanio() - 1;
		if (posFila == ma.tamanio())
			posFila --;
		modelo.setRowCount(0); 
		Matricula p;
		
		for (int i=0; i<ma.tamanio(); i++) {
			p = ma.obtener(i);
			Object[] fila = {	p.getNum_matricula(),
								p.getCod_alumno(),
								p.getCod_curso(),
								p.getFecha(),
						        p.getHora(),
								};
			modelo.addRow(fila);
		}
		
		if (ma.tamanio() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila() {
		if (ma.tamanio() == 0) {
			Limpieza();
		} else {
			Matricula p = ma.obtener(table.getSelectedRow());
			
			txtMatricula.setText(String.valueOf(p.getNum_matricula()));
			txtCodigoAlumno.setText(String.valueOf(p.getCod_alumno()));
			txtCodigoCurso.setText(String.valueOf(p.getCod_curso()));
			txtFecha.setText(p.getFecha());
			txtHora.setText(p.getHora());
		}
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
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
}
