package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import model.Answer4x4Model;
import model.Answer6x6Model;
import model.HighScoresModel;
import model.PlayerModel;
import model.PuzzleModel;

import util.DataUtil;

public class GameDao {
	public static boolean checkExistsData(String status) {
		boolean result = false;
		if(status.equals("")){
			String sql = "SELECT * FROM PUZZLE";
			ResultSet set = DataUtil.executeQuery(sql);
			try {
				while(set.next()){
					result = true;
				}
			} catch (SQLException e) {
				result = false;
			}
		}
		if(status.equals("4")){
			String sql = "SELECT * FROM ANSWER4X4";
			ResultSet set = DataUtil.executeQuery(sql);
			try {
				while(set.next()){
					result = true;
				}
			} catch (SQLException e) {
				result = false;
			}
		}
		if(status.equals("6")){
			String sql = "SELECT * FROM ANSWER6X6";
			ResultSet set = DataUtil.executeQuery(sql);
			try {
				while(set.next()){
					result = true;
				}
			} catch (SQLException e) {
				result = false;
			}
		}
		return result;
	}
	
	public static ArrayList<Answer4x4Model> getData4x4(String puzzle) {
		ArrayList<Answer4x4Model> listAnswer4x4 = new ArrayList<Answer4x4Model>();
		String sql = "SELECT * FROM ANSWER4X4 A " +
				"INNER JOIN QUESTIONS Q ON A.QUESTIONID = Q.QUESTIONID WHERE PUZZLEID = ?";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, puzzle);
			ResultSet resultSet = statement.executeQuery();
			Answer4x4Model model;
			while(resultSet.next()){
				model = new Answer4x4Model();
				model.setAnswerID(resultSet.getString("ANSWER4X4ID"));
				model.setPuzzleID(resultSet.getString("PUZZLEID"));
				model.setQuestionID(resultSet.getString("QUESTIONID"));
				model.setValue1(resultSet.getString("VALUE1"));
				model.setValue2(resultSet.getString("VALUE2"));
				model.setValue3(resultSet.getString("VALUE3"));
				model.setValue4(resultSet.getString("VALUE4"));
				model.setDetail(resultSet.getString("DETAIL"));
				listAnswer4x4.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAnswer4x4;
	}
	public static String randomPuzzleID4x4() {
		String puzzleID = null;
		ArrayList<String> listPuzzleID = new ArrayList<String>();
		String sql = "SELECT DISTINCT PUZZLEID FROM ANSWER4x4";
		ResultSet resultSet = DataUtil.executeQuery(sql);
		try {
			while (resultSet.next()) {
				listPuzzleID.add(resultSet.getString("PUZZLEID"));
				Random random = new Random();
				int generator = random.nextInt(listPuzzleID.size());
				puzzleID = listPuzzleID.get(generator);
			}
		} catch (SQLException e) {
			puzzleID = null;
		}
		return puzzleID;
	}
	public static void insertHighScore(String type,String playerName, String scores, String time) {
		String sql = "INSERT INTO HIGHSCORES VALUES(?,?,?,?)";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, type);
			statement.setString(2, playerName);
			statement.setString(3, scores);
			statement.setString(4, time);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ArrayList<PlayerModel> getHighScores4x4() {
		ArrayList<PlayerModel> listHighScores = new ArrayList<PlayerModel>();
		String sql = "SELECT TOP 10 * FROM HIGHSCORES WHERE TYPE = 4 ORDER BY SCORES DESC, TIMES ASC ";
		ResultSet resultSet = DataUtil.executeQuery(sql);
		PlayerModel model;
		try {
			while(resultSet.next()){
				model = new PlayerModel();
				model.setPlayerName(resultSet.getString("PLAYERNAME"));
				model.setPlayerScore(resultSet.getString("SCORES"));
				model.setPlayerTime(resultSet.getString("TIMES"));
				listHighScores.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listHighScores;
	}
	public static ArrayList<PlayerModel> getHighScores6x6() {
		ArrayList<PlayerModel> listHighScores = new ArrayList<PlayerModel>();
		String sql = "SELECT TOP 10 * FROM HIGHSCORES WHERE TYPE = 6 ORDER BY SCORES DESC, TIMES ASC";
		ResultSet resultSet = DataUtil.executeQuery(sql);
		PlayerModel model;
		try {
			while(resultSet.next()){
				model = new PlayerModel();
				model.setPlayerName(resultSet.getString("PLAYERNAME"));
				model.setPlayerScore(resultSet.getString("SCORES"));
				model.setPlayerTime(resultSet.getString("TIMES"));
				listHighScores.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listHighScores;
	}

	public static ArrayList<Answer6x6Model> getData6x6(String puzzleID) {
		ArrayList<Answer6x6Model> listAnswer6x6 = new ArrayList<Answer6x6Model>();
		String sql = "SELECT * FROM ANSWER6X6 A " +
				"INNER JOIN QUESTIONS Q ON A.QUESTIONID = Q.QUESTIONID WHERE PUZZLEID = ?";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, puzzleID);
			ResultSet resultSet = statement.executeQuery();
			Answer6x6Model model;
			while(resultSet.next()){
				model = new Answer6x6Model();
				model.setAnswerID(resultSet.getString("ANSWER6X6ID"));
				model.setPuzzleID(resultSet.getString("PUZZLEID"));
				model.setQuestionID(resultSet.getString("QUESTIONID"));
				model.setValue1(resultSet.getString("VALUE1"));
				model.setValue2(resultSet.getString("VALUE2"));
				model.setValue3(resultSet.getString("VALUE3"));
				model.setValue4(resultSet.getString("VALUE4"));
				model.setValue5(resultSet.getString("VALUE5"));
				model.setValue6(resultSet.getString("VALUE6"));
				model.setDetail(resultSet.getString("DETAIL"));
				listAnswer6x6.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAnswer6x6;
	}
	public static String randomPuzzleID6x6() {
		String puzzleID = null;
		ArrayList<String> listPuzzleID = new ArrayList<String>();
		String sql = "SELECT DISTINCT PUZZLEID FROM ANSWER6x6";
		ResultSet resultSet = DataUtil.executeQuery(sql);
		try {
			while (resultSet.next()) {
				listPuzzleID.add(resultSet.getString("PUZZLEID"));
				Random random = new Random();
				int generator = random.nextInt(listPuzzleID.size());
				puzzleID = listPuzzleID.get(generator);
			}
		} catch (SQLException e) {
			puzzleID = null;
		}
		return puzzleID;
	}
	//Insert data for puzzle table and get max puzzleID
	public static String insertPuzzle(String puzzleName) {
		String puzzleID = null;
		String sql = "INSERT INTO PUZZLE VALUES(?)";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, puzzleName);
			statement.execute();
			sql = "SELECT MAX(PUZZLEID) 'PUZZLEID' FROM PUZZLE";
			ResultSet resultSet = DataUtil.executeQuery(sql);
			while(resultSet.next()){
				puzzleID = resultSet.getString("PUZZLEID");
			}
		} catch (SQLException e) {
			puzzleID = null;
		}
		return puzzleID;
	}
	//Insert data for questions table and get max questionID
	public static String insertDataQuestions(String detail) {
		String questionID = null;
		String sql = "INSERT INTO QUESTIONS VALUES(?)";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, detail);
			statement.execute();
			sql = "SELECT MAX(QUESTIONID) 'QUESTIONID' FROM QUESTIONS";
			ResultSet resultSet = DataUtil.executeQuery(sql);
			while(resultSet.next()){
				questionID = resultSet.getString("QUESTIONID");
			}
		} catch (SQLException e) {
			questionID = null;
		}
		return questionID;
	}
	//Insert data for Answers4x4
	public static boolean insertDataAnswer4x4(String puzzleID, String questionID, String value1, String value2, String value3, String value4) {
		boolean result = false;
		String sql = "INSERT INTO ANSWER4x4 VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, puzzleID);
			statement.setString(2, questionID);
			statement.setString(3, value1);
			statement.setString(4, value2);
			statement.setString(5, value3);
			statement.setString(6, value4);
			statement.execute();
			result = true;
		} catch (SQLException e) {
			result = false;
		}
		return result;
	}
	//Insert data for Answers6x6
	public static boolean insertDataAnswer6x6(String puzzleID, String questionID, String value1, String value2, String value3, String value4, String value5, String value6) {
		boolean result = false;
		String sql = "INSERT INTO ANSWER6x6 VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, puzzleID);
			statement.setString(2, questionID);
			statement.setString(3, value1);
			statement.setString(4, value2);
			statement.setString(5, value3);
			statement.setString(6, value4);
			statement.setString(7, value5);
			statement.setString(8, value6);
			statement.execute();
			result = true;
		} catch (SQLException e) {
			result = false;
		}
		return result;
	}

	public static ArrayList<HighScoresModel> getHighScores(String type, String lowerLimit, String upperLimit) {
		ArrayList<HighScoresModel> listHighScores = new ArrayList<HighScoresModel>();
		try {
			String sql = "SELECT * FROM HIGHSCORES WHERE TYPE = ? AND (SCORES BETWEEN ? AND ?)";
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, type);
			statement.setString(2, lowerLimit);
			statement.setString(3, upperLimit);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				HighScoresModel model = new HighScoresModel();
				model.setPlayerName(resultSet.getString("PLAYERNAME"));
				model.setScores(resultSet.getString("SCORES"));
				model.setTime(resultSet.getString("TIMES"));
				listHighScores.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listHighScores;
	}
	public static Integer getTotalPlayer(String type) {
		Integer totalPlayer = null;
		String sql = "SELECT COUNT(*) 'TOTAL' FROM HIGHSCORES WHERE TYPE = ?";
		ResultSet resultSet;
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, type);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				totalPlayer = resultSet.getInt("TOTAL");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return totalPlayer;
	}
	public static Integer getHighestScore(String type) {
		Integer highestScore = null;
		String sql = "SELECT MAX(SCORES) 'HIGHEST' FROM HIGHSCORES WHERE TYPE = ?";
		ResultSet resultSet;
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, type);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				highestScore = resultSet.getInt("HIGHEST");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return highestScore;
	}
	public static Integer getLowestScore(String type) {
		Integer highestScore = null;
		String sql = "SELECT MIN(SCORES) 'LOWEST' FROM HIGHSCORES WHERE TYPE = ?";
		ResultSet resultSet;
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, type);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				highestScore = resultSet.getInt("LOWEST");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return highestScore;
	}

	public static ArrayList<PuzzleModel> searchPuzzle(String puzzleID,String puzzleName, String type) {
		ArrayList<PuzzleModel> lisPuzzle = null;
		String sql = null;
		if(type.equals("4")){
			if(puzzleID.equals("") && puzzleName.equals("")){
				lisPuzzle = new ArrayList<PuzzleModel>();
				sql = "SELECT DISTINCT P.PUZZLEID,P.PUZZLENAME FROM PUZZLE P " +
				"INNER JOIN ANSWER4X4 A ON P.PUZZLEID = A.PUZZLEID";
				ResultSet resultSet = DataUtil.executeQuery(sql);
				try {
					while (resultSet.next()) {
						PuzzleModel model = new PuzzleModel();
						model.setPuzzleID(resultSet.getString("PUZZLEID"));
						model.setPuzzleName(resultSet.getString("PUZZLENAME"));
						lisPuzzle.add(model);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			if(!puzzleID.equals("") && puzzleName.equals("")){
				lisPuzzle = new ArrayList<PuzzleModel>();
				sql = "SELECT DISTINCT P.PUZZLEID,P.PUZZLENAME FROM PUZZLE P " +
				"INNER JOIN ANSWER4X4 A ON P.PUZZLEID = A.PUZZLEID " +
				"WHERE P.PUZZLEID = ?";
				try {
					PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
					statement.setString(1, puzzleID);
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						PuzzleModel model = new PuzzleModel();
						model.setPuzzleID(resultSet.getString("PUZZLEID"));
						model.setPuzzleName(resultSet.getString("PUZZLENAME"));
						lisPuzzle.add(model);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}	
			if(puzzleID.equals("") && !puzzleName.equals("")){
				lisPuzzle = new ArrayList<PuzzleModel>();
				sql = "SELECT DISTINCT P.PUZZLEID,P.PUZZLENAME FROM PUZZLE P " +
				"INNER JOIN ANSWER4X4 A ON P.PUZZLEID = A.PUZZLEID " +
				"WHERE P.PUZZLENAME LIKE(?)";
				try {
					PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
					statement.setString(1, "%"+puzzleName+"%");
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						PuzzleModel model = new PuzzleModel();
						model.setPuzzleID(resultSet.getString("PUZZLEID"));
						model.setPuzzleName(resultSet.getString("PUZZLENAME"));
						lisPuzzle.add(model);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}	
			if(!puzzleID.equals("") && !puzzleName.equals("")){
				lisPuzzle = new ArrayList<PuzzleModel>();
				sql = "SELECT DISTINCT P.PUZZLEID,P.PUZZLENAME FROM PUZZLE P " +
				"INNER JOIN ANSWER4X4 A ON P.PUZZLEID = A.PUZZLEID " +
				"WHERE P.PUZZLEID = ? OR P.PUZZLENAME LIKE(?) ";
				try {
					PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
					statement.setString(1, puzzleID);
					statement.setString(2, "%"+puzzleName+"%");
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						PuzzleModel model = new PuzzleModel();
						model.setPuzzleID(resultSet.getString("PUZZLEID"));
						model.setPuzzleName(resultSet.getString("PUZZLENAME"));
						lisPuzzle.add(model);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}else if(type.equals("6")){
			if(puzzleID.equals("") && puzzleName.equals("")){
				lisPuzzle = new ArrayList<PuzzleModel>();
				sql = "SELECT DISTINCT P.PUZZLEID,P.PUZZLENAME FROM PUZZLE P " +
				"INNER JOIN ANSWER6X6 A ON P.PUZZLEID = A.PUZZLEID";
				ResultSet resultSet = DataUtil.executeQuery(sql);
				try {
					while (resultSet.next()) {
						PuzzleModel model = new PuzzleModel();
						model.setPuzzleID(resultSet.getString("PUZZLEID"));
						model.setPuzzleName(resultSet.getString("PUZZLENAME"));
						lisPuzzle.add(model);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			if(!puzzleID.equals("") && puzzleName.equals("")){
				lisPuzzle = new ArrayList<PuzzleModel>();
				sql = "SELECT DISTINCT P.PUZZLEID,P.PUZZLENAME FROM PUZZLE P " +
				"INNER JOIN ANSWER6X6 A ON P.PUZZLEID = A.PUZZLEID " +
				"WHERE P.PUZZLEID = ?";
				try {
					PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
					statement.setString(1, puzzleID);
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						PuzzleModel model = new PuzzleModel();
						model.setPuzzleID(resultSet.getString("PUZZLEID"));
						model.setPuzzleName(resultSet.getString("PUZZLENAME"));
						lisPuzzle.add(model);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}	
			if(puzzleID.equals("") && !puzzleName.equals("")){
				lisPuzzle = new ArrayList<PuzzleModel>();
				sql = "SELECT DISTINCT P.PUZZLEID,P.PUZZLENAME FROM PUZZLE P " +
				"INNER JOIN ANSWER6X6 A ON P.PUZZLEID = A.PUZZLEID " +
				"WHERE P.PUZZLENAME LIKE(?)";
				try {
					PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
					statement.setString(1, "%"+puzzleName+"%");
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						PuzzleModel model = new PuzzleModel();
						model.setPuzzleID(resultSet.getString("PUZZLEID"));
						model.setPuzzleName(resultSet.getString("PUZZLENAME"));
						lisPuzzle.add(model);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}	
			if(!puzzleID.equals("") && !puzzleName.equals("")){
				lisPuzzle = new ArrayList<PuzzleModel>();
				sql = "SELECT DISTINCT P.PUZZLEID,P.PUZZLENAME FROM PUZZLE P " +
				"INNER JOIN ANSWER6X6 A ON P.PUZZLEID = A.PUZZLEID " +
				"WHERE P.PUZZLEID = ? OR P.PUZZLENAME LIKE(?) ";
				try {
					PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
					statement.setString(1, puzzleID);
					statement.setString(2, "%"+puzzleName+"%");
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						PuzzleModel model = new PuzzleModel();
						model.setPuzzleID(resultSet.getString("PUZZLEID"));
						model.setPuzzleName(resultSet.getString("PUZZLENAME"));
						lisPuzzle.add(model);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}	
		return lisPuzzle;
	}
	public static boolean updatePuzzleTable(String puzzleID, String puzzleName) {
		String sql = "UPDATE PUZZLE SET PUZZLENAME = ? WHERE PUZZLEID = ?";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, puzzleName);
			statement.setString(2, puzzleID);
			statement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public static boolean updateAnswerAndQuestion4x4(String questionID, String detail, String value1, String value2, String value3, String value4) {
		String sql = 
			"UPDATE ANSWER4X4 SET VALUE1 = ?, VALUE2 = ?, VALUE3 = ?, VALUE4 = ? WHERE QUESTIONID = ? " +
			"UPDATE QUESTIONS SET DETAIL = ? WHERE QUESTIONID = ?";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, value1);
			statement.setString(2, value2);
			statement.setString(3, value3);
			statement.setString(4, value4);
			statement.setString(5, questionID);
			statement.setString(6, detail);
			statement.setString(7, questionID);
			statement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public static boolean updateAnswerAndQuestion6x6(String questionID, String detail, String value1, String value2, String value3, String value4, String value5, String value6) {
		String sql = 
			"UPDATE ANSWER6X6 SET VALUE1 = ?, VALUE2 = ?, VALUE3 = ?, VALUE4 = ?, VALUE5 = ?, VALUE6 = ? WHERE QUESTIONID = ? " +
			"UPDATE QUESTIONS SET DETAIL = ? WHERE QUESTIONID = ?";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, value1);
			statement.setString(2, value2);
			statement.setString(3, value3);
			statement.setString(4, value4);
			statement.setString(5, value5);
			statement.setString(6, value6);
			statement.setString(7, questionID);
			statement.setString(8, detail);
			statement.setString(9, questionID);
			statement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public static boolean deletePuzzle(String puzzleID, String type) {
		if(type.equals("4")){
			String sql = "DELETE PUZZLE WHERE PUZZLEID = ? " +
						 "DELETE ANSWER4X4 WHERE PUZZLEID = ?";
			try {
				PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
				statement.setString(1, puzzleID);
				statement.setString(2, puzzleID);
				statement.execute();
				return true;
			} catch (Exception e) {
				return false;
			}
		}else{
			String sql = "DELETE PUZZLE WHERE PUZZLEID = ? " +
						 "DELETE ANSWER6X6 WHERE PUZZLEID = ?";
			try {
				PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
				statement.setString(1, puzzleID);
				statement.setString(2, puzzleID);
				statement.execute();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
	public static boolean deleteQuestion(String questionID) {
		String sql = "DELETE QUESTIONS WHERE QUESTIONID = ?";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, questionID);
			statement.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}












