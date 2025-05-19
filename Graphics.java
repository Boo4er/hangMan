public class Graphics {
    private static final String[] STAGES = {
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
        // Проверяем границы массива
        int stage = Math.min(Math.max(wrongAttempts, 0), STAGES.length - 1);
        System.out.println(STAGES[stage]);
    }

    public static void animateHanging() throws InterruptedException {
        System.out.print("\033[H\033[2J"); // Очистка экрана
        System.out.flush();

        for (int i = 0; i < STAGES.length; i++) {
            System.out.print("\033[H\033[2J"); // Очистка экрана
            System.out.println("Этап " + (i + 1) + " из " + STAGES.length);
            printStage(i);
            Thread.sleep(1000); // Пауза 1 секунда
        }
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
            printStage(STAGES.length - 1);
            System.out.println("Игра окончена! Вы проиграли!");
        }
    }
}

