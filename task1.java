import java.util.Random;
import java.util.Scanner;

class task1{

    static Scanner sc = new Scanner(System.in);
    static int randomNum;
    static int choice;
    static int attempt;
    static int score = 0;

    static void generateRandomNum() {
        Random random = new Random();
        randomNum = random.nextInt(100) + 1;
    }

    static void displayWelcome() {
        System.out.println("\n\t\t\t\t\t =================================> *** WELCOME TO NUMBER GAME *** <=================================");
        System.out.println("\n\t\t\t\t\t                              ***  CHOICE THE NUMBER BETWEEN 0-100  ***                             ");
    }

    static void displayInstructions() {
        System.out.println("\n-> GAME INSTRUCTIONS :-\n" +
                "1] You have only 3 lives\n" +
                "2] If you WIN, 100 POINTS will be credited in SCORE\n\n" +
                "-> FEEDBACK INSTRUCTION :-\n" +
                "1] Too high -> Your number is GREATER than the ANSWER number\n" +
                "2] Too low -> Your number is LESSER than the ANSWER number\n" +
                "3] Too close but high -> Your number is 5 digits CLOSER to the ANSWER number but still GREATER\n" +
                "4] Too close but low -> Your number is 5 digits CLOSER to the ANSWER number but still LOWER\n");
    }

    static void displayGameStart() {
        System.out.println("\t\t\t\t\t ===============================>  ***   LET'S Gooooo....   ***  <===================================");
    }

    static void displayScoreAndPromptRestart() {
        System.out.println("Your SCORE: " + score);
        System.out.print("ENTER 1 TO PLAY AGAIN / ENTER (ANY_KEY) TO EXIT: ");
    }

    static void displayAttemptLimitExceeded() {
        System.out.println("RAN OUT OF ATTEMPT LIMIT !");
        System.out.print("ENTER 1 TO RESTART GAME / ENTER (ANY-KEY) TO EXIT: ");
    }

    static void displayLiveLeft() {
        System.out.println("\t\t\t\t\t\t\t\t                            *** Attempts left : " + (3 - attempt) + " *** ");
    }

    static void displayCongratulations() {
        System.out.println("CONGRATULATIONS YOU WON");
    }

    static void displayIncorrectAnswer() {
        System.out.print("INCORRECT ANSWER: ");
        feedback();
        System.out.print("ENTER 1 TO GUESS AGAIN / ENTER (ANY_KEY) TO EXIT: ");
    }

    static void userPrompt() {
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        System.out.println();
    }

    static void feedback() {
        if (choice <= randomNum && choice >= randomNum - 5) {
            System.out.println("Too close but low");
        } else if (choice >= randomNum && choice <= randomNum + 5) {
            System.out.println("Too close but high");
        } else if (choice > randomNum) {
            System.out.println("Too high");
        } else {
            System.out.println("Too low");
        }
    }

    public static void main(String[] args) {
        int restartGame = 0;
        int pressedKey = 1;

        displayWelcome();
        displayInstructions();
        displayGameStart();

        do {
            generateRandomNum();
            attempt = 0;

            do {
                attempt++;

                if (attempt > 3) {
                    displayAttemptLimitExceeded();
                    restartGame = sc.nextInt();
                    System.out.println();
                    break;
                }

                userPrompt();
                displayLiveLeft();

                if (choice == randomNum) {
                    score += 100;
                    displayCongratulations();
                    displayScoreAndPromptRestart();
                    restartGame = sc.nextInt();
                    System.out.println();
                    break;
                } else {
                    displayIncorrectAnswer();
                    pressedKey = sc.nextInt();
                    System.out.println();
                    restartGame = 0;
                }
            } while (pressedKey == 1 && attempt <= 3);
        } while (restartGame == 1);
    }
}

