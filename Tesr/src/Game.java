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
		
		System.out.println("=====프롤로그=====\r\n"
				+ "\r\n"
				+ "모두가 기다려온 2022 카타르 월드컵\r\n"
				+ "그러나 대회가 시작되기 일주일 전, 코로나의 급격한\r\n"
				+ "확산으로 모든 국가의 선수가 감염되게 되고\r\n"
				+ "대체 선수가 소집된다.\r\n"
				+ "\r\n"
				+ "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]\r\n"
				+ "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]\r\n"
				+ "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]\r\n"
				+ "\r\n"
				+ "그리하여 대한민국 대표팀은 놀랍게도\r\n"
				+ "스마트인재개발원에 다니는 빅데이터반 25명이 뽑히게 되고,\r\n"
				+ "다른 나라들도 은퇴한 레전드 선수를 포함한\r\n"
				+ "새로운 로스터를 꾸리게 되는데...\n");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int clear = 0;

		int i = 0;
		// 조별리그 승리 카운트
		int cnt = 0;
		// 조별리그 > 8 강 진출 조건
		int advance = 2;

		while (i != 6) {
			if (i < 3) {
				System.out.println("=====조별리그=====");
				if (i == 0) {
					System.out.println("일본 : 한국은 우리 일본의 상대가 되지 못한다메다메! ");
				} else if (i == 1) {
					System.out.println("독일 : 지난번엔 신태용의 마법으로 이겼지만 이번엔 안된다구텐탁! ");
				} else {
					System.out.println("아르헨티나 : 메시의 첫 월드컵 트로피를 가져와주마라도나!");
				}
			} else if (i == 3) {
				System.out.println("======8강======");
				System.out.println("잉글랜드 : 지성팍 없는 한국팀은 무섭지않다잉글!");
			} else if (i == 4) {
				System.out.println("=====준결승=====");
				System.out.println("프랑스 : 어떻게 4강까지 온지 몰라도 우리의 상대는 안되쥬뗌므");
			} else {
				System.out.println("=====결 승=====");
				System.out.println("스인재FC : 이미 너네의 실력은 데이터분석이 끝났다 후후훗...!");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 팀선택
			list = func.teamSelect(func.randomNumber());
			// 우리팀 선수 명단
			func.desc(list);
			// 우리팀 라이프 산출
			func.life1 = func.calLife(list.get(0).status, list.get(1).status, list.get(2).status, list.get(3).status,
					list.get(4).status) + mini;
			// 상대팀
			System.out.println();
			opList = func.opSelect(op.get(i));
			// 상대팀 선수 명단
			func.desc(opList);
			// 상대팀 라이프 산출
			func.life2 = func.calLife(opList.get(0).status, opList.get(1).status, opList.get(2).status,
					opList.get(3).status, opList.get(4).status);
			// 라이프 보여주기
			if (i == 0) {
				System.out.println("\n" + "*라이프 산출 기준 : 팀원 능력치 평균/10" + "\n");
			}
			System.out.println("BigDataFC");
			logo.life(func.life1);
			System.out.println(op.get(i));
			logo.life(func.life2);
			// 승부차기
			while (func.life1 > 0 && func.life2 > 0) {
				int num1 = 0;
				while (true) {
					System.out.println("공 찰곳을 골라주세요");
					System.out.print("1.왼쪽 2.중앙 3.오른쪽 >>");
					num1 = sc.nextInt();
					if (num1 <= 3 && num1 > 0) {
						break;
					} else {
						System.out.println("다시 입력해 주세요.");
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
				// 승패
				if (func.life2 == 0) {
					cnt++;
				}
			}
			if (i == 2) {
				if (cnt >= advance) {
					System.out.println("==축하합니다!! 다음 라운드 진출==");
					System.out.println("어떻게 한 건 지는 모르겠지만 빅데이터FC는 \r\n"
							+ "조별예선을 통과했다!\r\n"
							+ "다음 8강전 상대는 축구의 종주국 잉글랜드.\r\n"
							+ "그들의 운명은?\n");
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
					System.out.println("==축하합니다!! 우승입니다.==");
					System.out.println("대회 일주일 전 구성된 빅데이터 FC는 당당히\r\n"
							+ "카타르 월드컵 우승 트로피를 가져오게 되었다.\r\n"
							+ "배당률 202,111,152,022,042,260 : 1 을 뚫고 우승을 \r\n"
							+ "차지한 빅데이터 FC.\r\n"
							+ "그들의 역사는 이제 시작이다..!\n");
					clear = 1;
				}
			} else if (i >= 3) {
				if (func.life1 == 0) {
					System.out.println("=========GAME OVER=========");
					break;
				} else {
					System.out.println("==축하합니다!! 다음 라운드 진출==");
					if (i == 3) {
						System.out.println("전 세계 모든 토토인들이 충격을 금치 못했다.\r\n"
								+ "빅데이터반 25명은 모두의 예상을 뚫고 4강전에\r\n"
								+ "진출하게 되고, 4강 상대는 최강의 아트사커 프랑스.\r\n"
								+ "그들은 기적을 쓸 수 있을까?\n");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.out.println("빅데이터FC는 기적을 일으키며 2022 월드컵 결승에\r\n"
								+ "진출하게 된다. 상대는 역사 상 최고의 선수들로 \r\n"
								+ "구성된 스인재FC.\r\n"
								+ "세계 최고의 재능을 갖춘 박병관 선수가 중심이 되어\r\n"
								+ "어나더레벨을 보여주는 스인재 FC를 꺾을 수 있을 것인가..!\n");
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

		if (nick.equals("관리자")) {
			clear = 1;
		}
		return clear;
	}

	public void miniGame() {
		int i = rd.nextInt(5);
		quiz.add("박병관 : 제가 키우는 고양이의 이름은 무엇일까요? ");
		ans.add("호두");
		quiz.add("박병관 : 제 YouTube 채널의 이름은 무엇일까요? ");
		ans.add("호두아빠");
		quiz.add("박병관 : 제 YouTube 채널의 구독자 수는 200명을 넘습니다. O/X ");
		ans.add("X");
		quiz.add("박병관 : 최근에 전주 수목원을 다녀왔는데요, 전주 수목원은 삼각대를 가지고 들어갈 수 없습니다. O/X");
		ans.add("O");
		quiz.add("박병관 : 저희 빅데이터반의 급훈은 무엇일까요? ");
		ans.add("안되면될때까지");
		
		logo.병관();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(quiz.get(i));
		System.out.print("정답 입력 : ");
		String answer = sc.next();
		if (answer.equals(ans.get(i))) {
			System.out.println("병관쌤의 선물 life + 1");
			mini = 1;
		} else {
			System.out.println("병관쌤이 화났다 life - 1");
			mini = -1;
		}
	}
}
