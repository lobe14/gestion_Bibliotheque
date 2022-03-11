package sn.uasz.m1.exo2;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Modification extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Container cont2=getContentPane();
	JLabel msg=new JLabel("Formuaire d'inscription des membres du club");
	String[] prof= {"Comptabe","Etudiant","Developpeur","Infirmier","Ensiégnant"};
	JLabel id=new JLabel("Identifient");
	JTextField textId=new JTextField();
	JLabel prenom=new JLabel("Prénom");
	JTextField textPrenom=new JTextField((String) Affichage.model.getValueAt(Affichage.n,1));
	JLabel nom=new JLabel("Nom");
	JTextField textNom=new JTextField((String) Affichage.model.getValueAt(Affichage.n,2));
	JLabel sexe=new JLabel("Sexe");
	JRadioButton textSexeH=new JRadioButton("Homme");
	JRadioButton textSexeF=new JRadioButton("Femme");
	JLabel profil=new JLabel("Profession");
	JComboBox<String> textProfil=new JComboBox<String>(prof); 
	JLabel Date=new JLabel("Date d'adhesion");
	JTextField textDate=new JTextField((String) Affichage.model.getValueAt(Affichage.n,5));
	JLabel mail=new JLabel("Email");
	JFormattedTextField textMail=new JFormattedTextField((String) Affichage.model.getValueAt(Affichage.n,6));
	ButtonGroup bg=new ButtonGroup();
	JButton valid=new JButton("Valider");
	
	JTable table=new JTable();
	JScrollPane js=new JScrollPane();
	DefaultTableModel model=new DefaultTableModel();
	
	private static String url="jdbc:mysql://localhost:3306/club?serverTimezone=UTC";
	private static String user ="root";
	private static String mdp="";
	private static Connection connexion=null;
	
	private String genre=(String) Affichage.model.getValueAt(Affichage.n,3);
	
public Modification() {
	super("ModificationMbre");
	this.setVisible(true);
	this.setBounds(5,5,400,480);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setLocationRelativeTo(null);
	addComponentsToContainer();
	setLocationAndSize();
	setLayoutManager();
	
	
	try{Class.forName("com.mysql.cj.jdbc.Driver");
	connexion=DriverManager.getConnection(url,user,mdp);
	}catch(Exception e ){
		e.printStackTrace();
	}
}

private void setLayoutManager() {
	cont2.setLayout(null);
	
}

private void setLocationAndSize() {
	msg.setBounds(85,50,300,30);
	prenom.setBounds(75,100,100,30);
	textPrenom.setBounds(170, 100,150,25);
	nom.setBounds(75,140,120,30);
	textNom.setBounds(170, 140,150,25);
	sexe.setBounds(75,190,100,30);
	textSexeH.setBounds(170, 190,100,25);
	textSexeF.setBounds(270,190,100,25);
	
	
	profil.setBounds(75,260,100,30);
	
	textProfil.setBounds(170, 260,150,20);
	textProfil.setSelectedItem((String) Affichage.model.getValueAt(Affichage.n,4));
	Date.setBounds(75,300,100,30);
	textDate.setBounds(170, 300,150,25);
	
	mail.setBounds(75,340,100,30);
	textMail.setBounds(170, 340,150,25);
	
	valid.setBounds(200,400,100,30);
		
}

private void addComponentsToContainer() {
	if(genre.equals("Homme")) {
		textSexeH=new JRadioButton("Homme",true);
	}else
		textSexeF=new JRadioButton("Femme",true);
	cont2.add(msg);
	cont2.add(id);
	cont2.add(textId);
	cont2.add(prenom);
	cont2.add(textPrenom);
	cont2.add(nom);
	cont2.add(textNom);
	cont2.add(sexe);
	cont2.add(textSexeH);
	cont2.add(textSexeF);
	cont2.add(profil);
	cont2.add(textProfil);
	cont2.add(Date);
	cont2.add(textDate);
	cont2.add(mail);
	cont2.add(textMail);
	cont2.add(valid);
	bg.add(textSexeH);
	bg.add(textSexeF);
	
	valid.addActionListener( new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String prenom=textPrenom.getText();
		String nom=textNom.getText();
		String Sexe;
		if(textSexeH.isSelected()) {
			Sexe="Homme";
		}else
			Sexe="Femme";
		String profil=(String) textProfil.getSelectedItem();
		String dateA=textDate.getText();
		String email=textMail.getText();
		int cle=(int) Affichage.model.getValueAt(Affichage.n, 0);
		try {
		 Statement st=connexion.createStatement();
	     st.executeUpdate("UPDATE `membre` SET   Prenom='"+prenom+"',Nom='"+nom+"',Sexe='"+Sexe+"',Profession='"+profil+"',DateAdhesion='"+dateA+"',Email='"+email+"' WHERE Identifiant='"+cle+"' ");
	     JOptionPane.showMessageDialog(null,"Membre Modifié avec succés");
	    
	     dispose();
	     new Affichage().setVisible(true);
	     //Acceul ac=new Acceul();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
				
}

	
});
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

/*public void actu() {
	try{Class.forName("com.mysql.cj.jdbc.Driver");
	connexion=DriverManager.getConnection(url,user,mdp);
	
	//Tableau 
	   table.setBackground(Color.WHITE);
	   Object[] colonne= {"Identifiant","Prenom","Nom","Sexe","Profession","Date d'adhesion","Email"}; 
	   Object[] ligne= new Object[7];
	   model.setColumnIdentifiers(colonne);
	   table.setModel(model);
	   js.setViewportView(table);
	   
	   
	   //Récuperer et afficher les données dans 
	   String req="SELECT * FROM membre";
	   Statement st=connexion.createStatement();
	   ResultSet rs=st.executeQuery(req);
	   while(rs.next()) {
		 model.addRow(  new Object[] {
				 rs.getInt("Identifiant"),
				 rs.getString("Prenom"),
				 rs.getString("Nom"),
				 rs.getString("Sexe"),
				 rs.getString("Profession"),
				 rs.getString("DateAdhesion"),
				 rs.getString("Email")
				 
		 });
		 
	   }
	
	}catch(Exception e ){
		e.printStackTrace();
	}

	
}
*/

}