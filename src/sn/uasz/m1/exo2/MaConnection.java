package sn.uasz.m1.exo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnection {
	private static String url="jdbc:mysql://localhost:3306/club?serverTimezone=UTC";
	private static String user ="root";
	private static String mdp="";
	private static Connection connexion=null;
	MaConnection(){
		try{Class.forName("com.mysql.cj.jdbc.Driver");
		connexion=DriverManager.getConnection(url,user,mdp);
		}catch(Exception e ){
			e.printStackTrace();
		}
		}
	public static Connection getConnection(){
			if(connexion==null){
				new MaConnection();
				}
			return connexion;
			}

//public static void closeConnection(){
//	if(connexion!=null){
//		try{
//			connexion.close();
//		}catch(SQLException e){
//			e.printStackTrace();
//			}
//		}
//}


}