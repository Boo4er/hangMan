import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static String getRandomWord() {
        Random random = new Random();
        Words wordsDictionary = new Words();
        return wordsDictionary.getWordsDictionary()[random.nextInt(wordsDictionary.getWordsDictionary().length)];
    }

    public static void startsNewGame() {
        String secretWord = getRandomWord().toLowerCase();
        char[] hiddenWord = new char[secretWord.length()];
        Arrays.fill(hiddenWord, '_');

        Scanner scanner = new Scanner(System.in);
        int attempts = 6;
        int mistakes = 0;

        while (attempts > 0 && new String(hiddenWord).contains("_")) {
            System.out.print("\033[H\033[2J");  // Очистка консоли
            System.out.flush();

            Graphics.printStage(mistakes);
            System.out.println("\nСлово: " + String.valueOf(hiddenWord));
            System.out.println("Осталось попыток: " + attempts);
            System.out.print("Введите букву: ");

            char guess = scanner.next().toLowerCase().charAt(0);
            boolean found = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    hiddenWord[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                attempts--;
                mistakes++;
                System.out.println("Нет такой буквы! Осталось попыток: " + attempts);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

        if (!new String(hiddenWord).contains("_")) {
            Graphics.printFinalStage(true);
            System.out.println("\nПоздравляем! Вы угадали слово: " + secretWord);
        } else {
            Graphics.printStage(6); // Полная виселица
            System.out.println("\nИгра окончена! Загаданное слово было: " + secretWord);
        }
    }
}