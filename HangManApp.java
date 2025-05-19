import com.sun.source.doctree.SystemPropertyTree;

import java.util.Scanner;


public class HangManApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Game game = new Game();
    private static void game(Scanner scanner, Game game){

    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("1.Начать новую игру");
            System.out.println("2.Выйти из игры");
            try {


                Integer Intenger = 0;
                int choice = Intenger.parseInt(scanner.nextLine());
                Game game;
                switch (choice) {
                    case 1:
                       Game (scanner, game);
                }
            }
        }
    }

}
