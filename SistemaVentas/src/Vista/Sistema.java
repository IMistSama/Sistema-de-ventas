package Vista;

import java.awt.EventQueue;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

import java.util.Iterator;
import java.util.List;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.TextArea;
import Model.Cliente;
import Model.ClienteDao;

import java.awt.Cursor;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sistema extends javax.swing.JFrame {
	
	
	
	Cliente cl = new Cliente(); 
	ClienteDao 	client = new ClienteDao();
	DefaultTableModel modelo =  new DefaultTableModel();
    
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoVenta;
	private JTextField txtDescripcionVenta;
	private JTextField txtCantidadVenta;
	private JTextField txtPrecioVenta;
	private JTextField txtStockDisponible;
	private JTable TableVenta;
	private JTextField txtRucVenta;
	private JTextField txtNombreClienteVenta;
	private JTextField txtDniCliente;
	private JTextField txtNombreCliente;
	private JTextField txtTelefonoCliente;
	private JTextField txtDireccionCliente;
	private JTextField txtRazonCliente;
	private JTable TableCliente;
	private JTextField txtRucProvedor;
	private JTextField txtNombreProvedor;
	private JTextField txtTelefonoProvedor;
	private JTextField txtDireccionProvedor;
	private JTextField txtRazonProvedor;
	private JTextField txtCodigoPro;
	private JTextField txtDesPro;
	private JTextField txtCanPro;
	private JTextField txtPrecioPro;
	private JTable table_Pro;
	private JTable table_Ventas2;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField txtTelefonoClienteVenta;
	private JTextField txtDireccionClienteVenta;
	private JTextField txtRazonClienteVenta;
	private JTextField txtidCliente;
	private JTextField txtidProveedores;
	private JTextField txtidPro;
	private JTextField txtidVentas;
	private JTextField txtidPro2;
	 private JTabbedPane tabbedPane1;
	    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema frame = new Sistema();
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
	public Sistema() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 827);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 220, 788);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Nueva Venta ");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\Nventa.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//............................................
		this.setLocationRelativeTo(null);
		btnNewButton.setBounds(40, 192, 151, 49);
		panel.add(btnNewButton);
		
		 JButton btnNewButton_1 = new JButton("Clientes\r\n");
	        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\Clientes.png"));
	        btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Asegúrate de que ListarCliente() establezca la conexión correctamente
	                ListarCliente(); 

	                LimpiarTable();
	                LimpiarCliente();
	                
	                // Luego realiza otras operaciones
	                tabbedPane1.setSelectedIndex(1);
	            }
	        });

		
		
		btnNewButton_1.setBounds(40, 267, 151, 49);
		panel.add(btnNewButton_1);
		 
	
		
		JButton btnNewButton_2 = new JButton("Proveedor\r\n");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\proveedor.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(40, 337, 151, 49);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Productos\r\n");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\producto.png"));
		btnNewButton_3.setBounds(40, 404, 151, 49);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Ventas\r\n");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\compras.png"));
		btnNewButton_4.setBounds(40, 472, 151, 49);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Configuracion\r\n");
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\config.png"));
		btnNewButton_5.setBounds(40, 544, 151, 49);
		panel.add(btnNewButton_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(219, 0, 1040, 197);
		panel_2.setBackground(new Color(176, 196, 222));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PUNTO DE VENTA ");
		lblNewLabel.setBackground(new Color(70, 130, 180));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 44));
		lblNewLabel.setBounds(24, 27, 627, 138);
		panel_2.add(lblNewLabel);
		
		tabbedPane1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane1.setBounds(230, 205, 870, 414);
		contentPane.add(tabbedPane1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		tabbedPane1.addTab("New tab", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo ");
		lblNewLabel_1.setBounds(27, 22, 46, 14);
		panel_7.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion ");
		lblNewLabel_2.setBounds(117, 17, 102, 25);
		panel_7.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad ");
		lblNewLabel_3.setBounds(248, 22, 46, 14);
		panel_7.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Precio ");
		lblNewLabel_4.setBounds(368, 22, 46, 14);
		panel_7.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Stock\r\n");
		lblNewLabel_5.setBounds(492, 22, 46, 14);
		panel_7.add(lblNewLabel_5);
		
		JButton btnEliminarVenta = new JButton("");
		btnEliminarVenta.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\eliminar.png"));
		btnEliminarVenta.setBounds(605, 44, 89, 23);
		panel_7.add(btnEliminarVenta);
		
		txtCodigoVenta = new JTextField();
		txtCodigoVenta.setBounds(10, 47, 86, 20);
		panel_7.add(txtCodigoVenta);
		txtCodigoVenta.setColumns(10);
		
		txtDescripcionVenta = new JTextField();
		txtDescripcionVenta.setBounds(117, 47, 86, 20);
		panel_7.add(txtDescripcionVenta);
		txtDescripcionVenta.setColumns(10);
		
		txtCantidadVenta = new JTextField();
		txtCantidadVenta.setBounds(229, 47, 86, 20);
		panel_7.add(txtCantidadVenta);
		txtCantidadVenta.setColumns(10);
		
		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setEditable(false);
		txtPrecioVenta.setBounds(351, 47, 86, 20);
		panel_7.add(txtPrecioVenta);
		txtPrecioVenta.setColumns(10);
		
		txtStockDisponible = new JTextField();
		txtStockDisponible.setBounds(473, 47, 86, 20);
		panel_7.add(txtStockDisponible);
		txtStockDisponible.setColumns(10);
		
		TableVenta = new JTable();
		TableVenta.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Descripcion ", "Cantidad ", "Precio", "Total "
			}
		));
		TableVenta.getColumnModel().getColumn(0).setPreferredWidth(30);
		TableVenta.getColumnModel().getColumn(1).setPreferredWidth(100);
		TableVenta.getColumnModel().getColumn(2).setPreferredWidth(30);
		TableVenta.getColumnModel().getColumn(3).setPreferredWidth(30);
		TableVenta.getColumnModel().getColumn(4).setPreferredWidth(40);
		TableVenta.setBounds(20, 78, 679, 147);
		panel_7.add(TableVenta);
		
		JLabel lblNewLabel_7 = new JLabel("DNI/RUC");
		lblNewLabel_7.setBounds(10, 281, 46, 14);
		panel_7.add(lblNewLabel_7);
		
		txtRucVenta = new JTextField();
		txtRucVenta.setBounds(10, 306, 111, 20);
		panel_7.add(txtRucVenta);
		txtRucVenta.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("NOMBRE");
		lblNewLabel_6.setBounds(151, 281, 86, 14);
		panel_7.add(lblNewLabel_6);
		
		txtNombreClienteVenta = new JTextField();
		txtNombreClienteVenta.setBounds(151, 306, 209, 20);
		panel_7.add(txtNombreClienteVenta);
		txtNombreClienteVenta.setColumns(10);
		
		JButton btnGenerarVenta = new JButton("");
		btnGenerarVenta.setBounds(421, 321, 117, 55);
		panel_7.add(btnGenerarVenta);
		btnGenerarVenta.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\print.png"));
		
		JLabel lblNewLabel_8 = new JLabel("TOTAL A PAGAR ");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\money.png"));
		lblNewLabel_8.setBounds(583, 331, 122, 42);
		panel_7.add(lblNewLabel_8);
		
		JLabel LabelTotal = new JLabel("......");
		LabelTotal.setBounds(740, 345, 46, 14);
		panel_7.add(LabelTotal);
		
		txtTelefonoClienteVenta = new JTextField();
		txtTelefonoClienteVenta.setBounds(10, 356, 46, 20);
		panel_7.add(txtTelefonoClienteVenta);
		txtTelefonoClienteVenta.setColumns(10);
		
		txtDireccionClienteVenta = new JTextField();
		txtDireccionClienteVenta.setBounds(80, 356, 63, 20);
		panel_7.add(txtDireccionClienteVenta);
		txtDireccionClienteVenta.setColumns(10);
		
		txtRazonClienteVenta = new JTextField();
		txtRazonClienteVenta.setBounds(171, 356, 86, 20);
		panel_7.add(txtRazonClienteVenta);
		txtRazonClienteVenta.setColumns(10);
		
		txtidPro2 = new JTextField();
		txtidPro2.setBounds(569, 44, 19, 20);
		panel_7.add(txtidPro2);
		txtidPro2.setColumns(10);
		
		JPanel pane1 = new JPanel();
		pane1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabbedPane1.addTab("New tab", null, pane1, null);
		pane1.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Dni/Ruc:");
		lblNewLabel_10.setBounds(10, 34, 88, 14);
		pane1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Nombre ");
		lblNewLabel_11.setBounds(10, 70, 69, 14);
		pane1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Telefono");
		lblNewLabel_12.setBounds(10, 108, 69, 14);
		pane1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Direccion");
		lblNewLabel_13.setBounds(10, 145, 69, 14);
		pane1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Razon social ");
		lblNewLabel_14.setBounds(10, 178, 98, 14);
		pane1.add(lblNewLabel_14);
		
		txtDniCliente = new JTextField();
		txtDniCliente.setBounds(108, 31, 140, 20);
		pane1.add(txtDniCliente);
		txtDniCliente.setColumns(10);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(108, 67, 140, 20);
		pane1.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		txtTelefonoCliente = new JTextField();
		txtTelefonoCliente.setBounds(108, 105, 140, 20);
		pane1.add(txtTelefonoCliente);
		txtTelefonoCliente.setColumns(10);
		
		txtDireccionCliente = new JTextField();
		txtDireccionCliente.setBounds(108, 142, 140, 20);
		pane1.add(txtDireccionCliente);
		txtDireccionCliente.setColumns(10);
		
		txtRazonCliente = new JTextField();
		txtRazonCliente.setBounds(108, 175, 140, 20);
		pane1.add(txtRazonCliente);
		txtRazonCliente.setColumns(10);
		
		TableCliente = new JTable();
		TableCliente.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int fila = TableCliente.rowAtPoint(e.getPoint());
		        txtidCliente.setText(TableCliente.getValueAt(fila, 0).toString());
		        txtDniCliente.setText(TableCliente.getValueAt(fila, 1).toString());
		        txtNombreCliente.setText(TableCliente.getValueAt(fila, 2).toString());
		        txtTelefonoCliente.setText(TableCliente.getValueAt(fila, 3).toString());
		        txtDireccionCliente.setText(TableCliente.getValueAt(fila, 4).toString());
		        txtRazonCliente.setText(TableCliente.getValueAt(fila, 4).toString());
		       
		        // ... continue with the rest of your code
		    }
		});
		
		TableCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Dni/ruc", "Nombre", "Telefono ", "Direccion ", "Razon social", "New column"
			}
		));
		TableCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
		TableCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
		TableCliente.setBounds(258, 34, 568, 158);
		pane1.add(TableCliente);
		
		JButton btnGuardarCliente = new JButton("");
		btnGuardarCliente.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!"".equals(txtDniCliente.getText()) || !"".equals(txtNombreCliente.getText()) || !"".equals(txtTelefonoCliente.getText()) || !"".equals(txtDireccionCliente.getText())) {
		         
		            cl.setDni(Integer.parseInt(txtDniCliente.getText()));
		            cl.setNombre(txtNombreCliente.getText());
		            
		            cl.setTelefono(Double.parseDouble(txtTelefonoCliente.getText()));
		  
		            cl.setDireccion(txtDireccionCliente.getText());
		            cl.setRazon(txtRazonCliente.getText());
		            client.RegistrarCliente(cl);
		            
		            LimpiarTable();
		            LimpiarCliente();
					ListarCliente();
		            
		            JOptionPane.showMessageDialog(null, "Cliente registrado");
		       
		        } else {
		            JOptionPane.showMessageDialog(null, "Los campos están vacíos");
		        }
		    }
		});


		
		
		
		
		
		
		btnGuardarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardarCliente.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\GuardarTodo.png"));
		btnGuardarCliente.setBounds(9, 238, 99, 33);
		pane1.add(btnGuardarCliente);
		
		JButton btnEditarCliente = new JButton("");
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				if (!"".equals(txtDniCliente.getText()) && !"".equals(txtNombreCliente.getText()) && !"".equals(txtTelefonoCliente.getText()) && !"".equals(txtDireccionCliente.getText()) && !"".equals(txtRazonCliente.getText()) && !"".equals(txtidCliente.getText())) {
				    cl.setDni(Integer.parseInt(txtDniCliente.getText()));
				    cl.setNombre(txtNombreCliente.getText());
				    cl.setTelefono(Double.parseDouble(txtTelefonoCliente.getText()));
				    cl.setDireccion(txtDireccionCliente.getText());
				    cl.setRazon(txtRazonCliente.getText());
				    cl.setId(Integer.parseInt(txtidCliente.getText()));
				    client.ModificarCliente(cl);
				    LimpiarTable();
				    LimpiarCliente();
				    ListarCliente();
				} else {
				    JOptionPane.showMessageDialog(null, "Los campos están vacíos");
				}

				
				
				
			
				
				
			}
		});
		btnEditarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarCliente.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\Actualizar (2).png"));
		btnEditarCliente.setBounds(133, 238, 98, 33);
		pane1.add(btnEditarCliente);
		//...............
		// ... (código anterior)

		JButton btnEliminarCliente = new JButton("");
		btnEliminarCliente.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!"".equals(txtidCliente.getText())) {
		            int pregunta = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar ");
		            if (pregunta == 0) {
		                int id = Integer.parseInt(txtidCliente.getText());
		                client.EliminarCliente(id);

		                // Limpia los datos después de eliminar el cliente
		                LimpiarTable();
		                LimpiarCliente();
		                ListarCliente();
		            }
		        }
		    }
		});
		btnEliminarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarCliente.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\eliminar.png"));
		btnEliminarCliente.setBounds(9, 291, 98, 33);
		pane1.add(btnEliminarCliente);

		// ... (código posterior)

		
		
		//...............
		JButton btnNuevoCliente = new JButton("");
		btnNuevoCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevoCliente.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\nuevo.png"));
		btnNuevoCliente.setBounds(133, 291, 98, 33);
		pane1.add(btnNuevoCliente);
		
		txtidCliente = new JTextField();
		txtidCliente.setBounds(309, 309, 22, 20);
		pane1.add(txtidCliente);
		txtidCliente.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		tabbedPane1.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("Ruc");
		lblNewLabel_15.setBounds(10, 34, 75, 14);
		panel_3.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Nombre");
		lblNewLabel_16.setBounds(10, 75, 75, 14);
		panel_3.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Telefono");
		lblNewLabel_17.setBounds(10, 112, 75, 14);
		panel_3.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Direccion");
		lblNewLabel_18.setBounds(10, 156, 75, 14);
		panel_3.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Razon social");
		lblNewLabel_19.setBounds(10, 190, 83, 14);
		panel_3.add(lblNewLabel_19);
		
		txtRucProvedor = new JTextField();
		txtRucProvedor.setBounds(121, 31, 137, 20);
		panel_3.add(txtRucProvedor);
		txtRucProvedor.setColumns(10);
		
		txtNombreProvedor = new JTextField();
		txtNombreProvedor.setBounds(121, 72, 137, 20);
		panel_3.add(txtNombreProvedor);
		txtNombreProvedor.setColumns(10);
		
		txtTelefonoProvedor = new JTextField();
		txtTelefonoProvedor.setBounds(121, 109, 137, 20);
		panel_3.add(txtTelefonoProvedor);
		txtTelefonoProvedor.setColumns(10);
		
		txtDireccionProvedor = new JTextField();
		txtDireccionProvedor.setBounds(121, 153, 137, 20);
		panel_3.add(txtDireccionProvedor);
		txtDireccionProvedor.setColumns(10);
		
		txtRazonProvedor = new JTextField();
		txtRazonProvedor.setBounds(121, 187, 137, 20);
		panel_3.add(txtRazonProvedor);
		txtRazonProvedor.setColumns(10);
		
		JTable tableProvedor = new JTable();
		tableProvedor.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Ruc", "Nombre", "Telefono", "Direccion ", "Razon social"
			}
		));
		tableProvedor.getColumnModel().getColumn(0).setPreferredWidth(69);
		tableProvedor.getColumnModel().getColumn(1).setPreferredWidth(101);
		tableProvedor.setBounds(300, 31, 364, 61);
		panel_3.add(tableProvedor);
		
		JButton btnGuardarProvedor = new JButton("");
		btnGuardarProvedor.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\GuardarTodo.png"));
		btnGuardarProvedor.setBounds(121, 269, 89, 23);
		panel_3.add(btnGuardarProvedor);
		
		JButton btnEditarProvedor = new JButton("");
		btnEditarProvedor.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\Actualizar (2).png"));
		btnEditarProvedor.setBounds(249, 269, 89, 23);
		panel_3.add(btnEditarProvedor);
		
		JButton btnEliminarProvedor = new JButton("");
		btnEliminarProvedor.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\eliminar.png"));
		btnEliminarProvedor.setBounds(121, 318, 89, 23);
		panel_3.add(btnEliminarProvedor);
		
		JButton btnNuevoProvedor = new JButton("");
		btnNuevoProvedor.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\nuevo.png"));
		btnNuevoProvedor.setBounds(249, 318, 89, 23);
		panel_3.add(btnNuevoProvedor);
		
		txtidProveedores = new JTextField();
		txtidProveedores.setBounds(358, 153, 86, 20);
		panel_3.add(txtidProveedores);
		txtidProveedores.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		tabbedPane1.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_20 = new JLabel("Codigo ");
		lblNewLabel_20.setBounds(21, 45, 87, 14);
		panel_4.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Descripcion");
		lblNewLabel_21.setBounds(21, 82, 87, 14);
		panel_4.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Cantidad");
		lblNewLabel_22.setBounds(21, 121, 87, 14);
		panel_4.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Precio");
		lblNewLabel_23.setBounds(21, 162, 87, 14);
		panel_4.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Provedor ");
		lblNewLabel_24.setBounds(21, 202, 87, 14);
		panel_4.add(lblNewLabel_24);
		
		txtCodigoPro = new JTextField();
		txtCodigoPro.setBounds(146, 42, 129, 20);
		panel_4.add(txtCodigoPro);
		txtCodigoPro.setColumns(10);
		
		txtDesPro = new JTextField();
		txtDesPro.setBounds(146, 79, 129, 20);
		panel_4.add(txtDesPro);
		txtDesPro.setColumns(10);
		
		txtCanPro = new JTextField();
		txtCanPro.setBounds(146, 118, 129, 20);
		panel_4.add(txtCanPro);
		txtCanPro.setColumns(10);
		
		txtPrecioPro = new JTextField();
		txtPrecioPro.setBounds(146, 159, 129, 20);
		panel_4.add(txtPrecioPro);
		txtPrecioPro.setColumns(10);
		
		JComboBox cbxProvedorPro = new JComboBox();
		cbxProvedorPro.setEditable(true);
		cbxProvedorPro.setBounds(146, 198, 129, 22);
		panel_4.add(cbxProvedorPro);
		
		table_Pro = new JTable();
		table_Pro.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Codigo ", "Descripcion ", "Stock ", "Precio ", "Provedor "
			}
		));
		table_Pro.getColumnModel().getColumn(1).setPreferredWidth(101);
		table_Pro.setBounds(366, 42, 422, 20);
		panel_4.add(table_Pro);
		
		JButton btnGuardarPro = new JButton("");
		btnGuardarPro.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\GuardarTodo.png"));
		btnGuardarPro.setBounds(19, 275, 89, 23);
		panel_4.add(btnGuardarPro);
		
		JButton btnEditarPro = new JButton("");
		btnEditarPro.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\Actualizar (2).png"));
		btnEditarPro.setBounds(169, 275, 89, 23);
		panel_4.add(btnEditarPro);
		
		JButton btnEliminarPro = new JButton("");
		btnEliminarPro.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\eliminar.png"));
		btnEliminarPro.setBounds(21, 323, 89, 23);
		panel_4.add(btnEliminarPro);
		
		JButton btnNuevoPro = new JButton("");
		btnNuevoPro.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\nuevo.png"));
		btnNuevoPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevoPro.setBounds(169, 323, 89, 23);
		panel_4.add(btnNuevoPro);
		
		JButton btnExcelPro = new JButton("");
		btnExcelPro.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\excel.png"));
		btnExcelPro.setBounds(313, 323, 89, 23);
		panel_4.add(btnExcelPro);
		
		txtidPro = new JTextField();
		txtidPro.setBounds(300, 42, 26, 20);
		panel_4.add(txtidPro);
		txtidPro.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		tabbedPane1.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);
		
		table_Ventas2 = new JTable();
		table_Ventas2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Icon ", "Cliente", "Vendedor ", "Total "
			}
		));
		table_Ventas2.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_Ventas2.setBounds(24, 80, 761, 77);
		panel_5.add(table_Ventas2);
		
		JButton btnPdfVentas = new JButton("");
		btnPdfVentas.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\pdf.png"));
		btnPdfVentas.setBounds(24, 30, 89, 23);
		panel_5.add(btnPdfVentas);
		
		txtidVentas = new JTextField();
		txtidVentas.setBounds(142, 33, 86, 20);
		panel_5.add(txtidVentas);
		txtidVentas.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		tabbedPane1.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_25 = new JLabel("Ruc");
		lblNewLabel_25.setBounds(55, 104, 86, 14);
		panel_6.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Nombre");
		lblNewLabel_26.setBounds(217, 104, 86, 14);
		panel_6.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Telefono ");
		lblNewLabel_27.setBounds(403, 104, 86, 14);
		panel_6.add(lblNewLabel_27);
		
		textField_21 = new JTextField();
		textField_21.setBounds(55, 141, 107, 20);
		panel_6.add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setBounds(217, 141, 152, 20);
		panel_6.add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setBounds(403, 141, 152, 20);
		panel_6.add(textField_23);
		textField_23.setColumns(10);
		
		JLabel lblNewLabel_28 = new JLabel("Direccion ");
		lblNewLabel_28.setBounds(55, 198, 86, 14);
		panel_6.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("Razzon social ");
		lblNewLabel_29.setBounds(217, 198, 86, 14);
		panel_6.add(lblNewLabel_29);
		
		textField_24 = new JTextField();
		textField_24.setBounds(55, 232, 123, 20);
		panel_6.add(textField_24);
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setBounds(217, 232, 199, 20);
		panel_6.add(textField_25);
		textField_25.setColumns(10);
		
		JButton btnNewButton_22 = new JButton("ACTUALIZAR ");
		btnNewButton_22.setBounds(217, 314, 191, 23);
		panel_6.add(btnNewButton_22);
		
		JLabel lblNewLabel_30 = new JLabel("DATOS DE LA EMPRESA");
		lblNewLabel_30.setBounds(250, 24, 161, 30);
		panel_6.add(lblNewLabel_30);
		
	      
	}


public void ListarCliente() {
	List<Cliente> ListarCl = client.ListarCliente();
    modelo = (DefaultTableModel) TableCliente.getModel();
    Object[] ob = new Object [6];
    for (int i = 0; i < ListarCl.size(); i++ ) {
        ob[0] = ListarCl.get(i).getId(); 
        ob[1] = ListarCl.get(i).getDni(); 
        ob[2] = ListarCl.get(i).getNombre(); 
        ob[3] = ListarCl.get(i).getTelefono(); 
        ob[4] = ListarCl.get(i).getDireccion(); 
        ob[5] = ListarCl.get(i).getRazon(); 
        modelo.addRow(ob);
    }

    
   TableCliente.setModel(modelo);
   
}


	public void LimpiarTable() {
	    DefaultTableModel modelo = (DefaultTableModel) TableCliente.getModel();
	    modelo.setRowCount(0);
	}

	  public void LimpiarCliente() {
	        txtidCliente.setText("");
	        txtDniCliente.setText("");
	        txtNombreCliente.setText("");
	        txtTelefonoCliente.setText("");
	        txtDireccionCliente.setText("");
	        txtRazonCliente.setText("");
	    }


}
