package edu.project1;


public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        ConsoleHangman consoleHangman = new ConsoleHangman();
        Session session = new Session("d", null, 5,
                new GuessResult(0, ""));
        consoleHangman.run(session);
    }
}
