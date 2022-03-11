/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_java_swing_jdbc;

import java.sql.DriverManager;

/**
 *
 * @author Mamadou
 */
public class ConnectionBase {
     public static java.sql.Connection con=null;
    public static java.sql.Connection getCo(){
    try{
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    String url="jdbc:mysql://localhost/club?user=root";
    if(con==null){
    con=DriverManager.getConnection(url);
    }}
    catch(Exception e){}
    return con;
    }
}
