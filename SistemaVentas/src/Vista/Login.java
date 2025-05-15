package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.LoginDAO;
import Model.login;

import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	login lg = new login();
    LoginDAO login = new LoginDAO();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCorr;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel txtCorreo = new JPanel();
		txtCorreo.setBackground(UIManager.getColor("CheckBox.highlight"));
		txtCorreo.setBounds(228, 0, 232, 431);
		contentPane.add(txtCorreo);
		txtCorreo.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\iniciar.png"));
		lblNewLabel_1.setBounds(71, 36, 107, 78);
		txtCorreo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Correo electronico ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_2.setBounds(10, 124, 178, 14);
		txtCorreo.add(lblNewLabel_2);
		
		txtCorr = new JTextField();
		txtCorr.setBounds(10, 150, 212, 20);
		txtCorreo.add(txtCorr);
		txtCorr.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Passaword\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_3.setBounds(10, 191, 153, 14);
		txtCorreo.add(lblNewLabel_3);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(10, 216, 212, 20);
		txtCorreo.add(txtPass);
		
		JButton btnNewButton = new JButton("Iniciar ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setBounds(10, 261, 89, 23);
		txtCorreo.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(10, 295, 212, 39);
		txtCorreo.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Siguenos en ");
		lblNewLabel_4.setBounds(10, 0, 161, 40);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\facebook.png"));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 192, 203));
		panel_3.setBounds(10, 345, 212, 39);
		txtCorreo.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Siguenos en ");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\instagram.png"));
		lblNewLabel_5.setBounds(10, 0, 177, 33);
		panel_3.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 276, 442);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("REGALOS CORPORATIVOS");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(24, 162, 194, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Y PROMOCIONALES");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(54, 182, 149, 14);
		panel_1.add(lblNewLabel_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(262, 0, 322, 442);
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\SistemaVentas\\src\\Img\\login.jpg"));
		panel_2.add(lblNewLabel);
		
		this.setLocationRelativeTo(null);
		
	}

	public void validar() {
	    String correo = txtCorr.getText();
	    String pass = String.valueOf(txtPass.getPassword());

	    if (!"".equals(correo) && !"".equals(pass)) {
	        // Aquí creas una nueva instancia de Login llamada lg
	        login lg = new login();  
	        LoginDAO login = new LoginDAO();
	        // Aquí asignas los valores de la base de datos a la instancia recién creada, no a la lg que declaraste arriba
	        lg = login.log(correo, pass);

	        if (lg != null && lg.getCorreo() != null && lg.getPass() != null) {
	            Sistema sis = new Sistema(); 
	            sis.setVisible(true);
	            dispose();
	        } else {
	            JOptionPane.showMessageDialog(null, "error en la contrasena o correo");
	        }
	    }
	}

	
}	

