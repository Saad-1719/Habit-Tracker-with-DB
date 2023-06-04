import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //color codes
//        String cyanBrightBlueColorCode = "\u001B[96m";
        String whiteColorCode = "\u001B[90m";
        String redColorCode = "\u001B[31m";
//        String MintColorCode = "\u001B[38;5;85m";
        String MintColorCode = "\u001B[92m";
//        String blueGreenColorCode = "\u001B[36m";
        String brightPinkColorCode = "\u001B[95m";
//        String darkBlueColorCode = "\u001B[38;5;24m";
        System.out.println( brightPinkColorCode+"                        ∧ＴＬ∧ＳＭＩＮＤ Welcomes you");
        System.out.println(whiteColorCode);

        while (true)
        {
            try
            {
                System.out.println("1- Join now ");
                System.out.println("2- Login and step into your world.");
                System.out.println("3- Forgot your password? We'll help you to recover.");
                System.out.println("4- Ready to depart? Exit gracefully.");
                System.out.print("Enter your choice ");
                int choice = input.nextInt();
                input.nextLine();
                    if (choice == 1)
                    {
                        Functions.signup();
                    }
                    else if (choice == 2)
                    {
                        System.out.print("Enter username : ");
                        String username;
                        username = input.nextLine();
                        System.out.print("Enter password : ");
                        String password;
                        password = input.nextLine();
                        UserLogin info = new UserLogin(username, password);
                        boolean answer = LoginCheckFromDB.checkLogin(info);
                        if (answer)
                        {
                            int selection;
                            System.out.println(MintColorCode+"Congratulations! Access granted. You're in! \uD83C\uDF89"+whiteColorCode);
                            Functions.greetings(info);
                            boolean flag=true;
                            System.out.println(" ");
                            while (flag)
                            {
                                try
                                {
                                    System.out.println("1- Introduce a New Habit");
                                    System.out.println("2- Showcase Current Habits");
                                    System.out.println("3- Eliminate a Habit");
                                    System.out.println("4- Enhance Progress");
                                    System.out.println("5- Explore Activity History");
                                    System.out.println("6- Inspiring Quote of the Day");
                                    System.out.println("7- User Info");
                                    System.out.println("8- Logout and Exit");
                                    System.out.print("   Enter your choice : ");
                                    selection = input.nextInt();
                                    System.out.println(" ");
                                    if (selection == 1)
                                    {
                                        Functions.addHabit(info);
                                    }
                                    else if (selection == 2)
                                    {
                                        Functions.showHabit(info);
                                    }
                                    else if (selection == 3)
                                    {
                                        Functions.deleteHabit(info);
                                    }
                                    else if (selection == 4)
                                    {
                                        Functions.updateHabit(info);
                                    }
                                    else if (selection == 5)
                                    {
                                        Functions.showHistory(info);
                                    }
                                    else if (selection == 6)
                                    {
                                        Functions.quotes();
                                    }
                                    else if (selection == 7)
                                    {
                                        Functions.showUserInfo(info);
                                    }
                                    else if (selection == 8)
                                    {
                                        flag=false;
                                        break;
                                    }
                                    else
                                    {
                                        System.out.println(" ");
                                        System.out.println(redColorCode + "Choice Anomaly: Unrecognized Input");
                                        System.out.println(whiteColorCode);
//                                    System.out.println(brightPinkColorCode);
//                                System.out.println(resetColorCode);
                                    }
                                }
                                catch (InputMismatchException e)
                                {
//                                    System.out.println(" ");
                                    System.out.println(redColorCode + "Wrong Input");
                                    System.out.println(whiteColorCode);
                                    input.nextLine();
                                    flag=true;
                                }
                            }
                        }
                        else
                        {
                            System.out.println(" ");
                            System.out.println(redColorCode + "Credentials Clash: Authentication Aborted \uD83D\uDE15");
                            System.out.println(whiteColorCode);

//                            System.out.println(brightPinkColorCode);
                        }
                    }
                    else if (choice == 3)
                    {
                        Functions.forgetPassword();
                    }
                    else if (choice == 4)
                    {
                        input.close();
                        System.exit(0);
                        break;
                    }
                    else
                    {
                        System.out.println(" ");
                        System.out.println(redColorCode + "Choice Detonated: Unrecognized Selection");
                        System.out.println(whiteColorCode);
                    }
                }
                catch (InputMismatchException e)
                {
                    System.out.println(" ");
                    System.out.println(redColorCode + "Invalid Input");
                    System.out.println(whiteColorCode);
                    input.nextLine();
                }
            }
            }
        }