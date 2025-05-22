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
        do {
            Game.startsNewGame();
            System.out.print("\nХотите сыграть еще раз? (да/нет): ");
        } while (scanner.nextLine().equalsIgnoreCase("да"));
    }
}
