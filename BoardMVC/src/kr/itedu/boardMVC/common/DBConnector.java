package kr.itedu.boardMVC.common;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBConnector {
	
	public static Connection getConn() throws SQLException{
		DataSource ds = null;
		try {
			Context initContext = new InitialContext();
	    	Context envContext = (Context)initContext.lookup("java:/comp/env");
	    	ds = (DataSource)envContext.lookup("OracleDB");
		} catch (NamingException e) {
			// TODO: 예외처리
		} catch (Exception e) {
			// TODO: 예외처리
		}
		return ds.getConnection();
	}
	
	public static void close(Connection c, PreparedStatement p, ResultSet re) {
		if(re != null) {try {re.close();} catch (Exception e) {e.printStackTrace();}}
		if(p != null) {try {p.close();} catch (Exception e) {e.printStackTrace();}}
		if(c != null) {try {c.close();} catch (Exception e) {e.printStackTrace();}}
	}
	public static void close(Connection c) {close(c,null,null);}
	public static void close(PreparedStatement p) {close(null, p, null);}
	public static void close(ResultSet re) {close(null, null, re);}
	public static void close(PreparedStatement p ,ResultSet re) {close(null, p, re);}
}
