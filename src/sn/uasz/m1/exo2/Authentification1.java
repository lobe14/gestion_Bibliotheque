package sn.uasz.m1.exo2;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

	public class Authentification1 extends JFrame implements ActionListener{
	 
	 Container cont= getContentPane();
	 JLabel nomUtilisateur=new JLabel("Nom Utilisateur");
	 JTextField    textUser=new JTextField("login");
	 JLabel textPassword = new JLabel("Mot de passe");
	 JPasswordField    textPass=new JPasswordField("Votre mot de passe");
	 JButton connecter=new JButton("Se connecter"); 
	 JButton annuler=new JButton("Annuler"); 
	 JButton quiter=new JButton("Quiter"); 
	 
	 

	//Variable d'acces à la  base de donnéés
	private static String url="jdbc:mysql://localhost:3306/club?serverTimezone=UTC";
	private static String user ="root";
	private static String mdp="";
		

	private static final long serialVersionUID = 1294463942305263250L;
	public Authentification1() {
		this.setTitle("Authentification");
		this.setVisible(true);
		this.setSize(500,230);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getBackground();
		this.setLocationRelativeTo(null);

		addComponentsToContainer();
		setLocationAndSize();
		setLayoutManager();
		
	}
	//fin constructeur
	private void setLayoutManager() {
		cont.setLayout(null);
		
	}
	private void setLocationAndSize() {
	 nomUtilisateur.setBounds(110,30, 100,30);
	 textUser.setBounds(210, 30, 130,30);
	 textPassword.setBounds(110, 75, 100,30);
	 textPass.setBounds(210, 80, 130,30);
	 connecter.setBounds(210, 140, 120,30);
		
	}
	private void addComponentsToContainer() {
		cont.add(nomUtilisateur);
		cont.add(textUser);
		cont.add(textPassword);
		cont.add(textPass);
		getBackground();
		cont.add(connecter).setBackground(Color.green);
		
		connecter.addActionListener( (ActionListener) new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String login= textUser.getText();
		   	String pass=textPass.getText();
			try{Class.forName("com.mysql.cj.jdbc.Driver");
			   Connection con = DriverManager.getConnection(url,user,mdp);
			    String req="SELECT `username`, `password` FROM `users` WHERE username=? and password=?";
			    PreparedStatement pst= con.prepareStatement(req);
			   pst.setString(1, textUser.getText());
			    pst.setString(2, textPass.getText());
			    ResultSet rs= pst.executeQuery();
			    if(rs.next()) {
			    		JOptionPane.showMessageDialog(null, "Connecté");	
			    		dispose();
						Acceul ac=new Acceul();
		    		
			    }
			    else
			    	JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe éronnés");
			}catch(Exception e1 ){
				e1.printStackTrace(); 
			}
			
		}	
	});
	}
	public static void main(String[]args) {
		Authentification1 conn=new Authentification1();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	}
