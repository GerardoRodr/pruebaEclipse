package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloMatricula;
import arreglos.ArregloRetiro;
import clases.Retiro;

public class DigRetiro extends JDialog implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JScrollPane scrollPane;
	private JTextField txtCodigo;
	private JLabel lblFechaRetiro;
	private JLabel lblHora;
	private JTextField txtFechaRetiro;
	private JTextField txtHora;
	private JButton btnAceptar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable table;
	private JButton btnConsultar;
	private DefaultTableModel modelo;
	private JLabel lblNumMatricula;
	private JTextField txtNumMatricula;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DigRetiro dialog = new DigRetiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DigRetiro() {
		setTitle("Retiro");
		setBounds(100, 100, 700, 370);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 664, 208);
		getContentPane().add(scrollPane);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(127, 8, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblFechaRetiro = new JLabel("Fecha de retiro:");
		lblFechaRetiro.setBounds(10, 61, 107, 14);
		getContentPane().add(lblFechaRetiro);
		
		lblHora = new JLabel("Hora:");
		lblHora.setBounds(10, 86, 46, 14);
		getContentPane().add(lblHora);
		
		txtFechaRetiro = new JTextField();
		txtFechaRetiro.setColumns(10);
		txtFechaRetiro.setBounds(127, 58, 86, 20);
		getContentPane().add(txtFechaRetiro);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(127, 83, 86, 20);
		getContentPane().add(txtHora);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(223, 7, 89, 23);
		getContentPane().add(btnAceptar);
		
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
	
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(585, 82, 89, 23);
		getContentPane().add(btnConsultar);
		
		lblNumMatricula = new JLabel("N° de Matricula:");
		lblNumMatricula.setBounds(10, 36, 107, 14);
		getContentPane().add(lblNumMatricula);
		
		txtNumMatricula = new JTextField();
		txtNumMatricula.setBounds(127, 33, 86, 20);
		getContentPane().add(txtNumMatricula);
		txtNumMatricula.setColumns(10);
		
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
		//Posible bug de caracter mi estimado wil jejejejej
		modelo.addColumn("Numero Retiro");
		modelo.addColumn("Numero Matricula");
		modelo.addColumn("Fecha Registro");
		modelo.addColumn("Hora Registro");
		
		table.setModel(modelo);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
	}
	ArregloRetiro ar = new ArregloRetiro();
	ArregloMatricula am = new ArregloMatricula();

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
		
			int codigoretiro = LeerCodigo();
			if (txtNumMatricula.getText().isEmpty()) {
				mensaje("Ingrese un numero de matricula por favor");
			}
			else {
				
					int numMatricula = LeerMatricula();
					if(am.buscar(numMatricula) != null) {			
						
						String fecha	= leerFecha();
						String hora 	= leerHora();
						if (btnAdicionar.isEnabled() == false) {
							Retiro nuevo = new Retiro(codigoretiro,numMatricula,fecha,hora);
							ar.adicionar(nuevo);
							btnAdicionar.setEnabled(true);
							btnAceptar.setEnabled(false);
							am.eliminar(am.buscar(numMatricula));
						}
						if (btnModificar.isEnabled() == false) {
							Retiro p = ar.buscar(codigoretiro);
							p.setNumRetiro(codigoretiro);
							p.setNumMatricula(numMatricula);
							ar.actualizarArchivo();
							btnModificar.setEnabled(true);
							btnAceptar.setEnabled(false);
						}
					
						listar();
						editarFila();
				}
					else {
						error("El numero de matricula no Existe",txtNumMatricula);
					}
			}
				
		}
	
	
	public void actionPerformedBtnAdicionar(ActionEvent e) {
		btnAdicionar.setEnabled(false);
		btnAceptar.setEnabled(true);
		txtNumMatricula.requestFocus();
		txtFechaRetiro.setEnabled(false);
		txtHora.setEnabled(false);
		Limpieza();
		txtFechaRetiro.setText(leerFecha());
		txtHora.setText(leerHora());
		habilitarEntradas(true);
	}
	
	public void actionPerformedBtnConsultar(ActionEvent e) {
		habilitarEntradas(false);
		habilitarBotones(true);
		btnConsultar.setEnabled(true);
		txtCodigo.setEnabled(true);
		txtCodigo.setEditable(true);
		
		int codMatricula = LeerCodigo();
		Retiro x = ar.buscar(codMatricula);
		if (x != null) {
			txtCodigo.setText(String.valueOf(x.getNumRetiro()));
			txtNumMatricula.setText(String.valueOf(x.getNumMatricula()));
			txtFechaRetiro.setText(x.getFecha());
			txtHora.setText(x.getHora());
		} else {
			mensaje("El codigo no existe");
			Limpieza();
		}
	}
	

	public void actionPerformedBtnModificar(ActionEvent e) {
		 btnAdicionar.setEnabled(true);
		 btnModificar.setEnabled(false);
		 
		 if (ar.tamanio() == 0) {
			 btnAceptar.setEnabled(false);
			 habilitarEntradas(false);
			 mensaje("No existen Alumnos");
		 } else {
			 editarFila();
			 btnAceptar.setEnabled(true);
			 habilitarEntradas(true);
			 txtCodigo.setEditable(false);
			 txtNumMatricula.requestFocus();
		 }
	}
	
	public void actionPerformedBtnEliminar(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (ar.tamanio() == 0) {
			mensaje("No existen Alumnos");
		} else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("ï¿½Desea eliminar el registro?");
			if (ok == 0) {
				ar.eliminar(ar.buscar(LeerCodigo()));
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
		tcm.getColumn(0).setPreferredWidth(anchoColumna(25));  	// Nï¿½ retiro
		tcm.getColumn(1).setPreferredWidth(anchoColumna(25));  	// matricula
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25));  	// fecha
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25));  	// hora

	}
	
	void habilitarEntradas(boolean sino) {
		txtCodigo.setEditable(sino);
		txtFechaRetiro.setEditable(sino);
		txtHora.setEditable(sino);
		txtHora.setEditable(sino);
	}
	
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
	}
	
	public int LeerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	public int LeerMatricula() {
		return Integer.parseInt(txtNumMatricula.getText().trim());
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
		txtCodigo.setText(String.valueOf(ar.codigoCorrelativo()));
		txtNumMatricula.setText("");
		txtFechaRetiro.setText("");
		txtHora.setText("");
		txtNumMatricula.requestFocus();
		}  
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (modelo.getRowCount() == ar.tamanio() - 1)
			posFila = ar.tamanio() - 1;
		if (posFila == ar.tamanio())
			posFila --;
		modelo.setRowCount(0);
		Retiro p;
		
		for (int i=0; i<ar.tamanio(); i++) {
			p = ar.obtener(i);
			Object[] fila = {	p.getNumRetiro(),
								p.getNumMatricula(),
								p.getFecha(),
						        p.getHora(),
								};
			modelo.addRow(fila);
		}
		if (ar.tamanio() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila() {
		if (ar.tamanio() == 0) {
			Limpieza();
		} else {
			Retiro p = ar.obtener(table.getSelectedRow());
			txtCodigo.setText(String.valueOf(p.getNumRetiro()));
			txtNumMatricula.setText(String.valueOf(p.getNumMatricula()));
			txtFechaRetiro.setText(String.valueOf(p.getFecha()));
			txtHora.setText(String.valueOf(p.getHora()));
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