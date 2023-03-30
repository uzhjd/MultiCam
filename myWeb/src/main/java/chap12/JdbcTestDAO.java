package chap12;

import java.sql.*;
import java.util.ArrayList;
import javax.naming.*;
import javax.sql.*;

public class JdbcTestDAO {
	// 데이터 전달 X, 데이터 처리 결과를 넘겨줌.
	
	private DataSource ds = null;
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	
	public void JdbcTestDAO() {
		try {
			// JNDI 이용하기
			InitialContext context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracleXE");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public int insertJdbcTest(JdbcTestDO testDO) {
		int rowCount = 0;
		
		this.sql = "insert into jdbc_test values(?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, testDO.getUsername());
			pstmt.setString(2, testDO.getEmail());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return rowCount;
	}
	
	public ArrayList<JdbcTestDO> selectAllJdbcTest() {
		ArrayList<JdbcTestDO> list = new ArrayList<JdbcTestDO> ();
		JdbcTestDO testDo = null;
		this.sql = "select * from jdbc_test";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				testDo = new JdbcTestDO();
				testDo.setUseranme(rs.getString("username"));
				testDo.setEmail(rs.getString("email"));
				
				list.add(testDo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public void closeConnection() {
		try {
			if(!conn.isClosed()) {
				conn.close();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}