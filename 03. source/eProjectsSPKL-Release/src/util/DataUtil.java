package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.ServerModel;

public class DataUtil {
	public static Connection conn;
	public static String DATA;
	public static String USRE_NAME;
	public static String PASSWORD;

	public static ServerModel getServer() {
		ServerModel model = new ServerModel();
		String server = null;
		try {
			FileReader fr= new FileReader("src/config/server.txt");
            BufferedReader input= new BufferedReader(fr); 
            server = StringUtil.decriptString(input.readLine());
			try {
				if(server!=null && !server.equals("")){
					String[] array = server.split(",");
					model.setHostname(array[0]);
					model.setDataname(array[1]);
					model.setUsername(array[2]);
					model.setPassword(array[3]);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Not found file server.txt! Please configure server!");
		}

		return model;
	}
	public static boolean connect() {
		boolean result = false;
		ServerModel serverModel = new ServerModel();
		serverModel = getServer();
		if(serverModel.getDataname()!=null){
			String data = "jdbc:sqlserver://"+serverModel.getHostname()+";DATABASENAME= "+serverModel.getDataname();
			String user = serverModel.getUsername();
			String pass = serverModel.getPassword();
			DataUtil.DATA = data;
			DataUtil.USRE_NAME = user;
			DataUtil.PASSWORD = pass;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(DATA, USRE_NAME, PASSWORD);
				result = true;
			} catch (Exception e) {
				result = false;
			}
		}else{
			result = false;
		}
		return result;
	}
	public static Connection getConnection() {
		if(conn==null){
			connect();
		}
		return conn;
	}

	public static void closeConnection() {
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error!");
			}
		}
	}
	
	public static ResultSet executeQuery(String sql) {
		try {
			connect();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public static boolean executeNonQuery(String sql) {
		try {
			connect();
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Update failt! Try again!"+e.getMessage());
			return false;
		}
	}
}
