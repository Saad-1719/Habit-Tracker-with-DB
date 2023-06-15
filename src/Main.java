import java.util.Scanner;

import static java.lang.System.exit;
public class Main
{
    static String whiteColorCode = "\u001B[97m";
    static String redColorCode = "\u001B[31m";
    static String mintColorCode = "\u001B[38;5;85m";
    static String partyEmoji = "\uD83C\uDF89"; //🎉
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning)
        {
            // Display Main Menu.
//            System.out.println(" ");
            System.out.println(mintColorCode + "\t\t\t\t\t ＷＥＬＣＯＭＥ ＴＯ ΛＴＬΛＳＭＩＮＤ" + whiteColorCode);
            System.out.println(" ");
            System.out.println("Press [1] To Login and Step Into Your World.");
            System.out.println("Press [2] To Join Us.");
            System.out.println("Press [3] To Forgot your password.");
            System.out.println("Press [4] To Depart & Exit.");
            System.out.print("Enter Your Desired Choice: ");
            // Get user choice from the main menu.
            int choice = Functions.getUserChoice(input);
//            System.out.println(" ");
            switch (choice)
            {
                // Logging In.
                case 1:
                    System.out.println(" ");
                    System.out.println(mintColorCode+"< ------------------- Let's Do This ------------------ >"+whiteColorCode);
                    System.out.println(" ");
                    System.out.print("Enter Username: ");
                    String username = input.nextLine().toLowerCase();
                    System.out.print("Enter Password: ");
                    String password = input.nextLine();
                    // Checking Username & Password From Database.
                    UserLogin info = new UserLogin(username, password);
                    boolean dataFound = LoginCheckFromDB.checkLogin(info);
                    System.out.println(" ");
                    if (dataFound)
                    {
                        System.out.println(mintColorCode + "Congratulations! You've Made It!" + partyEmoji + whiteColorCode);
                        // Greeting the user.
                        Functions.greetings(info);
                        //isRunning = handleLoggedInMenu(input, info);
                        while (true)
                        {
                            // Menu Within After Login.
                            System.out.println(" ");
                            System.out.println(mintColorCode + "\t\t\t\t\t ΛＴＬΛＳＭＩＮＤ \n" + whiteColorCode);
                            System.out.println("Press [1] To Introduce a New Habit.");
                            System.out.println("Press [2] To Showcase Current Habits.");
                            System.out.println("Press [3] To Delete a Habit.");
                            System.out.println("Press [4] To Enhance Progress.");
                            System.out.println("Press [5] To View Completed Habit History.");
                            System.out.println("Press [6] To View Deleted Habit History.");
                            System.out.println("Press [7] To View Inspiring Quote of the Day.");
                            System.out.println("Press [8] To View User Information.");
                            System.out.println("Press [9] To Learn About the Team.");
                            System.out.println("Press [10] To Logout and Disembark.");
                            System.out.print("Enter your choice: ");
                            int selection = Functions.getUserChoice(input);
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
                                    Functions.developerInfo();
                                    break;
                                case 10:
                                    System.out.println(mintColorCode + "Logged Out..." + whiteColorCode);
                                    break;
                                default:
                                    System.out.println(redColorCode + "Error: Invalid Menu Choice" + whiteColorCode);
                                    break;
                            }
                            if (selection == 10)
                            {
                                break;
                            }
                        }
                    }
                    else
                    {
                        System.out.println(redColorCode + "Credentials Clash: Authentication Aborted! \uD83D\uDE15" + whiteColorCode);
                    }
                    break;
                // Signing Up.
                case 2:
                    System.out.println(" ");
                    System.out.println(mintColorCode+"< ------------------- A New World, A New Journey ------------------ >"+whiteColorCode);
                    System.out.println(" ");
                    Functions.signup();
                    break;
                case 3:
                    // Update Password.
                    Functions.forgetPassword();
                    break;
                case 4:
                    // Depart and Exit.
                    isRunning = false;
                    System.out.println(" ");
                    System.out.println(mintColorCode + "Application Terminated. " + whiteColorCode);
                    exit(0);
                    break;
                default:
                    System.out.println(redColorCode + "Error: Invalid Menu Choice" + whiteColorCode);
                    break;
            }
        }
        input.close();
    }
}