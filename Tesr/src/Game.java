import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	Function func = new Function();
	Logo logo = new Logo();
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	MemberDAO dao = new MemberDAO();
	ArrayList<Player> list = func.teamSelect(func.randomNumber());
	ArrayList<Player> opList;
	ArrayList<String> quiz = new ArrayList<String>();
	ArrayList<String> ans = new ArrayList<String>();
	int mini = 0;

	public int play(String nick) {

		ArrayList<String> op = new ArrayList<String>();
		op.add("JAPAN");
		op.add("GERMANY");
		op.add("ARGENTINA");
		op.add("ENGLAND");
		op.add("FRANCE");
		op.add("SMHRDFC");
		
		System.out.println("=====���ѷα�=====\r\n"
				+ "\r\n"
				+ "��ΰ� ��ٷ��� 2022 īŸ�� ������\r\n"
				+ "�׷��� ��ȸ�� ���۵Ǳ� ������ ��, �ڷγ��� �ް���\r\n"
				+ "Ȯ������ ��� ������ ������ �����ǰ� �ǰ�\r\n"
				+ "��ü ������ �����ȴ�.\r\n"
				+ "\r\n"
				+ "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]\r\n"
				+ "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]\r\n"
				+ "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]\r\n"
				+ "\r\n"
				+ "�׸��Ͽ� ���ѹα� ��ǥ���� ����Ե�\r\n"
				+ "����Ʈ���簳�߿��� �ٴϴ� �����͹� 25���� ������ �ǰ�,\r\n"
				+ "�ٸ� ����鵵 ������ ������ ������ ������\r\n"
				+ "���ο� �ν��͸� �ٸ��� �Ǵµ�...\n");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int clear = 0;

		int i = 0;
		// �������� �¸� ī��Ʈ
		int cnt = 0;
		// �������� > 8 �� ���� ����
		int advance = 2;

		while (i != 6) {
			if (i < 3) {
				System.out.println("=====��������=====");
				if (i == 0) {
					System.out.println("�Ϻ� : �ѱ��� �츮 �Ϻ��� ��밡 ���� ���Ѵٸ޴ٸ�! ");
				} else if (i == 1) {
					System.out.println("���� : �������� ���¿��� �������� �̰����� �̹��� �ȵȴٱ���Ź! ");
				} else {
					System.out.println("�Ƹ���Ƽ�� : �޽��� ù ������ Ʈ���Ǹ� �������ָ��󵵳�!");
				}
			} else if (i == 3) {
				System.out.println("======8��======");
				System.out.println("�ױ۷��� : ������ ���� �ѱ����� �������ʴ��ױ�!");
			} else if (i == 4) {
				System.out.println("=====�ذ��=====");
				System.out.println("������ : ��� 4������ ���� ���� �츮�� ���� �ȵ������");
			} else {
				System.out.println("=====�� ��=====");
				System.out.println("������FC : �̹� �ʳ��� �Ƿ��� �����ͺм��� ������ ������...!");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ������
			list = func.teamSelect(func.randomNumber());
			// �츮�� ���� ���
			func.desc(list);
			// �츮�� ������ ����
			func.life1 = func.calLife(list.get(0).status, list.get(1).status, list.get(2).status, list.get(3).status,
					list.get(4).status) + mini;
			// �����
			System.out.println();
			opList = func.opSelect(op.get(i));
			// ����� ���� ���
			func.desc(opList);
			// ����� ������ ����
			func.life2 = func.calLife(opList.get(0).status, opList.get(1).status, opList.get(2).status,
					opList.get(3).status, opList.get(4).status);
			// ������ �����ֱ�
			if (i == 0) {
				System.out.println("\n" + "*������ ���� ���� : ���� �ɷ�ġ ���/10" + "\n");
			}
			System.out.println("BigDataFC");
			logo.life(func.life1);
			System.out.println(op.get(i));
			logo.life(func.life2);
			// �º�����
			while (func.life1 > 0 && func.life2 > 0) {
				int num1 = 0;
				while (true) {
					System.out.println("�� ������ ����ּ���");
					System.out.print("1.���� 2.�߾� 3.������ >>");
					num1 = sc.nextInt();
					if (num1 <= 3 && num1 > 0) {
						break;
					} else {
						System.out.println("�ٽ� �Է��� �ּ���.");
					}
				}
				int num2 = rd.nextInt(3) + 1;
				boolean result = func.GoalGame(num1, num2);
				func.minusLife(result);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				logo.goal(result);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				logo.successGoal(result);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("BigDataFC");
				logo.life(func.life1);
				System.out.println(op.get(i));
				logo.life(func.life2);
				// ����
				if (func.life2 == 0) {
					cnt++;
				}
			}
			if (i == 2) {
				if (cnt >= advance) {
					System.out.println("==�����մϴ�!! ���� ���� ����==");
					System.out.println("��� �� �� ���� �𸣰����� ������FC�� \r\n"
							+ "���������� ����ߴ�!\r\n"
							+ "���� 8���� ���� �౸�� ���ֱ� �ױ۷���.\r\n"
							+ "�׵��� �����?\n");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("=========GAME OVER=========");
					break;
				}
			} else if (i == 5) {
				if (func.life1 == 0) {
					System.out.println("=========GAME OVER=========");
					break;
				} else {
					System.out.println("==�����մϴ�!! ����Դϴ�.==");
					System.out.println("��ȸ ������ �� ������ ������ FC�� �����\r\n"
							+ "īŸ�� ������ ��� Ʈ���Ǹ� �������� �Ǿ���.\r\n"
							+ "���� 202,111,152,022,042,260 : 1 �� �հ� ����� \r\n"
							+ "������ ������ FC.\r\n"
							+ "�׵��� ����� ���� �����̴�..!\n");
					clear = 1;
				}
			} else if (i >= 3) {
				if (func.life1 == 0) {
					System.out.println("=========GAME OVER=========");
					break;
				} else {
					System.out.println("==�����մϴ�!! ���� ���� ����==");
					if (i == 3) {
						System.out.println("�� ���� ��� �����ε��� ����� ��ġ ���ߴ�.\r\n"
								+ "�����͹� 25���� ����� ������ �հ� 4������\r\n"
								+ "�����ϰ� �ǰ�, 4�� ���� �ְ��� ��Ʈ��Ŀ ������.\r\n"
								+ "�׵��� ������ �� �� ������?\n");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.out.println("������FC�� ������ ����Ű�� 2022 ������ ��¿�\r\n"
								+ "�����ϰ� �ȴ�. ���� ���� �� �ְ��� ������� \r\n"
								+ "������ ������FC.\r\n"
								+ "���� �ְ��� ����� ���� �ں��� ������ �߽��� �Ǿ�\r\n"
								+ "��������� �����ִ� ������ FC�� ���� �� ���� ���ΰ�..!\n");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (nick.equals("������")) {
			clear = 1;
		}
		return clear;
	}

	public void miniGame() {
		int i = rd.nextInt(5);
		quiz.add("�ں��� : ���� Ű��� ������� �̸��� �����ϱ��? ");
		ans.add("ȣ��");
		quiz.add("�ں��� : �� YouTube ä���� �̸��� �����ϱ��? ");
		ans.add("ȣ�ξƺ�");
		quiz.add("�ں��� : �� YouTube ä���� ������ ���� 200���� �ѽ��ϴ�. O/X ");
		ans.add("X");
		quiz.add("�ں��� : �ֱٿ� ���� ������� �ٳ�Դµ���, ���� ������� �ﰢ�븦 ������ �� �� �����ϴ�. O/X");
		ans.add("O");
		quiz.add("�ں��� : ���� �����͹��� ������ �����ϱ��? ");
		ans.add("�ȵǸ�ɶ�����");
		
		logo.����();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(quiz.get(i));
		System.out.print("���� �Է� : ");
		String answer = sc.next();
		if (answer.equals(ans.get(i))) {
			System.out.println("�������� ���� life + 1");
			mini = 1;
		} else {
			System.out.println("�������� ȭ���� life - 1");
			mini = -1;
		}
	}
}
