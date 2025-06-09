import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Game {
    private static final Random random = new Random();
    private static final Dictionary wordsDictionary = new Dictionary();
    private static final Set<Character> enteredChars = new HashSet<>();

    private static String getRandomWord() {
        String[] dictionary = wordsDictionary.getWords();
        return dictionary[random.nextInt(dictionary.length)].toLowerCase();
    }

    public static void startsNewGame() {
        String secretWord = getRandomWord();
        char[] hiddenWord = new char[secretWord.length()];
        Arrays.fill(hiddenWord, '_');

        Scanner scanner = new Scanner(System.in);
        int attempts = 6;
        int mistakes = 0;

        while (attempts > 0 && new String(hiddenWord).contains("_")) {
            clearConsole();
            Graphics.printStage(mistakes);

            System.out.println("\nСлово: " + String.valueOf(hiddenWord));
            System.out.println("Осталось попыток: " + attempts);
            System.out.println("Ранее введенные буквы" + enteredChars);

            char guess = getValidInput(scanner);
            boolean found = updateHiddenWord(secretWord, hiddenWord, guess);

            if (!found) {
                attempts--;
                mistakes++;
                System.out.println("Нет такой буквы! Осталось попыток: " + attempts);
                System.out.println("Ранее введенные буквы" + enteredChars);
            }

            sleep(500);
        }

        showFinalResult(secretWord, hiddenWord);
        enteredChars.clear();
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static char getValidInput(Scanner scanner) {

        while (true) {
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.length() != 1) {
                System.out.println("Ошибка: введите ровно один символ!");
                continue;
            }

            char ch = input.charAt(0);

            if (!Character.UnicodeBlock.of(ch).equals(Character.UnicodeBlock.CYRILLIC)) {
                System.out.println("Ошибка: символ '" + ch + "' не является кириллицей!");
                continue;
            }

            if (enteredChars.contains(ch)) {
                System.out.println("Ошибка: символ '" + ch + "' уже был введён ранее!");
                continue;
            }

            enteredChars.add(ch);
            return ch;
        }
    }

    private static boolean updateHiddenWord(String secretWord, char[] hiddenWord, char guess) {
        boolean found = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess) {
                hiddenWord[i] = guess;
                found = true;
            }
        }
        return found;
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void showFinalResult(String secretWord, char[] hiddenWord) {
        clearConsole();

        if (!new String(hiddenWord).contains("_")) {
            Graphics.printFinalStage(true);
            System.out.println("\nПоздравляем! Вы угадали слово: " + secretWord);
        } else {
            Graphics.printStage(6);
            System.out.println("\nИгра окончена! Загаданное слово было: " + secretWord);
        }
    }
}