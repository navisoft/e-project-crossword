package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DataUtil;

public class ConnectDatabaseDao {
	//Check exists database
	public static boolean checkExistsDatabases(String data) {
		boolean result = false;
		String sql = "SELECT * FROM MASTER..SYSDATABASES WHERE NAME = ?";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, data);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				result = true;
			}
		} catch (SQLException e) {
			result = false;
		}
		return result;
	}
	//Create database
	public static boolean createDatabase(String data) {
		boolean resultCreateData = false;
		String sql = "CREATE DATABASE "+data;
		resultCreateData = DataUtil.executeNonQuery(sql);
		return resultCreateData;  
	}
	//Create puzzle table
	public static boolean createTablePzzule(String data) {
		boolean resultCreateData = false;
		String sql ="USE "+data+ 
		" CREATE TABLE PUZZLE " +
		"(" +
		"PUZZLEID INTEGER IDENTITY(1,1)," +
		"PUZZLENAME NVARCHAR(30) NOT NULL " +
		"PRIMARY KEY (PUZZLEID))";
		resultCreateData = DataUtil.executeNonQuery(sql);
		return resultCreateData;
	}
	//Create highscores table
	public static boolean createTableHighScore(String data) {
		boolean resultCreateData = false;
		String sql ="USE "+data+ 
		" CREATE TABLE HIGHSCORES " +
		"(" +
		"HIGHSCOREID INTEGER IDENTITY(1,1)," +
		"TYPE INT NULL," +
		"PLAYERNAME NVARCHAR(40) NULL," +
		"SCORES FLOAT NULL, " +
		"TIMES NVARCHAR(5) NULL " +
		"PRIMARY KEY (HIGHSCOREID))";
		resultCreateData = DataUtil.executeNonQuery(sql);
		return resultCreateData;
	}
	//Create user table
	public static boolean createTableUsers(String data) {
		boolean resultCreateData = false;
		String sql ="USE "+data+ 
		" CREATE TABLE USERS " +
		"(" +
		"USERID INTEGER IDENTITY(1,1)," +
		"USERNAME NVARCHAR(40) NOT NULL," +
		"PASSWORD NVARCHAR(40) NOT NULL " +
		"PRIMARY KEY (USERID))";
		resultCreateData = DataUtil.executeNonQuery(sql);
		return resultCreateData;
	}
	//Create question table
	public static boolean createTableQuestions(String data) {
		boolean resultCreateData = false;
		String sql ="USE "+data+ 
		" CREATE TABLE QUESTIONS " +
		"(" +
		"QUESTIONID INTEGER IDENTITY(1,1)," +
		"DETAIL NVARCHAR(500) NULL," +
		"PRIMARY KEY (QUESTIONID))";
		resultCreateData = DataUtil.executeNonQuery(sql);
		return resultCreateData;
	}
	//Create answer4x4 table
	public static boolean createTableAnswer4x4(String data) {
		boolean resultCreateData = false;
		String sql ="USE "+data+ 
		" CREATE TABLE ANSWER4X4 " +
		"(" +
		"ANSWER4X4ID INT IDENTITY(1,1)," +
		"PUZZLEID INTEGER NOT NULL," +
		"QUESTIONID INTEGER NOT NULL," +
		"VALUE1 VARCHAR(1) NOT NULL," +
		"VALUE2 VARCHAR(1) NOT NULL," +
		"VALUE3 VARCHAR(1) NOT NULL," +
		"VALUE4 VARCHAR(1) NOT NULL " +
		"PRIMARY KEY (ANSWER4X4ID))";
		resultCreateData = DataUtil.executeNonQuery(sql);
		return resultCreateData;
	}
	//Create answer6x6 table
	public static boolean createTableAnswer6x6(String data) {
		boolean resultCreateData = false;
		String sql ="USE "+data+ 
		" CREATE TABLE ANSWER6X6 " +
		"(" +
		"ANSWER6X6ID INT IDENTITY(1,1)," +
		"PUZZLEID INTEGER NOT NULL," +
		"QUESTIONID INTEGER NOT NULL," +
		"VALUE1 VARCHAR(1) NOT NULL," +
		"VALUE2 VARCHAR(1) NOT NULL," +
		"VALUE3 VARCHAR(1) NOT NULL," +
		"VALUE4 VARCHAR(1) NOT NULL, " +
		"VALUE5 VARCHAR(1) NOT NULL," +
		"VALUE6 VARCHAR(1) NOT NULL " +
		"PRIMARY KEY (ANSWER6X6ID))";
		resultCreateData = DataUtil.executeNonQuery(sql);
		return resultCreateData;
	}
	//Drop database
	public static boolean dropDatabase(String data) {
		boolean resultCreateData = false;
		String sql ="USE MASTER " + 
		"DROP DATABASE "+data;
		resultCreateData = DataUtil.executeNonQuery(sql);
		return resultCreateData;
	}
	//Insert data for table
	public static boolean createInsertData(String data) {
		boolean resultCreateData = false;
		String sql ="USE " + data+
		" INSERT INTO PUZZLE VALUES('puzzle1')" +
		" INSERT INTO PUZZLE VALUES('puzzle2')" +
		"" +
		" INSERT INTO QUESTIONS VALUES('To speak?')" +
		" INSERT INTO QUESTIONS VALUES(null)" +
		" INSERT INTO QUESTIONS VALUES('The number of planets in the universe?')" +
		" INSERT INTO QUESTIONS VALUES(null)" +
		" INSERT INTO QUESTIONS VALUES('A shade of a colour, especially a pale or delicate variation?')" +
		" INSERT INTO QUESTIONS VALUES(null)" +
		" INSERT INTO QUESTIONS VALUES('The abbreviation of Local Area Network?')" +
		" INSERT INTO QUESTIONS VALUES('The joint, that joins the thigh with the leg?')" +
		"" +
		" INSERT INTO ANSWER4X4 VALUES(1,1,'t','a','l','k')" +
		" INSERT INTO ANSWER4X4 VALUES(1,2,'i','*','a','n')" +
		" INSERT INTO ANSWER4X4 VALUES(1,3,'n','i','n','e')" +
		" INSERT INTO ANSWER4X4 VALUES(1,4,'t','*','*','e')" +
		" INSERT INTO ANSWER4X4 VALUES(1,5,'t','i','n','t')" +
		" INSERT INTO ANSWER4X4 VALUES(1,6,'a','*','i','*')" +
		" INSERT INTO ANSWER4X4 VALUES(1,7,'l','a','n','*')" +
		" INSERT INTO ANSWER4X4 VALUES(1,8,'k','n','e','e')" +
		"" +
		" INSERT INTO HIGHSCORES VALUES(4,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(4,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(4,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(4,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(4,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(4,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(4,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(4,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(4,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(4,null,null,null)" +
		"" +
		" INSERT INTO HIGHSCORES VALUES(6,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(6,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(6,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(6,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(6,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(6,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(6,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(6,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(6,null,null,null)" +
		" INSERT INTO HIGHSCORES VALUES(6,null,null,null)" +
		"" +
		" INSERT INTO QUESTIONS VALUES('aaaaaa?')" +
		" INSERT INTO QUESTIONS VALUES(null)" +
		" INSERT INTO QUESTIONS VALUES('aaaaaa?')" +
		" INSERT INTO QUESTIONS VALUES(null)" +
		" INSERT INTO QUESTIONS VALUES('aaaaaa?')" +
		" INSERT INTO QUESTIONS VALUES(null)" +
		" INSERT INTO QUESTIONS VALUES('aaaaaa?')" +
		" INSERT INTO QUESTIONS VALUES(null)" +
		" INSERT INTO QUESTIONS VALUES('aaaaaa?')" +
		" INSERT INTO QUESTIONS VALUES(null)" +
		" INSERT INTO QUESTIONS VALUES('aaa?')" +
		" INSERT INTO QUESTIONS VALUES('aaaaaa?')" +
		"" +
		" INSERT INTO ANSWER6X6 VALUES(2,9,'a','a','a','a','a','a')" +
		" INSERT INTO ANSWER6X6 VALUES(2,10,'a','*','a','*','a','a')" +
		" INSERT INTO ANSWER6X6 VALUES(2,11,'a','a','a','a','a','a')" +
		" INSERT INTO ANSWER6X6 VALUES(2,12,'a','*','a','*','*','a')" +
		" INSERT INTO ANSWER6X6 VALUES(2,13,'a','a','a','a','a','a')" +
		" INSERT INTO ANSWER6X6 VALUES(2,14,'a','*','a','*','*','a')" +
		" INSERT INTO ANSWER6X6 VALUES(2,15,'a','a','a','a','a','a')" +
		" INSERT INTO ANSWER6X6 VALUES(2,16,'a','*','a','*','a','*')" +
		" INSERT INTO ANSWER6X6 VALUES(2,17,'a','a','a','a','a','a')" +
		" INSERT INTO ANSWER6X6 VALUES(2,18,'a','*','a','*','a','*')" +
		" INSERT INTO ANSWER6X6 VALUES(2,19,'a','a','a','*','a','*')" +
		" INSERT INTO ANSWER6X6 VALUES(2,20,'a','a','a','a','a','a')" +
		"";
		resultCreateData = DataUtil.executeNonQuery(sql);
		return resultCreateData;
	}
	
	
}














