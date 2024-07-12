import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name for Player 1: ");
        Player player1 = new Player(scanner.nextLine(), 'X');
        System.out.print("Enter name for Player 2: ");
        Player player2 = new Player(scanner.nextLine(), 'O');

        Game game = new Game(player1, player2);

        while (true) {
            game.printBoard();
            System.out.println("Current Player: " + game.getCurrentPlayer().getName());
            System.out.print("Enter row and column (0, 1, or 2) separated by a space: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (game.makeMove(row, col)) {
                if (game.checkForWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.getCurrentPlayer().getName() + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("The game is a tie!");
                    break;
                }
                game.changePlayer(player1, player2);
            } else {
                System.out.println("This move is not valid");
            }
        }

        scanner.close();
    }
}
