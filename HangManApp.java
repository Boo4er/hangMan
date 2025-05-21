import java.util.Scanner;
public class HangManApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Начать новую игру");
            System.out.println("2. Выйти из игры");
            System.out.print("Выберите действие: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        startGame();
                        break;
                    case 2:
                        System.out.println("Выход из игры...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Неверный ввод! Попробуйте еще раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число!");
            }
        }
    }

    public static void startGame() {
        Game.startsNewGame();

        System.out.print("\nХотите сыграть еще раз? (y/n): ");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.equals("y")) {
            startGame();
        }
    }
}
