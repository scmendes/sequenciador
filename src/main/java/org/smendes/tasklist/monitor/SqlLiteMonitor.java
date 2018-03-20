package org.smendes.tasklist.monitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlLiteMonitor {

	
	private static final String SQL_LITE_DB_FOLDER = "C:\\scmendes\\SOFTWARE EXPRESS SEQUENCIADOR\\parametros\\inicializacao\\sequenciador.db";
	
	private Connection connection = null;
	
	public SqlLiteMonitor() {
		super();
	}

	public static void main(String[] args) {
		SqlLiteMonitor sqlLiteMonitor = new SqlLiteMonitor();
		sqlLiteMonitor.execute("");
	}

	private void connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + SQL_LITE_DB_FOLDER);
			connection.setAutoCommit(false);
			System.out.println("Opened database successfully");	
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	public void execute(final String sql) {

		   Statement stmt = null;
		   try {
			  connect();

		      stmt = connection.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT NSA FROM TAB_LOTE;" );
		      
		      while ( rs.next() ) {
		         int nsa = rs.getInt("NSA");
		         System.out.println( "NSA = " + nsa );
		      }
		      rs.close();
		      stmt.close();
		      connection.close();
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   System.out.println("Operation done successfully");		
	}
	
}
