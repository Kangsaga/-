import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {

		Logo logo = new Logo();
		Game game = new Game();
		Scanner sc = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		
		logo.showLogo2();
		MusicPlayer player = new MusicPlayer();
		player.play();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			System.out.print("1.로그인 2.회원가입 3.게임시작 4.명예의 전당 5.회원 정보 수정 6.회원 탈퇴 7.게임 종료>>>");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("==== 로그인 ====");

				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				String nick = dao.login(id, pw);
				
				if (nick != null) {
					System.out.println(nick + "님 환영합니다");

					System.out.print("1.게임 시작 2.게임 종료 3.미니 게임");
					choice = sc.nextInt();
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (choice == 1) {
						System.out.println("++++++ 게임을 시작 합니다 +++++ ");
						int clear = game.play(nick);
						if (clear == 1) {
							player.channelUpOrDown(1);
							logo.win();
							dao.updateHonor(nick);
						}
					} else if (choice == 2) {
						System.out.println("게임 종료");
						break;
					} else if (choice == 3) {
						game.miniGame();
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("++++++ 게임을 시작 합니다 +++++ ");
						int clear = game.play(nick);
						if (clear == 1) {
							player.channelUpOrDown(1);
							logo.win();
							dao.updateHonor(nick);
						}
					}

				} else {
					System.out.println("다시 로그인 하세요");
				}

			} else if (choice == 2) {
				System.out.println("==== 회원가입 ====");
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("패스워드 입력 : ");
				String pw = sc.next();
				System.out.print("닉네임 입력 : ");
				String nick = sc.next();

				int cnt = dao.join(id, pw, nick);

				if (cnt > 0) {
					System.out.println("회원가입 성공");
				} else {
					System.out.println("회원가입 실패");
				}

			} else if (choice == 3) {

				System.out.println("로그인을 해주세요");

			} else if (choice == 4) {

				System.out.println("==== 명예의 전당 ====");
				ArrayList<String> honorList = dao.selectHonor();
				for (int i = 0; i < honorList.size(); i++) {
					System.out.println(i+1+ ". " + honorList.get(i));
				}

			} else if (choice == 5) {
				System.out.println("==== 회원정보 수정 ====");
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				System.out.print("바꾸고 싶은 닉네임 입력 :");
				String nick = sc.next();

				int cnt = dao.update(id, pw, nick);

				if (cnt > 0) {
					System.out.println("정보수정 성공");
				} else {
					System.out.println("정보수정 실패");
				}
			} else if (choice == 6) {
				System.out.println("=====회원 탈퇴======");
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				int cnt = dao.delete(id, pw);
				if (cnt > 0) {
					System.out.println("탈퇴 성공");
				} else {
					System.out.println("탈퇴 실패");
				}
			} else if (choice == 7) {
				System.out.println("게임 종료....");
				player.stop();
				break;
			}

		}
		sc.close();
	}

}
