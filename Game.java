import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static String getRandomWord() {

        Random random = new Random();
        Words wordsDictionary = new Words();
        return wordsDictionary.getWordsDictionary()[random.nextInt(wordsDictionary.getWordsDictionary().length)];
//        System.out.println("Все слова");
//        wordsDictionary.printAllWords();
    }

    public static void main(String[] args) {
        String secretWord = getRandomWord();
        System.out.println("Загаданное слово:" + secretWord);
        char[] hiddenWord = new char[secretWord.length()];
        Arrays.fill(hiddenWord, '_');
        Scanner scanner = new Scanner(System.in);
        int attemps = 6;
        while (attemps > 0 && new String(hiddenWord).contains("_")) {
            System.out.println("\nСлово:" + String.valueOf(hiddenWord));
            System.out.println("Остальсь попыток:" + attemps);
            System.out.print("Введите букву: ");
            char guess = scanner.next().toLowerCase().charAt(0);
            boolean found = false;
            for (int i = 0;
                 i < secretWord.length();
                 i++) {
                if (secretWord.charAt(i) == guess) {
                    hiddenWord[i] = guess;
                    found = true;
                }

            }
            if (!found) {
                attemps--;
                System.out.println("Нет такой буквы! осталось попыток: " + attemps);
            }

        }
        if (!new String(hiddenWord).contains("_")) {
            System.out.println("/nПоздравляем! Вы угадали слово: " + secretWord);
        } else {
            System.out.println("/nИгра окончена! Загаданное слово было: " + secretWord);
        }
        scanner.close();
    }
}

