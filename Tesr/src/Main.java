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
			System.out.print("1.�α��� 2.ȸ������ 3.���ӽ��� 4.���� ���� 5.ȸ�� ���� ���� 6.ȸ�� Ż�� 7.���� ����>>>");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("==== �α��� ====");

				System.out.print("���̵� �Է� : ");
				String id = sc.next();
				System.out.print("��й�ȣ �Է� : ");
				String pw = sc.next();
				String nick = dao.login(id, pw);
				
				if (nick != null) {
					System.out.println(nick + "�� ȯ���մϴ�");

					System.out.print("1.���� ���� 2.���� ���� 3.�̴� ����");
					choice = sc.nextInt();
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (choice == 1) {
						System.out.println("++++++ ������ ���� �մϴ� +++++ ");
						int clear = game.play(nick);
						if (clear == 1) {
							player.channelUpOrDown(1);
							logo.win();
							dao.updateHonor(nick);
						}
					} else if (choice == 2) {
						System.out.println("���� ����");
						break;
					} else if (choice == 3) {
						game.miniGame();
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("++++++ ������ ���� �մϴ� +++++ ");
						int clear = game.play(nick);
						if (clear == 1) {
							player.channelUpOrDown(1);
							logo.win();
							dao.updateHonor(nick);
						}
					}

				} else {
					System.out.println("�ٽ� �α��� �ϼ���");
				}

			} else if (choice == 2) {
				System.out.println("==== ȸ������ ====");
				System.out.print("���̵� �Է� : ");
				String id = sc.next();
				System.out.print("�н����� �Է� : ");
				String pw = sc.next();
				System.out.print("�г��� �Է� : ");
				String nick = sc.next();

				int cnt = dao.join(id, pw, nick);

				if (cnt > 0) {
					System.out.println("ȸ������ ����");
				} else {
					System.out.println("ȸ������ ����");
				}

			} else if (choice == 3) {

				System.out.println("�α����� ���ּ���");

			} else if (choice == 4) {

				System.out.println("==== ���� ���� ====");
				ArrayList<String> honorList = dao.selectHonor();
				for (int i = 0; i < honorList.size(); i++) {
					System.out.println(i+1+ ". " + honorList.get(i));
				}

			} else if (choice == 5) {
				System.out.println("==== ȸ������ ���� ====");
				System.out.print("���̵� �Է� : ");
				String id = sc.next();
				System.out.print("��й�ȣ �Է� : ");
				String pw = sc.next();
				System.out.print("�ٲٰ� ���� �г��� �Է� :");
				String nick = sc.next();

				int cnt = dao.update(id, pw, nick);

				if (cnt > 0) {
					System.out.println("�������� ����");
				} else {
					System.out.println("�������� ����");
				}
			} else if (choice == 6) {
				System.out.println("=====ȸ�� Ż��======");
				System.out.print("���̵� �Է� : ");
				String id = sc.next();
				System.out.print("��й�ȣ �Է� : ");
				String pw = sc.next();
				int cnt = dao.delete(id, pw);
				if (cnt > 0) {
					System.out.println("Ż�� ����");
				} else {
					System.out.println("Ż�� ����");
				}
			} else if (choice == 7) {
				System.out.println("���� ����....");
				player.stop();
				break;
			}

		}
		sc.close();
	}

}
