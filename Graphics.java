public class Graphics {
    private static final String[] HANGMAN_STAGES = {
            """
          +---+
          |   |
              |
              |
              |
              |
        =========
        """,

            """
          +---+
          |   |
          O   |
              |
              |
              |
        =========
        """,

            """
          +---+
          |   |
          O   |
          |   |
              |
              |
        =========
        """,

            """
          +---+
          |   |
          O   |
         /|   |
              |
              |
        =========
        """,

            """
          +---+
          |   |
          O   |
         /|\\  |
              |
              |
        =========
        """,

            """
          +---+
          |   |
          O   |
         /|\\  |
         /    |
              |
        =========
        """,

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
        }
    }
}

