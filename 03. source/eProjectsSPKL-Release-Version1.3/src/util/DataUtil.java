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
		String server = new String();
		try {
			FileReader fr= new FileReader("input/server.ser");
            BufferedReader input= new BufferedReader(fr);
            if(!fr.ready()){
            	model.setDataname(null);
            	model.setHostname(null);
            	model.setPassword(null);
            	model.setUsername(null);
            }else{
            	server = ServerUtil.deencryptionStr(input.readLine());//StringUtil.decriptString(input.readLine());
				try {
					if(server!=null && !server.equals("")){
						String[] array = server.split(",");
						String host = array[0].substring(0, array[0].length()-13);;
						model.setHostname(host);
						String data = array[1].substring(0, array[1].length()-15);
						model.setDataname(data);
						String user = array[2].substring(0, array[2].length()-15);
						model.setUsername(user);
						String pass = array[3].substring(0, array[3].length()-9);
						model.setPassword(pass);
					}
				}catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
            }
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Not found file server! Please configure server!");
		}

		return model;
	}
	public static boolean connect() {
		boolean result = false;
		ServerModel serverModel = new ServerModel();
		serverModel = getServer();
		if(serverModel.getDataname()!=null || serverModel.getHostname()!=null || serverModel.getUsername()!=null || serverModel.getPassword()!=null){
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

	public static boolean closeConnection() {
		boolean result = false;
		try {
			conn.close();
			result = true;
		} catch (SQLException e) {
			result = false;
		}	
		return result;
	}
	
	public static ResultSet executeQuery(String sql) {
		try {
			connect();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			return rs;
		} catch (Exception e) {
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
			e.printStackTrace();
			return false;
		}
	}
}
