package sn.uasz.m1.exo2;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.jar.JarOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Affichage extends JFrame implements ActionListener {
	private static final long serialVersionUID = 6844622488069978874L;
	Container cont3 = getContentPane();

	private JTable table = new JTable();
	private JLabel titre = new JLabel(" Liste des membres du club sportif de l'UASZ. ");
	private JButton mod = new JButton("Modifier");
	private JButton sup = new JButton("Supprimer");
	private JButton ret = new JButton("Retour");
	private JScrollPane js = new JScrollPane();;
	 static DefaultTableModel model = new DefaultTableModel(); //static
	 static int n;
	// Variable d'acces à la base de donnéés
	private static String url = "jdbc:mysql://localhost:3306/club?serverTimezone=UTC";
	private static String user = "root";
	private static String mdp = "";
	private static Connection connexion = null;

	public Affichage() throws SQLException {
		this.setSize(790, 490);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Affichage");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(getBackground());

		addComponentToContainer();
		addLocationAndSize();
		setLayoutManager();

		// Acces à la base de donnees

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection(url, user, mdp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Tableau
		table.setBackground(Color.WHITE);
		Object[] colonne = { "Identifiant", "Prenom", "Nom", "Sexe", "Profession", "Date d'adhesion", "Email" };
		Object[] ligne = new Object[6];
		model.setColumnIdentifiers(colonne);		
		js.setViewportView(table);
		table.setModel(model);

		// Récuperer et afficher les données dans
		String req = "SELECT * FROM membre";
		Statement st = connexion.createStatement();
		ResultSet rs = st.executeQuery(req);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getInt("Identifiant"), rs.getString("Prenom"), rs.getString("Nom"),
					rs.getString("Sexe"), rs.getString("Profession"), rs.getString("DateAdhesion"),
					rs.getString("Email")

			});

		}

		mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n = table.getSelectedRow();
				Modification modif = new Modification();

			}
		});

		

		sup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sup = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le membre  ?",
						"Confirmation de suppression", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (sup == 0) {
					try {

						n = table.getSelectedRow();
						int Identifiant = (int) model.getValueAt(n, 0);
						Class.forName("com.mysql.cj.jdbc.Driver");
						connexion = DriverManager.getConnection(url, user, mdp);
						Statement st = connexion.createStatement();
						st.executeUpdate("DELETE FROM `membre` WHERE Identifiant='" + Identifiant + "'");
						JOptionPane.showMessageDialog(null, "Membre supprimé avec succés");
						model.removeRow(n);

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Echec de la suppression du membre");
						ex.printStackTrace();
					}
				}

			}

		});
		
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceul ac = new Acceul();
				dispose();

			}
		});

	}

private Object[] addRow(String cle) {
		// TODO Auto-generated method stub
		return null;
	}

	private void addComponentToContainer() {
		cont3.add(js);
		// js.add(table).setBackground(Color.WHITE);
		cont3.add(sup).setBackground(Color.RED);
		cont3.add(mod).setBackground(Color.BLUE);
		cont3.add(ret).setBackground(Color.GREEN);
		cont3.add(titre);

	}

	private void setLayoutManager() {
		setLayout(null);

	}

	private void addLocationAndSize() {
		js.setBounds(0, 40, 775, 350);
		table.setBounds(0, 100, 900, 700);
		sup.setBounds(350, 400, 110, 30);
		ret.setBounds(200, 400, 110, 30);
		mod.setBounds(480, 400, 110, 30);
		titre.setBounds(200, 10, 400, 35);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	

}
