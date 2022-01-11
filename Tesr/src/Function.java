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

	// �帮�̹� �ε� �� Ŀ�ؼ� ��ü�� �������� �޼ҵ�
	private void getConnection() {
		try {
			// JDBC
			// 0. JDBC�� ����ϴ� PROJECT�� ����̹� �ֱ�....
			// 1. ����̹� �ε� - ���� ����ϴ� DBMS�� ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection ���� - ID,PW,DB�ּ� ��
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

	// Java�� Database������ ���� ����
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

	// �츮�� ���� �̱�
	// 1. ������ �̱�
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

	// 2. �츮 ���� �̱�
	public ArrayList<Player> teamSelect(int[] a) {
		System.out.println("BigDataFC");
		ArrayList<Player> memberList = new ArrayList<Player>();
		try {
			getConnection();
			// 3. SQL�� �ۼ� �� ����
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

	// 3. ��� ���� �̱�
	public ArrayList<Player> opSelect(String name) {
		ArrayList<Player> opList = new ArrayList<Player>();
		System.out.println("��� �� : "+name);
		try {
			getConnection();
			// 3. SQL�� �ۼ� �� ����
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

	// 4. ������ ����
	public int calLife(int a, int b, int c, int d, int e) {
		int result = a + b + c + d + e;
		result = result / 5;
		result = result / 10;
		return result;
	}

	// 5. ������ ����
	public void minusLife(boolean a) {
		if (a) {
			life1--;
		} else {
			life2--;
		}
	}
	
	// 6. �� ���� Ȯ��
	public boolean GoalGame(int num1, int num2) {
		if(num1 == num2) {
			// �޼ҵ� ���� true���·� �ޱ�
			System.out.println("�������ϴ�");
			return true;
		}else {
			// �޼ҵ� ���� false���·� �ޱ�
			System.out.println("GOAL");
			return false;
		}
	}
	
	// 7. ��� ����
	public void desc(ArrayList<Player> a) {
		for (int l = 0; l < a.size(); l++) {
			System.out.println("�̸� : "+a.get(l).name+" Status : "+a.get(l).status);
		}
	}
}
