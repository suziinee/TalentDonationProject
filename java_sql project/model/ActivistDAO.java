/* CREATE TABLE activist (

       activist_id          VARCHAR2(20)  PRIMARY KEY,
       name                 VARCHAR2(20) NULL,
       password             VARCHAR2(20) NULL,
       major                VARCHAR2(50) NULL
);  */

package probono.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import probono.model.dto.ActivistDTO;
import probono.model.util.DBUtil;

public class ActivistDAO {

	
	
	/* 저장 */
	
	public static boolean addActivist(ActivistDTO activist) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(DBUtil.getActivistDAOsql("insert"));
			pstmt.setString(1, activist.getId());
			pstmt.setString(2, activist.getName());
			pstmt.setString(3, activist.getPassword());
			pstmt.setString(4, activist.getMajor());
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
	/* 수정 : 기부자 id로 기부 내용 수정 */
	
	public static boolean updateActivist(String activistId, String major) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(DBUtil.getActivistDAOsql("update"));
			pstmt.setString(1, major);
			pstmt.setString(2, activistId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}		
		} catch (SQLException s){
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	
	/* 삭제 */
	
	public static boolean deleteActivist(String activistId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(DBUtil.getActivistDAOsql("delete"));
			pstmt.setString(1, activistId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	
	/* id로 해당 기부자 반환 */
	
	public static ActivistDTO getActivist(String activistId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ActivistDTO activist = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(DBUtil.getActivistDAOsql("getActivist"));
			pstmt.setString(1, activistId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				activist = new ActivistDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}			
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return activist;
	}
	
	
	/* 모든 기부자 반환 */
	
	public static ArrayList<ActivistDTO> getAllActivists() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ActivistDTO> all = new ArrayList<ActivistDTO>();
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(DBUtil.getActivistDAOsql("getAllActivists"));
			rset = pstmt.executeQuery();
			while (rset.next()) {
				all.add( new ActivistDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)) );
			}
		} catch (SQLException s){
			s.printStackTrace();
			throw s; 
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return all;
	}
	
	
	
}
