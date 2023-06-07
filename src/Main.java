import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    private static final String WHITE_COLOR_CODE = "\u001B[97m";
    private static final String RED_COLOR_CODE = "\u001B[31m";
    private static final String MINT_COLOR_CODE = "\u001B[38;5;85m";
    private static final String PARTY_EMOJI = "\uD83C\uDF89"; //🎉


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);


        boolean isRunning = true;
        while (isRunning)
        {
            // Display Main Menu.
            displayMenu();

            // Get user choice from the main menu.
            int choice = getUserChoice(input);

            switch (choice)
            {
                // Signing Up.
                case 1:
                    System.out.println(" ");
                    System.out.println("< ------------------- A New World, A New Journey ------------------ >");
                    Functions.signup();
                    break;

                // Logging In.
                case 2:
                    System.out.println(" ");
                    System.out.println("< ------------------- Let's Do This ------------------ >");
                    System.out.print("Enter Username: ");
                    String username = input.nextLine();
                    System.out.print("Enter Password: ");
                    String password = input.nextLine();

                    UserLogin info = new UserLogin(username, password);
                    boolean answer = LoginCheckFromDB.checkLogin(info);
                    System.out.println(" ");
                    if (answer)
                    {
                        System.out.println(MINT_COLOR_CODE + "Congratulations! You've Made It!" + PARTY_EMOJI + WHITE_COLOR_CODE);
                        // Greeting the user.
                        Functions.greetings(info);
                        isRunning = handleLoggedInMenu(input, info);
                    }
                    else
                    {
                        System.out.println(RED_COLOR_CODE + "Credentials Clash: Authentication Aborted! \uD83D\uDE15" + WHITE_COLOR_CODE);
                    }
                    break;
                case 3:
                    // Update Password.
                    Functions.forgetPassword();
                    break;
                case 4:
                    // Depart and Exit.
                    isRunning = false;
                    System.out.println(" ");
                    System.out.println(MINT_COLOR_CODE+"Application Terminated. "+WHITE_COLOR_CODE);
                    break;
            }
        }

        input.close();
    }

    // Main Menu
    private static void displayMenu()
    {
        System.out.println(" ");
        System.out.println(MINT_COLOR_CODE + "\t\t\t\t\t WELCOME TO ∧ＴＬ∧ＳＭＩＮＤ" + WHITE_COLOR_CODE);
        System.out.println("Press [1] To Join Us.");
        System.out.println("Press [2] To Login and Step Into Your World.");
        System.out.println("Press [3] To Forgot your password? We'll help you recover.");
        System.out.println("Press [4] To Depart & Exit.");
        System.out.print("Enter Your Desired Choice: ");
    }

    // Users Choice.
    private static int getUserChoice(Scanner input)
    {
        int choice = 0;
        try
        {
            choice = input.nextInt();
            input.nextLine();
        }
        catch (InputMismatchException e)
        {
            System.out.println(" ");
            System.out.println(RED_COLOR_CODE + "Error: Input is not an integer" + WHITE_COLOR_CODE);
            input.nextLine();
        }
        return choice;
    }

    private static boolean handleLoggedInMenu(Scanner input, UserLogin info)
    {
        while (true)
        {

            // Menu Within After Login.
            displayLoggedInMenu();
            int selection = getUserChoice(input);
            System.out.println();
            switch (selection)
            {
                case 1:
                    Functions.addHabit(info);
                    break;
                case 2:
                    Functions.showHabit(info);
                    break;
                case 3:
                    Functions.deleteHabit(info);
                    break;
                case 4:
                    Functions.updateHabit(info);
                    break;
                case 5:
                    Functions.showHistory(info);
                    break;
                case 6:
                    Functions.showDeletedHabit(info);
                    break;
                case 7:
                    Functions.quotes();
                    break;
                case 8:
                    Functions.showUserInfo(info);
                    break;
                case 9:
//                    displayMenu();
                    System.out.println("Logged Out...");
                    break;
                default:
//                    System.out.println(" ");
                    System.out.println(RED_COLOR_CODE + "Error: Invalid Menu Choice" + WHITE_COLOR_CODE);// multiple times appearing
                    break;
            }
            if (selection == 9)
            {
                break;//bug fix
            }
        }
        return true;
    }

    // Menu After Logging In.
    private static void displayLoggedInMenu()
    {
        System.out.println(" ");
        System.out.println(MINT_COLOR_CODE + "\t\t\t\t\t ∧ＴＬ∧ＳＭＩＮＤ \n" + WHITE_COLOR_CODE);
//        System.out.println(WHITE_COLOR_CODE);
        System.out.println("Press [1] To Introduce a New Habit.");
        System.out.println("Press [2] To Showcase Current Habits.");
        System.out.println("Press [3] To Delete a Habit");
        System.out.println("Press [4] To Enhance Progress");
        System.out.println("Press [5] To View History");
        System.out.println("Press [6] To View Deleted Habits");
        System.out.println("Press [7] To View Inspiring Quote of the Day.");
        System.out.println("Press [8] To View User Info.");
        System.out.println("Press [9] To Logout and Disembark.");
        System.out.print("Enter your choice: ");
    }
}
