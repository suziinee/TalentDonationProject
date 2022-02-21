package probono.model.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	
	

	/* Properties 객체들 */
	
	static Properties dbInfo = new Properties();
	static Properties ActivistDAOsql = new Properties();
	
	
	/* 최초 실행 static */
	
	static {
		
		try {
			dbInfo.load(new FileReader("sql/db.properties"));
			ActivistDAOsql.load(new FileReader("sql/ActivistDAO.properties"));
			Class.forName(dbInfo.getProperty("jdbc.driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/* ActivistDAOsql 문장 반환 */

	public static String getActivistDAOsql(String property) {
		return ActivistDAOsql.getProperty(property);
	}
	

	/* Connection 객체 반환*/

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbInfo.getProperty("jdbc.url"),
											dbInfo.getProperty("jdbc.id"),
											dbInfo.getProperty("jdbc.pw"));
	}

	
	/* close 메소드 */

	public static void close(Connection con, Statement stmt) {
		
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	
	public static void close(Connection con, Statement stmt, ResultSet rset) {
		
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	
	
}
