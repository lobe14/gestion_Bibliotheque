package examen.s1m1.uasz.sn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
	private static String url="jdbc:mysql://localhost:3306/bu?serverTimezone=UTC";
	private static String user0 ="root";
	private static String mdp0="";
	private static Connection conn=null;
	ConnectionBD(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url,user0,mdp0);
		}catch(Exception e ){
			e.printStackTrace();
		}
		}
	public static Connection getConnection(){
			if(conn==null){
				new ConnectionBD();
				}
			return conn;
			}

public static void closeConnection(){
	if(conn!=null){
	try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
			}
		}
}


}