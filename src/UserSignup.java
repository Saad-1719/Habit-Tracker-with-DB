//public class UserSignup
//{
//    private String username;
//    private String password;
//    private String firstName;
//    private String lastName;
//    private float height;
//    private int age;
//
//    public UserSignup(String username)
//    {
//        this.username = username;
//    }
//
//    public UserSignup(String username, String password, String firstName, String lastName, float height, int age)
//    {
//        this.username = username;
//        this.password = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.height = height;
//        this.age = age;
//    }
//
//    public String getFirstName()
//    {
//        return firstName;
//    }
//
//    public String getLastName()
//    {
//        return lastName;
//    }
//
//    public float getHeight()
//    {
//        return height;
//    }
//
//    public int getAge()
//    {
//        return age;
//    }
//
//    public String getUsername()
//    {
//        return username;
//    }
//
//    public String getPassword()
//    {
//        return password;
//    }
//}
public class UserSignup extends UserLogin
{
    private String firstName;
    private String lastName;
    private int age;

    public UserSignup(String username, String password, String firstName, String lastName, int age)
    {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public UserSignup(String username)
    {
        super(username);
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getAge()
    {
        return age;
    }
}