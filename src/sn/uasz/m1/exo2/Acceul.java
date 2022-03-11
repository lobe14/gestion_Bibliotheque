package sn.uasz.m1.exo2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Acceul extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Container cont1=getContentPane();
	
	
	JButton insc=new JButton("Inscription");
	JButton affi=new JButton("Affichage");
	JButton deco=new JButton("Deconnecter");
	JLabel texte=new JLabel("Bienvenueà la page d'acceuil de l'application de gestion du club de l'uasz.");
	
public  Acceul() {
	super("Acceul");
	this.setVisible(true);
	this.setSize(800,500);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.getBackground();
	this.setLocationRelativeTo(null);
	addComponentsToContainer();
	setLocationAndSize();
	setLayoutManager();
	
}

private void setLayoutManager() {
	  cont1.setLayout(null);
	
}

private void setLocationAndSize() {
	cont1.setBounds(400,20,110,20);
	deco.setBounds(630,40,110,30);
	texte.setBounds(80,30,700,300);
	insc.setBounds(350,400,110,30);
	affi.setBounds(230,400,110,30);
}

private void addComponentsToContainer() {
	cont1.add(deco);
	cont1.add(texte);	
	cont1.add(insc);
	cont1.add(affi);
	//cont1.update((Graphics) getIconImages());
  
	// Action sur le le menuItem Inscription
	insc.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			dispose();
			Inscription ins=new Inscription();

		}
		
	});
	
	// Action sur  le bouton

		affi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				try {
					dispose();
				   Affichage aff = new Affichage();
		     	} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		deco.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource().equals(deco)) {
					Authentification1 aut=new Authentification1();
					dispose();
				}
			}
			
		});
			
		
}

//Action sur  le bouton deconnecter
@Override
public void actionPerformed(ActionEvent e) {
	
}
}
