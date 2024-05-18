package game;

import java.util.Scanner;
import java.util.Random;

public class sjw20211232_mid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("가위바위보 게임을 시작합니다!");
        System.out.println("가위는 0, 바위는 1, 보는 2를 입력하세요.");

        while (true) {
            System.out.print("당신의 선택은? (0: 가위, 1: 바위, 2: 보): ");
            int userChoice = scanner.nextInt();

            int computerChoice = random.nextInt(3);

            System.out.println("로봇의 선택: " + computerChoice);
            determineWinner(userChoice, computerChoice);

            System.out.print("게임을 다시 하시겠습니까? (예/아니오): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("예")) {
                break;
            }
        }

        scanner.close();
    }

    public static void determineWinner(int user, int computer) {
        if (user == computer) {
            System.out.println("비겼습니다!");
        } else if ((user == 0 && computer == 2) ||
                   (user == 1 && computer == 0) ||
                   (user == 2 && computer == 1)) {
            System.out.println("당신이 이겼습니다!");
        } else {
            System.out.println("로봇이 이겼습니다!");
        }
    }
}
