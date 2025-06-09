import java.util.Scanner;

public class HangManApp extends Game {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 2) {
                    System.out.println("Выход из игры...");
                    scanner.close();
                    return;
                } else if (choice == 1) {
                    startGame();
                } else {
                    System.out.println("Неверный ввод! Попробуйте еще раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Начать новую игру");
        System.out.println("2. Выйти из игры");
        System.out.print("Выберите действие: ");
    }

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            Game.startsNewGame();

            // Цикл для проверки корректности ответа
            while (true) {
                System.out.print("\nХотите сыграть еще раз? (да/нет): ");
                playAgain = scanner.nextLine().trim().toLowerCase();

                if (playAgain.equals("да") || playAgain.equals("нет")) {
                    break; // Выход из цикла проверки, если ввод корректен
                } else {
                    System.out.println("Пожалуйста, введите только 'да' или 'нет'!");
                }
            }

        } while (playAgain.equals("да"));

        System.out.println("Игра завершена. До свидания!");
    }
}
