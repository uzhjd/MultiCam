package chap08;

import java.sql.*;
import java.util.ArrayList;

public class JdbcTestDAO {
	// 데이터 전달 X, 데이터 처리 결과를 넘겨줌.
	
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;

	//	생성자 호출만 하면 DB연결이 된다.
	public JdbcTestDAO() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, user, pwd);
			
		} catch (Exception e) {
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