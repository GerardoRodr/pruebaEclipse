package gui;

import clases.Alumno;
import arreglos.ArregloAlumno;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;

public class DigAlumno extends JDialog implements ActionListener, KeyListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2553211279106642545L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtEdad;
	private JTextField txtCelular;
	private JTable table;
	private DefaultTableModel modelo;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblEdad;
	private JLabel lblCelular;
	private JLabel lblEstado;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAdicionar;
	private JScrollPane scrollPane;
	private JButton btnConsultar;
	private JButton btnAceptar;
	private JComboBox<String> cboEstado;
	
	
	
	public String compara = ""; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DigAlumno dialog = new DigAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DigAlumno() {
		setTitle("Alumnos");
		setBounds(100, 100, 718, 415);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 702, 376);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(10, 11, 63, 14);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setBounds(100, 8, 86, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombres: ");
		lblNombre.setBounds(10, 36, 63, 14);
		contentPanel.add(lblNombre);
		
		txtNombres = new JTextField();
		txtNombres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(Character.isDigit(validar)) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
					error("Ingrese Solo Letras", txtNombres);
					
				}
			}
		});
		txtNombres.setBounds(100, 33, 185, 20);
		contentPanel.add(txtNombres);
		txtNombres.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 61, 63, 14);
		contentPanel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					char validar = e.getKeyChar();
					
					if(Character.isDigit(validar)) {
						Toolkit.getDefaultToolkit().beep();
						e.consume();
						error("Ingrese Solo Letras", txtApellido);
					}
				}
		});
		txtApellido.setBounds(100, 58, 185, 20);
		contentPanel.add(txtApellido);
		txtApellido.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 86, 63, 14);
		contentPanel.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(Character.isLetter(validar)) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
					error("Ingrese Solo Numeros", txtDni);
				}
			}
		});
		txtDni.setBounds(100, 83, 86, 20);
		contentPanel.add(txtDni);
		txtDni.setColumns(10);
		
		lblEdad = new JLabel("Edad: ");
		lblEdad.setBounds(10, 111, 49, 14);
		contentPanel.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(Character.isLetter(validar)) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
					error("Ingrese Solo Numeros", txtEdad);
				}
			}
		});
		txtEdad.setBounds(100, 108, 86, 20);
		contentPanel.add(txtEdad);
		txtEdad.setColumns(10);
		
		lblCelular = new JLabel("Celular: ");
		lblCelular.setBounds(10, 136, 49, 14);
		contentPanel.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(Character.isLetter(validar)) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
					error("Ingrese Solo Numeros", txtEdad);
				}
			}
		});
		txtCelular.setBounds(100, 133, 86, 20);
		contentPanel.add(txtCelular);
		txtCelular.setColumns(10);
		
		lblEstado = new JLabel("Estado: ");
		lblEstado.setBounds(10, 161, 63, 14);
		contentPanel.add(lblEstado);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setBounds(502, 32, 192, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setBounds(502, 57, 192, 23);
		contentPanel.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 186, 684, 179);
		contentPanel.add(scrollPane);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.addMouseListener(this);
		btnConsultar.setBounds(502, 82, 192, 23);
		contentPanel.add(btnConsultar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.addMouseListener(this);
		btnAdicionar.setBounds(502, 7, 192, 23);
		contentPanel.add(btnAdicionar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(196, 7, 89, 23);
		contentPanel.add(btnAceptar);

		cboEstado = new JComboBox<String>();
		cboEstado.addActionListener(this);
		cboEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"Registrado", "Matriculado", "Retirado"}));
		cboEstado.setBounds(100, 157, 86, 22);
		contentPanel.add(cboEstado);
		cboEstado.setEnabled(false);
		
		table = new JTable() {
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
	
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("DNI");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Nombres");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		modelo.addColumn("Estado");
		
		table.setModel(modelo);

		
		txtCodigo.setEditable(false);
		
		habilitarEntradas(false);
		ajustarAnchoColumnas();
		listar();
		editarFila();
	}
	//Declaracion Global
		ArregloAlumno al = new ArregloAlumno();
		

		
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
		txtCodigo.setEditable(false);
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		btnConsultar.setEnabled(true);
		Limpieza();
		habilitarEntradas(true);
		txtNombres.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (al.tamanio() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen Alumnos");	
			}
		else{
			editarFila();
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			txtNombres.requestFocus();
			}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (al.tamanio() == 0)
			mensaje("No existen Alumnos");
		else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("� Desea eliminar el registro ?");
			if (ok == 0) {
				al.eliminar(al.buscar(leerCodigo()));
				listar();
				editarFila();
			}
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		int codigo = leerCodigo();
			String nombre = LeerNombres();
			if (nombre.length() > 0) {
	
				String apellido = LeerApellido();			
				if (apellido.length() > 0) {			
					
	
					String dni = leerDNI();	
					if (dni.length() == 8) {
						try {
							
						int edad = leerEdad();	
						if(edad >= 17 && edad <= 99 ) {
									
							int celular = leerCelular();
							if(celular>900000000 && celular <= 999999999) {
								
							
							int estado= leerEstado();
							
							if (btnAdicionar.isEnabled() == false) {
								Alumno nuevo = new Alumno(codigo,dni,nombre,apellido,edad,celular,estado);
								al.adicionar(nuevo);
								btnAdicionar.setEnabled(true);
								listar();
							}
							if (btnModificar.isEnabled() == false) {
								Alumno p = al.buscar(codigo);
								p.setCodAlumno(codigo);
								p.setDni(dni);
								p.setApellidos(apellido);
								p.setNombres(nombre);
								p.setEdad(edad);
								p.setCelular(celular);
								p.setEstado(estado);
								al.actualizarArchivo();
								btnModificar.setEnabled(true);
							}
							listar();
							habilitarEntradas(false);
						
							}
							else
								error("Ingrese celular valido",txtCelular);
						}
						
						
						else						{
											error("Edad no valida",txtEdad);
											}
						} catch (Exception e1) {
							error("Ingrese una edad", txtEdad);
						}
					}
					else					{
										error("Dni no valido",txtDni);
										}
										
				}
				else{
									error("ingrese un apellido",txtApellido);
									}			
			}
			else
				error("Ingrese un nombre", txtNombres);
	
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnAceptar.setEnabled(false);
		txtCodigo.setEditable(true);
		txtCodigo.setEnabled(true);
		txtApellido.setEditable(false);
		txtCelular.setEditable(false);
		txtDni.setEditable(false);
		txtEdad.setEditable(false);
		txtNombres.setEditable(false);
		cboEstado.setEnabled(false);
		int codigo = leerCodigo();
		Alumno x = al.buscar(codigo);
		if (x != null) {
			txtCodigo.setText(String.valueOf(x.getCodAlumno()));
			txtDni.setText(String.valueOf(x.getDni()));
			txtNombres.setText(String.valueOf(x.getNombres()));
			txtApellido.setText(String.valueOf(x.getApellidos()));
			txtEdad.setText(String.valueOf(x.getEdad()));
			txtCelular.setText(String.valueOf(x.getCelular()));
			cboEstado.setSelectedIndex(x.getEstado());
			
			txtCodigo.requestFocus();
		}
		else {
			mensaje("el CÓDIGO no existe");
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
		tcm.getColumn(1).setPreferredWidth(anchoColumna(15));  	// DNI
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));  	// Apellidos
		tcm.getColumn(3).setPreferredWidth(anchoColumna(23));  	// Nombres
		tcm.getColumn(4).setPreferredWidth(anchoColumna(7));  	// Edad
		tcm.getColumn(5).setPreferredWidth(anchoColumna(10));	// Celular
		tcm.getColumn(6).setPreferredWidth(anchoColumna(10));	// Estado
		
	}
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (modelo.getRowCount() == al.tamanio() - 1)
			posFila = al.tamanio() - 1;
		if (posFila == al.tamanio())
			posFila --;
		modelo.setRowCount(0);
		Alumno p;
		for (int i=0; i<al.tamanio(); i++) {
			p = al.obtener(i);
			Object[] fila = {	p.getCodAlumno(),
								p.getDni(),
								p.getApellidos(),
						        p.getNombres(),
						        p.getEdad(),
						        p.getCelular(),
						        p.Estado(p.getEstado())
								};
			modelo.addRow(fila);
		}
		if (al.tamanio() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila() {
		if (al.tamanio() == 0)
			Limpieza();
		else {
			Alumno p = al.obtener(table.getSelectedRow());
			txtCodigo.setText(String.valueOf(+p.getCodAlumno()));
			txtNombres.setText(p.getNombres());
			txtApellido.setText(p.getApellidos());
			txtCelular.setText(String.valueOf(p.getCelular()));
			txtDni.setText(p.getDni());
			txtEdad.setText(String.valueOf(p.getEdad()));
			cboEstado.setSelectedIndex(p.getEstado());
		}
	}
	
	void Limpieza() {
		txtCodigo.setText("" + al.codigoCorrelativo());
		txtNombres.setText("");
		txtApellido.setText("");
		txtCelular.setText("");
		txtDni.setText("");	
		txtEdad.setText("");
		cboEstado.setSelectedIndex(0);
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
		btnAceptar.setEnabled(sino);
		txtNombres.setEditable(sino);
		txtApellido.setEditable(sino);
		txtCelular.setEditable(sino);
		txtDni.setEditable(sino);
		txtEdad.setEditable(sino);
		cboEstado.setEnabled(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
	}
	void comparardni () {
		
		int	a=Integer.parseInt(txtCodigo.getText().trim());
			compara= al.buscar(a).getDni();
		
		
	}

	public String LeerApellido() {
		return txtApellido.getText().trim();
	}
	
	public String LeerNombres() {
			return txtNombres.getText().trim();
	}

	public int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	public String leerDNI(){
		return txtDni.getText().trim();
	}
	
	public int leerEdad(){
		return Integer.parseInt(txtEdad.getText().trim());
	}
	
	public int leerEstado(){
		return cboEstado.getSelectedIndex();
	}
	public int leerCelular() {
		return 	Integer.parseInt(txtCelular.getText().trim());
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
}
