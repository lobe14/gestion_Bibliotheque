package examen.s1m1.uasz.sn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Authentification extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JFrame frame;
	private JPasswordField textpassword;
	private JTextField textuser;
	private JButton btnConnecter;
	//Variable d'acces à la  base de donnéés
	private static String url="jdbc:mysql://localhost:3306/bu?serverTimezone=UTC";
	private static String user0 ="root";
	private static String mdp0="";
	/**
	 * Create the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification auth = new Authentification();
					auth.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Authentification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(55, 51, 153));
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frame.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.setBounds(600, 200, 474, 262);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Veillez saisir votre nom d'utilisateur et votre mot de passe");
		lblNewLabel.setBounds(0, 0, 434, 39);
		lblNewLabel.setBackground(new Color(0, 153, 102));
		lblNewLabel.setForeground(new Color(0, 51, 0));
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Authentification window=new Authentification();
				window.dispose();
			}
		});
		btnAnnuler.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAnnuler.setBounds(323, 174, 91, 23);
		btnAnnuler.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(btnAnnuler);
		
		btnConnecter = new JButton("Se connecter");
		btnConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login= textuser.getText();
			   	String pass=textpassword.getText();
				try{Class.forName("com.mysql.cj.jdbc.Driver");
				   Connection con = DriverManager.getConnection(url,user0,mdp0);
				    String req="SELECT `login`, `password` FROM `users` WHERE login=? and password=?";
				    PreparedStatement pst= con.prepareStatement(req);
				   pst.setString(1, textuser.getText());
				    pst.setString(2, textpassword.getText());
				    ResultSet rs= pst.executeQuery();
				    if(rs.next()) {
				    		JOptionPane.showMessageDialog(null, "Connecté");	
				    		dispose();
				    		
				    		Menu menu =new Menu();
				    		menu.setVisible(true);
				    		
				    }
				    else if(textuser.getText()==""||textpassword.getText()=="") {
				    	JOptionPane.showMessageDialog(null, "Veillez remplir tous les champs");
				    }
				    else
				    	JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe éronnés");
				}catch(Exception e1 ){
					e1.printStackTrace(); 
				}
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnConnecter.setHorizontalAlignment(SwingConstants.LEFT);
		btnConnecter.setBounds(200, 174, 113, 23);
		btnConnecter.setForeground(Color.DARK_GRAY);
		btnConnecter.setBackground(new Color(0, 204, 51));
		btnConnecter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(btnConnecter);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 50, 164, 178);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Mamadou SOW\\Desktop\\TP Java\\Projet PA\\images\\ic8Log.JPG"));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nom d'utilisateur");
		lblNewLabel_2.setBounds(174, 68, 125, 23);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mot de passe");
		lblNewLabel_2_1.setBounds(174, 115, 125, 30);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_2_1);
		
		textpassword = new JPasswordField();
		textpassword.setBounds(311, 115, 123, 25);
		textpassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frame.getContentPane().add(textpassword);
		
		textuser = new JTextField();
		textuser.setBounds(311, 68, 123, 23);
		textuser.setToolTipText("");
		textuser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frame.getContentPane().add(textuser);
		textuser.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
