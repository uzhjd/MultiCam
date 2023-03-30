package mvc.twitter;

import java.sql.*;
import java.util.ArrayList;

public class TwitterDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;

	//	생성자 호출만 하면 DB연결이 된다.
	public TwitterDAO() {
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
	
	// 반환 타입: TwitterLoginDO - session에 저장애햐지만 login한 사용자의 정보를 가질 수 있다.
	// 
	public TwitterLoginDO checkLogin(TwitterLoginDO loginDO) {
		TwitterLoginDO result = null;
		this.sql = "select * from twitter_login where id = ? and passwd = ?";
		
		try {
			// 1. 들어온 데이터가 사용자 정보에 저장되어 있는지 먼저 확인
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginDO.getId());
			pstmt.setString(2, loginDO.getPasswd());
			rs = pstmt.executeQuery();
			
			// 2. 들어온 데이터가 로그인할 수 있는 데이터라면 로그인 session에 사용자의 정보를 담아줌.
			// while이 아닌 if인 이유? 쿼리의 실행 결과가 단일 행 또는 행 없음이므로 반복문을 사용할 필요없음.
			// 로그인 성공한 사용자의 정보를 반환해주기 위한 TwitterLoginDO 생성
			if(rs.next()) {
				result = new TwitterLoginDO();
				result.setId(rs.getString("id"));
				result.setPasswd(rs.getString("passwd"));
				result.setName(rs.getString("name"));
			}
			
		} catch(Exception e) {
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
		
		return result;
	}
	
	public ArrayList<TwitterDO> getAllTwitter() {
		ArrayList<TwitterDO> list = new ArrayList<TwitterDO>();
		TwitterDO tDO = null;
		this.sql = "select twitter.id || '@' || name as id_name, message, to_char(create_date, 'YYYY/MM/DD HH24:MI:SS') as cdatetime "
				+ "from twitter inner join twitter_login "
				+ "on twitter.id = twitter_login.id ";
		
		try {

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			// 1. 모든 사용자의 정보를 가져옴.
			// 여러개의 반환값이 나오므로 반복문 사용
			// 주의할 점: 쿼리의 alias를 사용해서 지정해줘야 함.
			while(rs.next()) {
				tDO = new TwitterDO();
				tDO.setId(rs.getString("id_name"));
				tDO.setMessage(rs.getString("message"));
				tDO.setCreateDate(rs.getString("cdatetime"));
				
				list.add(tDO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(!stmt.isClosed()) {
					stmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int insertTwitter(TwitterDO tDo) {
		int rowCount = 0;
		sql = "insert into twitter (no, id, message) values(twitter_seq.nextval, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tDo.getId());
			pstmt.setString(2, tDo.getMessage());
			
			rowCount = pstmt.executeUpdate();
		} catch(Exception e) {
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
		
		return rowCount;
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
