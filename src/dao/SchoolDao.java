package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;

public class SchoolDao extends Dao{
	/*
	 * getメソッド 学校コードを指定して学校インスタンスを１件取得する
	 *
	 * @param cd:String
	 * 			学校コード
	 * @return 学校クラスのインスタンス 存在しない場合はnull
	 * @throws Exception
	 * */
	public School get(String cd) throws Exception{
		// 学校インスタンスを初期化
		School school = new School();
		// DBへのコネクションを確率
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try{
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from school where cd = ?");
			// プリペアードステートメントに学校コードをバインド
			statement.setString(1, cd);
			// プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			if(rSet.next()){
				// リザルトセットが存在する場合
				// 学校インスタンスに学校コードと学校名をセット
				school.setCd(rSet.getString("cd"));
				school.setName(rSet.getString("name"));
			}else{
				// 存在しない場合
				// 学校インスタンスにnullをセット
				school = null;
			}
		}catch(Exception e){
			throw e;
		}finally{
			// プリペアードステートメントを閉じる
			if(statement != null){
				try{
					statement.close();
				}catch(SQLException sqle){
					throw sqle;
				}
			}
			// コネクションを閉じる
			if(connection != null){
				try{
					connection.close();
				}catch(SQLException sqle){
					throw sqle;
				}
			}
		}
		return school;
	}
	 public List<School> getAll() throws Exception {
	        List<School> list = new ArrayList<>();

	        try (Connection con = getConnection()) {
	            String sql = "SELECT * FROM SCHOOL ORDER BY CD";
	            PreparedStatement stmt = con.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                School school = new School();
	                school.setCd(rs.getString("CD"));
	                school.setName(rs.getString("NAME"));
	                list.add(school);
	            }

	        } catch (Exception e) {
	            throw e;
	        }

	        return list;
	    }


}
