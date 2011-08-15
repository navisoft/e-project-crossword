package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import model.Answer4x4Model;

import util.DataUtil;

public class GameDao {
	public static boolean checkExistsData() {
		boolean result = false;
		String sql = "SELECT * FROM PUZZLE";
		ResultSet set = DataUtil.executeQuery(sql);
		try {
			while(set.next()){
				result = true;
			}
		} catch (SQLException e) {
			result = false;
		}
		return result;
	}
	
	public static ArrayList<Answer4x4Model> getData(String puzzle) {
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
}
