public class Graphics {
    private static final String[] HANGMAN_STAGES = {
            // 0 ошибок (начальное состояние)
            """
          +---+
          |   |
              |
              |
              |
              |
        =========
        """,

            // 1 ошибка (голова)
            """
          +---+
          |   |
          O   |
              |
              |
              |
        =========
        """,

            // 2 ошибки (туловище)
            """
          +---+
          |   |
          O   |
          |   |
              |
              |
        =========
        """,

            // 3 ошибки (левая рука)
            """
          +---+
          |   |
          O   |
         /|   |
              |
              |
        =========
        """,

            // 4 ошибки (обе руки)
            """
          +---+
          |   |
          O   |
         /|\\  |
              |
              |
        =========
        """,

            // 5 ошибок (левая нога)
            """
          +---+
          |   |
          O   |
         /|\\  |
         /    |
              |
        =========
        """,

            // 6 ошибок (полная фигура - проигрыш)
            """
          +---+
          |   |
          O   |
         /|\\  |
         / \\  |
              |
        =========
        """
    };

    public static void printStage(int wrongAttempts) {
        int stage = Math.min(Math.max(wrongAttempts, 0), HANGMAN_STAGES.length - 1);
        System.out.println(HANGMAN_STAGES[stage]);
    }

    public static void printFinalStage(boolean isWin) {
        System.out.print("\033[H\033[2J");
        if (isWin) {
            System.out.println("""
              Поздравляем! Вы выиграли!
                 \\O/
                  |
                 / \\
            """);
        } else {
            printStage(6);
            System.out.println("Игра окончена! Вы проиграли!");
        }
    }
}

