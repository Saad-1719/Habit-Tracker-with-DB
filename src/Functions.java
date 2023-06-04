import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Functions
{
    //        String resetColorCode = "\u001B[0m";
    static Scanner input = new Scanner(System.in);
    static LocalTime currentTime = LocalTime.now();
    static String username;
    static String createPassword;
    static String firstName;
    static String lastName;
    static int age = 0;
    static boolean flag;
    //    static String whiteColorCode = "\u001B[97m";
    static String whiteColorCode = "\u001B[90m";
    static String redColorCode = "\u001B[31m";
    static String MintColorCode = "\u001B[92m";

    // to add new user
    public static void createUserName()
    {
        do
        {
            System.out.print("Enter a username : ");
            username = input.nextLine();
            if (username.length() < 4)
            {
                System.out.println(redColorCode + "Error: Ensure that your username has a minimum of 4 characters." + whiteColorCode);
                signup(); //bug fixed
            }
            else if (username.contains(" "))
            {
                System.out.println(redColorCode + "Error: Ensure that no spaces are included." + whiteColorCode);
                signup();//bug fixed
            }
            else
            {
                for (int i = 0; i < username.length(); i++)
                {
                    if ((username.charAt(i) >= 'A') && (username.charAt(i) <= 'Z'))
                    {
                        System.out.println(redColorCode + "Error: Ensure that your username is written in lowercase letters." + whiteColorCode);
                        signup();//bug fixed
                        break;
                    }
                }
            }
            UserSignup info = new UserSignup(username);
            boolean answer = SignUpIntoDB.userCheck(info);
            if (answer)
            {
                System.out.println(redColorCode + "Error: Username Unavailable." + whiteColorCode);
                flag = true;
            }
            else
            {
                System.out.println(MintColorCode + "Username Added!" + whiteColorCode);
                input.close();
                flag = false;
            }
        } while (flag);
    }

    public static void introducePassword()
    {
        do
        {
            flag = false;
            System.out.print("Create a password : ");
            createPassword = input.nextLine();
            int password_length = createPassword.length();
            if (password_length < 5)
            {
                System.out.println(redColorCode + "Error: Ensure that your password has a minimum of 5 characters." + whiteColorCode);
//                System.out.println("Please enter it again");
                flag = true;
            }
            for (int i = 0; i < password_length; i++)
            {
                if (Character.isWhitespace(createPassword.charAt(i)))
                {
                    System.out.println(redColorCode + "Error: Ensure that no spaces are included." + whiteColorCode);
                    flag = true;
                }
            }
        } while (flag);
        System.out.println(MintColorCode + "Password Added" + whiteColorCode);
        input.close();
    }

    public static void introduceFirstName()
    {
        do
        {
            flag = false;
            System.out.print("Enter First name : ");
            firstName = input.nextLine();
            if (firstName.isBlank())
            {
                System.out.println(redColorCode + "Error: First Name isn't entered." + whiteColorCode);
                flag = true;
            }
            for (int i = 0; i < firstName.length(); i++)
            {
                if (Character.isWhitespace(firstName.charAt(i)))
                {
                    System.out.println(redColorCode + "Error: Ensure that no spaces are included." + whiteColorCode);
                    flag = true;
                    break;
                }
                if ((firstName.charAt(i) >= 'A') && (firstName.charAt(i) <= 'Z'))
                {
                    System.out.println(redColorCode + "Error: Ensure that your first name is written in lowercase letters." + whiteColorCode);
                    flag = true;
                    break;
                }
            }
        } while (flag);
        System.out.println(MintColorCode + "First Name Added" + whiteColorCode);
        input.close();
    }

    public static void introduceLastName()
    {
        do
        {
            flag = false;
            System.out.print("Enter Last name : ");
            lastName = input.nextLine();
            if (lastName.isBlank())
            {
                System.out.println(redColorCode + "Error: Last Name isn't entered." + whiteColorCode);
                flag = true;
            }
            for (int i = 0; i < lastName.length(); i++)
            {
                if (Character.isWhitespace(lastName.charAt(i)))
                {
                    System.out.println(redColorCode + "Error: Ensure that no spaces are included." + whiteColorCode);
                    flag = true;
                    break;
                }
                if ((lastName.charAt(i) >= 'A') && (lastName.charAt(i) <= 'Z'))
                {
                    System.out.println(redColorCode + "Error: Ensure that your last name is written in lowercase letters." + whiteColorCode);
                    flag = true;
                    break;
                }
            }
        } while (flag);
        System.out.println(MintColorCode + "Last Name Added" + whiteColorCode);
        input.close();
    }

    public static void introduceAge()
    {
        do
        {
            System.out.print("Enter Age : ");
            try
            {
                age = input.nextInt();
                if (age < 5 || age > 200)
                {
                    System.out.println(redColorCode + "Error: Ensure that a valid value is entered." + whiteColorCode);
                    flag = true;
                }
                else
                {
                    flag = false;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println(redColorCode + "Error: Invalid Input.Please enter a valid integer value" + whiteColorCode);
                input.nextLine();
                flag = true;
            }
        } while (flag);
        System.out.println(MintColorCode + "Age Added" + whiteColorCode);
        input.close();
    }

    public static void signup()
    {
        createUserName();
        input.nextLine();
        introducePassword();
        introduceFirstName();
        introduceLastName();
        introduceAge();
        UserSignup info = new UserSignup(username, createPassword, firstName, lastName, age);
        boolean answer = SignUpIntoDB.signUp(info);
        if (answer)
        {
            System.out.println(MintColorCode + "Completed! Thank you for Signing up :)" + whiteColorCode);
            input.close();
            Main.main(new String[]{});
        }
        else
        {
            System.out.println(redColorCode + "Something went wrong :(" + whiteColorCode);
        }
    }
    // to forget password

    public static void forgetPassword()
    {
        System.out.println("Press any key to begin");
        input.nextLine();
        System.out.print("Enter a username: ");
        username = input.nextLine();
        System.out.print("Enter First name: ");
        firstName = input.nextLine();
        System.out.print("Enter Last name: ");
        lastName = input.nextLine();
        System.out.print("Enter Age: ");
        age = input.nextInt();
        input.nextLine();
        boolean chk = password.matchInfo(username, firstName, lastName, age);
        if (chk)
        {
            System.out.println(MintColorCode + "Credentials have been matched." + whiteColorCode);
            introducePassword();
            boolean isUpdated;
            isUpdated = password.updatePassword(username, createPassword, firstName, lastName, age);
            if (isUpdated)
            {
                System.out.println(MintColorCode + "Completed, Password has been updated." + whiteColorCode);
                input.close();
            }
            else
            {
                System.out.println(MintColorCode + "Error: Data not updated." + whiteColorCode);
            }
        }
        else
        {
            System.out.println(redColorCode + "Error: Credentials have not been matched." + whiteColorCode);
        }
    }

    // to add a habit into db
    public static void addHabit(UserLogin info)
    {
        String name;
        String description;
        String goal;
        int completedDays = 0;
        String progressBar = "-----------------------------";
        boolean flag;
        Activity myActivity = new Activity("", "", "", 0, "");
        // data entry to db
        //habit name
        System.out.println("Press any key to begin ");
        input.nextLine();
        do
        {
            flag = false;
            System.out.print("What is your habit's name? ");
            name = input.nextLine();
            if (name.trim().isEmpty())
            {
                System.out.println(redColorCode + "Error: Habit name cannot be empty." + whiteColorCode);
                flag = true;
            }
            else if (name.trim().length() < 3)
            {
                System.out.println(redColorCode + "Error: Habit name must be at least 3 characters long." + whiteColorCode);
                flag = true;
            }
            else if (!name.trim().matches("[a-zA-Z0-9 ]+"))
            {
                System.out.println(redColorCode + "Error: Habit name can only contain letters, numbers, and spaces." + whiteColorCode);
                flag = true;
            }
            Database.retrieveData(info);
            for (int activityid : Database.storeActivityId)
            {
                ArrayList<String> activityName = Database.storeActivityName;
                if (activityName.contains(name))
                {
                    System.out.println(redColorCode + "Error: Habit already exists." + whiteColorCode);
                    flag = true;
                    break;
                }
            }
        } while (flag);
        //habit description
        do
        {
            flag = false;
            System.out.print("What is your habit's description? ");
            description = input.nextLine();
            if (description.trim().isEmpty())
            {
                System.out.println(redColorCode + "Error: Habit description cannot be empty." + whiteColorCode);
                flag = true;
            }
            else if (description.trim().length() < 5)
            {
                System.out.println(redColorCode + "Error: Habit description must be at least 5 characters long." + whiteColorCode);
                flag = true;
            }
        } while (flag);
        //habit goal
        do
        {
            flag = false;
            System.out.print("What is your goal? ");
            goal = input.nextLine();
            if (goal.trim().isEmpty())
            {
                System.out.println(redColorCode + "Error: Habit goal cannot be empty." + whiteColorCode);
                flag = true;
            }
            else if (goal.trim().length() < 5)
            {
                System.out.println(redColorCode + "Error: Habit goal must be at least 5 characters long." + whiteColorCode);
                flag = true;
            }
        } while (flag);
        myActivity.setName(name);
        myActivity.setDescription(description);
        myActivity.setGoal(goal);
        myActivity.setCompletedDays(completedDays);
        myActivity.setProgressBar(progressBar);
        boolean ckh = Database.writeData(myActivity, info);
        if (ckh)
        {
            System.out.println(MintColorCode + "Completed, Data Added!" + whiteColorCode);
            input.close();
        }
        else
        {
            System.out.println(redColorCode + "Error: Something went wrong" + whiteColorCode);
        }
    }

    // to update existing habit
    public static void updateHabit(UserLogin info)
    {
       // Database.retrieveData(info);
        int userId = Database.activeUserId(info);
        boolean chk1 = Database.displayDataForOtherOption(info);
        if (!chk1)
        {
            String progressBar = "-----------------------------";
            int completedDays;
            int habitId;
            String achievement;
            input.nextLine();
            System.out.print("Enter id of habit you want to update = ");
            try
            {
                habitId = input.nextInt();
                input.nextLine();
//            System.out.println("current days : "+c);
                boolean found = false;
                boolean flag = false;
                boolean isHabitExist = Database.checkHabitId(habitId, userId);
                if (isHabitExist)
                {
                    do
                    {
                        int c = Database.habitDays(habitId);
                        System.out.print("How many days have been completed so far? ");
                        completedDays = input.nextInt();
                        if (completedDays <= c)
                        {
                            System.out.println(redColorCode + "Error: You can't decline your progress days." + whiteColorCode);
                            flag = true;// bug fixed
                        }
                        else
                        {
                            try
                            {
                                if (completedDays >= 1 && completedDays <= 29)
                                {
                                    // input is valid.
                                    StringBuilder progressBarBuilder = new StringBuilder(progressBar);
                                    for (int i = 0; i < completedDays; i++)
                                    {
                                        progressBarBuilder.setCharAt(i, 'x');
                                    }
                                    progressBar = progressBarBuilder.toString();
                                    boolean ckh = Database.updateData(habitId, progressBar, completedDays);
                                    if (ckh)
                                    {
                                        System.out.println(MintColorCode + "Habit has been updated" + whiteColorCode);
                                    }
                                    break;
                                }
                                else if (completedDays == 30)
                                {
                                    flag = false;
//                                    System.out.println("NOTE: Minimum length should be 5 characters.");
                                    System.out.print("What are your Achievements? ");
                                    input.nextLine();
                                    achievement = input.nextLine();
                                    do
                                    {
                                        if (achievement.trim().isEmpty())
                                        {
                                            System.out.println(redColorCode + "Error: Habit achievement cannot be empty." + whiteColorCode);
                                            flag = true;
                                        }
                                        else if (achievement.trim().length() < 5)
                                        {
                                            System.out.println(redColorCode + "Error: Habit achievement must be at least 5 characters long." + whiteColorCode);
                                            flag = true;
                                        }
                                        else
                                        {
                                            String habitName = Database.habitName(habitId);
                                            Database.deleteData(habitId);
                                            Activity data = new Activity(habitName, achievement);
                                            boolean chk = Database.writeHistory(info, data);
                                            if (chk)
                                            {
                                                System.out.println(MintColorCode + "Habit has been updated." + whiteColorCode);
                                            }
                                            else
                                            {
                                                System.out.println(redColorCode + "Error: Some problem occurred." + whiteColorCode);
                                            }
                                        }
                                    } while (flag);
                                }
                                else
                                {
                                    System.out.println(redColorCode + "Error: Completed Days must range between 1 - 30." + whiteColorCode);
                                    flag = true;
                                }
                            }
                            catch (InputMismatchException e)
                            {
                                System.out.println(redColorCode + "Error: Input Error" + whiteColorCode);
                                input.nextLine();
                            }
                        }
                    } while (flag);
                    input.close();
                }
                else
                {
                    System.out.println(redColorCode + "Error: Habit ID not matched" + whiteColorCode);
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println(redColorCode + "Error: Some Error occurred" + whiteColorCode);
                input.nextLine();
            }
        }
    }

    // to show habit from db
    public static void showHabit(UserLogin info)
    {
        Database.displayData(info);
    }

    // to delete habit from db
    public static void deleteHabit(UserLogin info)
    {
        Database.retrieveData(info);
        boolean chk = Database.displayDataForOtherOption(info);
        if (!chk)
        {
            int delId;
            // data delete
            input.nextLine();
            System.out.print("ID Required for Eradication = ");
//            input.nextLine();
            delId = input.nextInt();
            int userID=Database.activeUserId(info);
            try
            {
                boolean hasHabitfound = Database.checkHabitId(delId,userID);
                    if (hasHabitfound)
                    {
                        boolean ckh = Database.deleteData(delId);
                        if (ckh)
                        {
                            System.out.println(MintColorCode + "Habit has been removed from the record" + whiteColorCode);
                        }
                    }
                else
                {
                    System.out.println(redColorCode + "Error: Habit id not matched" + whiteColorCode);
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println(redColorCode + "Error: Input Error" + whiteColorCode);
                input.nextLine();
            }
        }
    }

    //Welcome notes
    public static void greetings(UserLogin info)
    {
        if (currentTime.isBefore(LocalTime.NOON))
        {
            System.out.println("        Good Morning \uD83C\uDF04\uD83C\uDF04, " + info.getUsername() + "!");
        }
        else if (currentTime.isBefore(LocalTime.of(18, 0)))
        {
            System.out.println("        Good Afternoon \uD83C\uDF1E\uD83C\uDF1E, " + info.getUsername() + "!");
        }
        else
        {
            System.out.println("        Good Evening \uD83C\uDF06\uD83C\uDF06, " + info.getUsername() + "!");
        }
    }

    //quotes
    public static void quotes()
    {
        ArrayList<String> inspiration = new ArrayList<>();
        inspiration.add("It's the smallest actions everyday that determine who you are ...");
        inspiration.add("All big things come from small beginnings. The seed of every habit is single, tiny decision.");
        inspiration.add("Break bad habits, Build good habits.");
        inspiration.add("Habit stay with you even when you don't have the motivation.");
        inspiration.add("Good habits formed at youth make all the difference.");
        inspiration.add("Consistency is what transforms average into excellence");
        inspiration.add("Success isn't always about greatness. It's about consistency. Consistent hard work leads to success greatness will come");
        inspiration.add("Continuous improvement is better than delayed");
        Random rand = new Random();
        int randIndex = rand.nextInt(inspiration.size());
        String randomString = inspiration.get(randIndex);
        System.out.println(randomString);
    }

    public static void showHistory(UserLogin info)
    {
        Database.displayHistory(info);
    }

    public static void showUserInfo(UserLogin info)
    {
        Database.showUserInfo(info);
    }
}