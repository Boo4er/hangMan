import com.sun.source.doctree.SystemPropertyTree;


public class HangManApp {

    public static void main(String[] args) {
//        System.out.println(Stirng [] wordsDictionary);
        System.out.println("1.Начать новую игру");
        System.out.println("2.Выйти из игры");
        Words wordsDictionary = new Words();
        System.out.println("Все слова");
        wordsDictionary.printAllWords();
    }
}
