import java.util.*;

class SnakeLadderGame {
    int p1 = 0;
    int p2 = 0;
    int min = 1;
    int max = 6;
    int d1 = 0, d2 = 0;
    Random ran = new Random();

    public boolean playTurn(int playerNumber, Scanner sc) {
        while (true) {
            System.out.println("_______________________________________");
            System.out.println("Player " + playerNumber + " (r to roll):");
            try {
                String input = sc.next();
                if (input.length() == 0) {
                    System.out.println("ENTER A VALID 'r' TO PLAY");
                    continue;
                }
                char r = input.charAt(0);

                if (r == 'r') {
                    int dice = ran.nextInt((max - min) + 1) + min;

                    if (playerNumber == 1) {
                        d1 = dice;
                        p1 += d1;
                        if (p1 > 20) {
                            p1 -= d1;
                            System.out.println("You got : " + d1 + ". No move... You remain at " + p1);
                        } else {
                            System.out.println("You got: " + d1 + ". Now you are at " + p1);

                            if (p1 == 20) {
                                System.out.println(" PLAYER 1 REACHED 20 AND WON THE GAME!!! ");
                                return true;
                            }

                            switch (p1) {
                                case 42:
                                    p1 = 66;
                                    System.out.println("🪜 You climbed a ladder! Now at " + p1);
                                    break;
                                case 76:
                                    p1 = 19;
                                    System.out.println("🐍 Snake bite! Moved down to " + p1);
                                    break;
                                case 97:
                                    p1 = 7;
                                    System.out.println("🐍 Snake bite! Moved down to " + p1);
                                    break;
                                default:
                                    break;
                            }

                            if (d1 == 1 || d1 == 5) {
                                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
                                System.out.println("You got another chance! ");
                                continue;
                            }
                        }
                    } else {
                        d2 = dice;
                        p2 += d2;
                        if (p2 > 20) {
                            p2 -= d2;
                            System.out.println("You got : " + d2 + ". No move... You remain at " + p2);
                        } else {
                            System.out.println("You got: " + d2 + ". Now you are at " + p2);

                            if (p2 == 20) {
                                System.out.println("🎊 PLAYER 2 REACHED 20 AND WON THE GAME!!! 🎊");
                                return true;
                            }

                            switch (p2) {
                                case 42:
                                    p2 = 66;
                                    System.out.println("🪜 You climbed a ladder! Now at " + p2);
                                    break;
                                case 76:
                                    p2 = 19;
                                    System.out.println("🐍 Snake bite! Moved down to " + p2);
                                    break;
                                case 97:
                                    p2 = 7;
                                    System.out.println("🐍 Snake bite! Moved down to " + p2);
                                    break;
                                default:
                                    break;
                            }

                            if (d2 == 1 || d2 == 5) {
                                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
                                System.out.println("You got another chance! ");
                                continue;
                            }
                        }
                    }
                    break;
                } else {
                    System.out.println("ENTER A VALID 'r' TO PLAY");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter 'r' to roll.");
                sc.nextLine(); // Clear the invalid input from scanner buffer
            }
        }
        return false;
    }

    public int getP1() { return p1; }
    public int getP2() { return p2; }
}

public class Snake_and_Ladder_Exception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("..............................SNAKE AND LADDER......................");
        System.out.println("...................................WELCOME..........................");

        SnakeLadderGame game = new SnakeLadderGame();

        try {
            while (true) {
                if (game.getP1() >= 20) {
                    System.out.println(" PLAYER 1 WON THE GAME!!! ");
                    break;
                }
                if (game.playTurn(1, sc)) {
                    System.exit(0);
                }

                if (game.getP2() >= 20) {
                    System.out.println("🎉 PLAYER 2 WON THE GAME!!! 🎉");
                    break;
                }
                if (game.playTurn(2, sc)) {
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. Exiting game.");
        } finally {
            sc.close();
        }
    }
}