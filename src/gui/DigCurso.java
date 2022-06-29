package gui;

import java.awt.Cursor;


import clases.Curso;
import arreglos.ArregloCurso;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;



public class DigCurso extends JDialog implements ActionListener , KeyListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//botones
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnConsultar;
	
	private JTable table;
	private DefaultTableModel modelo;
	
	private JTextField txtCodigo;
	private JTextField txtAsignatura;
	private JTextField txtCiclo;
	private JTextField txtCreditos;
	private JTextField txtCantidadHoras;
	
	private JLabel lblCodigo;
	private JLabel lblAsignatura;
	private JLabel lblCiclo;
	private JLabel lblCreditos;
	private JLabel lblCantidadHoras;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DigCurso dialog = new DigCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DigCurso() {
		setTitle("Curso");
		setBounds(100, 100, 700, 405);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 664, 219);
		getContentPane().add(scrollPane);
				
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(127, 8, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setBounds(10, 36, 69, 14);
		getContentPane().add(lblAsignatura);
		
		lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setBounds(10, 61, 46, 14);
		getContentPane().add(lblCiclo);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setColumns(10);
		txtAsignatura.setBounds(127, 33, 185, 20);
		getContentPane().add(txtAsignatura);
		
		txtCiclo = new JTextField();
		txtCiclo.setColumns(10);
		txtCiclo.setBounds(127, 58, 86, 20);
		getContentPane().add(txtCiclo);
		
		lblCreditos = new JLabel("N\u00B0 de Creditos:");
		lblCreditos.setBounds(10, 86, 86, 14);
		getContentPane().add(lblCreditos);
		
		txtCreditos = new JTextField();
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(127, 83, 86, 20);
		getContentPane().add(txtCreditos);
		
		lblCantidadHoras = new JLabel("Cantidad de horas:");
		lblCantidadHoras.setBounds(10, 111, 119, 14);
		getContentPane().add(lblCantidadHoras);
		
		txtCantidadHoras = new JTextField();
		txtCantidadHoras.setColumns(10);
		txtCantidadHoras.setBounds(127, 108, 86, 20);
		getContentPane().add(txtCantidadHoras);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(585, 82, 89, 23);
		getContentPane().add(btnConsultar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(585, 7, 89, 23);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(585, 32, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(585, 57, 89, 23);
		getContentPane().add(btnEliminar);
		
		table = new JTable() {
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Ciclo");
		modelo.addColumn("N° de Creditos");
		modelo.addColumn("N° Horas");
		table.setModel(modelo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(223, 7, 89, 23);
		getContentPane().add(btnAceptar);
		
		listar();
		
		habilitarEntradas(false);
		ajustarAnchoColumnas();
		listar();
		editarFila();
		
	}
	//Declaracion Global
	ArregloCurso ac = new ArregloCurso();
	private JButton btnAceptar;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		
	}
	
	
	
	
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		btnConsultar.setEnabled(true);
		Limpieza();
		habilitarEntradas(true);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (ac.tamanio() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen Alumnos");	
			}
		else{
			editarFila();
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			txtCodigo.requestFocus();
			}
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (ac.tamanio() == 0)
			mensaje("No existen Alumnos");
		else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("ï¿½ Desea eliminar el registro ?");
			if (ok == 0) {
				ac.eliminar(ac.buscar(LeerCodigo()));
				listar();
				editarFila();
			}
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			int codigo = LeerCodigo();
			if (codigo > 999 && codigo < 10000 && ac.buscar(codigo) == null ) {
				
				String asignatura = LeerAsignatura();
				if (asignatura.length() > 0) {
			
					try {
					int ciclo = LeerCiclo();			
					if (ciclo <= 6 && ciclo > 0) {			
						
						try {
						int creditos = LeerCredito();	
						if (creditos > 0 && creditos < 10 ) {
							
							try {
							int hora = LeerHora();				
							if(hora > 0 && hora < 10 ) {
										
								if (btnAdicionar.isEnabled() == false) {
									Curso nuevo = new Curso(codigo,asignatura,ciclo,creditos,hora);
									ac.adicionar(nuevo);
									btnAdicionar.setEnabled(true);
									listar();
								}
								if (btnModificar.isEnabled() == false) {
									Curso p = ac.buscar(codigo);
									p.setCodCurso(codigo);
									p.setAsignatura(asignatura);
									p.setCiclo(ciclo);
									p.setCreditos(creditos);
									p.setHoras(hora);
									ac.actualizarArchivo();
									btnModificar.setEnabled(true);
								}
								listar();
								habilitarEntradas(false);
							}
							else						{
												error("La hora no es valida",txtCantidadHoras);
												}
							}
							catch(Exception e1) {
								error("Ingrese una hora ",txtCantidadHoras);
								}
							
						}
						else					{
											error("Ingrese un numero valido",txtCreditos);
											}
						}
						catch(Exception e1) {
							error("ingrese numero de  Credito",txtCreditos);
							}
											
					}
					else{
										error("Ciclo no valido",txtCiclo);
										}
					}
					catch(Exception e1) {
						error("Ingrse un Ciclo",txtCiclo);
					}
				}
				else
					error("Ingrese una Asignatura", txtAsignatura);
			}
				if(ac.buscar(codigo) !=null){	
								error("El codigo ya Existe", txtCodigo);
				}
				else {
					error("Ingrese un codigo valido ", txtCodigo);
				}
		}
		catch (Exception e1) {
			error("Ingreso Codigo",txtCodigo);
		}
					
			
	
	
	}

		
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		habilitarBotones(true);
		
		txtCodigo.setEditable(true);
		txtCodigo.setEnabled(true);
		txtAsignatura.setEditable(false);
		txtCiclo.setEditable(false);
		txtCreditos.setEditable(false);
		txtCantidadHoras.setEditable(false);
		
		int codigo = LeerCodigo();
		Curso x = ac.buscar(codigo);
		if (x != null) {
			txtCodigo.setText(String.valueOf(x.getCodCurso()));
			txtAsignatura.setText(String.valueOf(x.getAsignatura()));
			txtCiclo.setText(String.valueOf(x.getCiclo()));
			txtCreditos.setText(String.valueOf(x.getCreditos()));
			txtCantidadHoras.setText(String.valueOf(x.getHoras()));
			
			txtCodigo.requestFocus();
		}
		else {
			mensaje("el CÃ“DIGO no existe");
			Limpieza();
		}
	}
	
	public void keyPressed(KeyEvent e) {		
	}
	public void keyReleased(KeyEvent e) {
		e.consume();
		editarFila();		
	}
	public void keyTyped(KeyEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTblPaciente(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnAceptar) {
			mouseEnteredBtnAceptar(e);
		}
		if (e.getSource() == btnEliminar) {
			mouseEnteredBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			mouseEnteredBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			mouseEnteredBtnAdicionar(e);
		}
		if (e.getSource() == table) {
			mouseEnteredTblAlumno(e);
		}
		if (e.getSource() == btnConsultar) {
			mouseEnteredBtnConsultar(e);
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	
	public void mouseReleased(MouseEvent e) {		
	}
	
	public void mouseExited(MouseEvent e) {
	}
	
	protected void mouseClickedTblPaciente(MouseEvent e) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	
	protected void mouseEnteredBtnAceptar(MouseEvent e) {
		btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredTblAlumno(MouseEvent e) {
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnAdicionar(MouseEvent e) {
		btnAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnModificar(MouseEvent e) {
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnEliminar(MouseEvent e) {
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnConsultar(MouseEvent e) {
		btnConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(15));  	// Codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(45));  	// Asignatura
		tcm.getColumn(2).setPreferredWidth(anchoColumna(15));  	// Ciclo
		tcm.getColumn(3).setPreferredWidth(anchoColumna(15));  	// Creditos
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10));  	// Horas

		
		
	}
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (modelo.getRowCount() == ac.tamanio() - 1)
			posFila = ac.tamanio() - 1;
		if (posFila == ac.tamanio())
			posFila --;
		modelo.setRowCount(0);
		Curso p;
		for (int i=0; i<ac.tamanio(); i++) {
			p = ac.obtener(i);
			Object[] fila = {	p.getCodCurso(),
								p.getAsignatura(),
								p.getCiclo(),
						        p.getCreditos(),
						        p.getHoras()
								};
			modelo.addRow(fila);
		}
		if (ac.tamanio() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila() {
		if (ac.tamanio() == 0)
			Limpieza();
		else {
			Curso p = ac.obtener(table.getSelectedRow());
			txtCodigo.setText(String.valueOf(+p.getCodCurso()));
			txtAsignatura.setText(p.getAsignatura());
			txtCiclo.setText(String.valueOf(p.getCiclo()));
			txtCreditos.setText(String.valueOf(p.getCreditos()));
			txtCantidadHoras.setText(String.valueOf(p.getHoras()));
			
		}
	}
	
	void Limpieza() {
		txtCodigo.setText("");
		txtAsignatura.setText("");
		txtCiclo.setText("");
		txtCreditos.setText("");
		txtCantidadHoras.setText("");	

	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informacion", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	} 
	void habilitarEntradas(boolean sino) {
		txtAsignatura.setEditable(sino);
		txtCantidadHoras.setEditable(sino);
		txtCiclo.setEditable(sino);
		txtCodigo.setEditable(sino);
		txtCreditos.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
	}
	
	
	public String LeerAsignatura() {
		return txtAsignatura.getText().trim();
	}
	
	public int LeerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	
	public int LeerCiclo(){
		return Integer.parseInt(txtCiclo.getText().trim());
	}
	
	public int LeerCredito() {
		return 	Integer.parseInt(txtCreditos.getText().trim());
	}
	public int LeerHora() {
		return Integer.parseInt(txtCantidadHoras.getText().trim());
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
}
