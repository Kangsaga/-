import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Function {

	Random rd = new Random();

	int life1 = 0;
	int life2 = 0;

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	// 드리이버 로딩 및 커넥션 개체를 가져오는 메소드
	private void getConnection() {
		try {
			// JDBC
			// 0. JDBC를 사용하는 PROJECT에 드라이버 넣기....
			// 1. 드라이버 로딩 - 내가 사용하는 DBMS의 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 연결 - ID,PW,DB주소 必
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_f_4_1209";
			String db_pw = "smhrd4";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Java와 Database사이의 연결 해제
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 우리팀 랜덤 뽑기
	// 1. 랜덤수 뽑기
	public int[] randomNumber() {

		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = rd.nextInt(25) + 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
				}
			}
		}
		return arr;
	}

	// 2. 우리 팀원 뽑기
	public ArrayList<Player> teamSelect(int[] a) {
		System.out.println("BigDataFC");
		ArrayList<Player> memberList = new ArrayList<Player>();
		try {
			getConnection();
			// 3. SQL문 작성 및 실행
			String sql = "SELECT * FROM bigdatafc WHERE MEMBER_ID IN (?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			for (int i = 0; i < a.length; i++) {
				psmt.setInt(i + 1, a[i]);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				Player fc = new Player(rs.getString("name"), rs.getInt("status"));
				memberList.add(fc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return memberList;
	}

	// 3. 상대 팀원 뽑기
	public ArrayList<Player> opSelect(String name) {
		ArrayList<Player> opList = new ArrayList<Player>();
		System.out.println("상대 팀 : "+name);
		try {
			getConnection();
			// 3. SQL문 작성 및 실행
			String sql = "SELECT * FROM " + name;
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Player op = new Player(rs.getString("name"), rs.getInt("status"));
				opList.add(op);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return opList;
	}

	// 4. 라이프 산출
	public int calLife(int a, int b, int c, int d, int e) {
		int result = a + b + c + d + e;
		result = result / 5;
		result = result / 10;
		return result;
	}

	// 5. 라이프 차감
	public void minusLife(boolean a) {
		if (a) {
			life1--;
		} else {
			life2--;
		}
	}
	
	// 6. 골 여부 확인
	public boolean GoalGame(int num1, int num2) {
		if(num1 == num2) {
			// 메소드 값을 true형태로 받기
			System.out.println("막혔습니다");
			return true;
		}else {
			// 메소드 값을 false형태로 받기
			System.out.println("GOAL");
			return false;
		}
	}
	
	// 7. 명단 보기
	public void desc(ArrayList<Player> a) {
		for (int l = 0; l < a.size(); l++) {
			System.out.println("이름 : "+a.get(l).name+" Status : "+a.get(l).status);
		}
	}
}
