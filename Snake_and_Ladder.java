import java.util.*;

public class Snake_and_Ladder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        System.out.println("..............................SNAKE AND LADDER......................");
        int p1 = 0;
        int p2 = 0;
        int min = 1;
        int max = 6;
        int d1 = 0, d2 = 0;

        System.out.println("...................................WELCOME..........................");

        while (true) {
          
            if (p1 >= 20) {
                System.out.println(" PLAYER 1 WON THE GAME!!! ");
                break;
            }

            while (true) {
                System.out.println("_______________________________________");
                System.out.println("Player 1 (r to roll):");
                char r = sc.next().charAt(0);

                if (r == 'r') {
                    d1 = ran.nextInt((max - min) + 1) + min;
                    p1 += d1;

                    if (p1 > 20) {
                        p1 -= d1;
                        System.out.println("You got : "+d1+". No move... You remain at " + p1);
                    } else {
                        System.out.println("You got: " + d1 + ". Now you are at " + p1);

                        if (p1 == 20) {
                            System.out.println(" PLAYER 1 REACHED 20 AND WON THE GAME!!! ");
                            System.exit(0);
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
                            continue; // same player rolls again
                        }
                    }
                    break; 
                } else {
                    System.out.println("ENTER A VALID 'r' TO PLAY");
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////////
            if (p2 >= 20) {
                System.out.println("🎉 PLAYER 2 WON THE GAME!!! 🎉");
                break;
            }

            while (true) {
                System.out.println("_______________________________________");
                System.out.println("Player 2 (r to roll):");
                char r = sc.next().charAt(0);

                if (r == 'r') {
                    d2 = ran.nextInt((max - min) + 1) + min;
                    p2 += d2;

                    if (p2 > 20) {
                        p2 -= d2;
                        System.out.println("You got : "+d2+". No move... You remain at " + p2);
                    } else {
                        System.out.println("You got: " + d2 + ". Now you are at " + p2);

                        if (p2 == 20) {
                            System.out.println("🎊 PLAYER 2 REACHED 20 AND WON THE GAME!!! 🎊");
                            System.exit(0);
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
                            continue; // same player rolls again
                        }
                    }
                    break;
                } else {
                    System.out.println("ENTER A VALID 'r' TO PLAY");
                }
            }
        }

        sc.close();
    }
}
