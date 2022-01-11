import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_f_4_1209";
			String db_pw = "smhrd4";

			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String login(String id, String pw) {

		getConnection();

		try {
			String sql = "select * from member where id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
				return rs.getString("nick");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();

		}
		return null;
	}
	public int join(String id, String pw, String nick) {

		getConnection();

		try {
			String sql = "insert into  member values(?,?,?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick);

			return psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();

		}
		return 0;
	}
	
	public int delete(String id, String pw) {
		int cnt = 0;
		try {
			getConnection();
			// 3. SQL문 작성 및 실행
			String sql = "DELETE FROM member WHERE ID = ? AND PW = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	public ArrayList<MemberDTO> selectALL() {

		getConnection();

		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		try {

			String sql = "select * from member";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String nick = rs.getString("nick");
				MemberDTO m = new MemberDTO(id, pw, nick);
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}
	
	public ArrayList<String> selectHonor() {
		
		getConnection();
		
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			
			String sql = "select * from honor order by ranking";
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String nick = rs.getString("nick");
				list.add(nick);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
		
	}
	public int update(String id, String pw, String nick) {

		getConnection();

		try {
			String sql = "update member set nick = ? where id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nick);
			psmt.setString(2, id);
			psmt.setString(3, pw);

			return psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();

		}
		return 0;
	}
	
	public int updateHonor(String nick) {

		getConnection();

		try {
			String sql = "INSERT INTO honor VALUES(seq_mid.NEXTVAL,?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nick);
			
			return psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();

		}
		return 0;
	}
}
