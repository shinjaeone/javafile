package game;
import java.util.Scanner;
import java.util.Random;

public class sjw20211232_mid2 {
    
    public static void main(String[] args) {
        Scanner jaewon = new Scanner(System.in);
        Random robot = new Random();
        String[] three = {"가위", "바위", "보"};
        String[] four = {"왼쪽", "오른쪽", "위", "아래"};

        System.out.println("가위바위보와 참참참 게임을 시작합니다!");

        while (true) {
            System.out.println("가위바위보 중 하나를 선택하세요 (가위, 바위, 보): ");
            String five = jaewon.next();
            int six = choice(three, five);

            if (six == -1) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }

            int seven = robot.nextInt(3);
            System.out.println("로봇의 선택: " + three[seven]);

            String eight = winner(six, seven);

            if (eight.equals("draw")) {
                System.out.println("비겼습니다. 다시 시작합니다.");
                continue;
            }

            String nine = eight.equals("jaewon") ? "재원" : "로봇";
            System.out.println(nine + "가 먼저 공격합니다.");

            boolean ten = false;

            while (!ten) {
                System.out.println(nine + "의 턴입니다. 방향을 선택하세요 (왼쪽, 오른쪽, 위, 아래): ");
                String eleven = jaewon.next();
                
                int twelve = choice(four, eleven);

                if (twelve == -1) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    continue;
                }

                int thirteen = robot.nextInt(4);
                System.out.println("로봇의 선택: " + four[thirteen]);

                if (twelve == thirteen) {
                    System.out.println(nine + "가 승리했습니다!");
                    ten = true;
                } else {
                    nine = nine.equals("재원") ? "로봇" : "재원";
                }
            }

            System.out.println("게임을 다시 시작하시겠습니까? (예/아니오): ");
            String playAgain = jaewon.next();
            if (!playAgain.equalsIgnoreCase("예")) {
                break;
            }
        }

        jaewon.close();
    }
    
    public static int choice(String[] choices, String choice) {
        for (int i = 0; i < choices.length; i++) {
            if (choices[i].equals(choice)) {
                return i;
            }
        }
        return -1;  
    }

    public static String winner(int jaewon, int robot) {
        if (jaewon == robot) {
            return "draw";
        } else if ((jaewon == 0 && robot == 2) || (jaewon == 1 && robot == 0) || (jaewon == 2 && robot == 1)) {
            return "jaewon";
        } else {
            return "robot";
        }
    }
}
