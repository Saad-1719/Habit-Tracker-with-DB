//public class UserLogin
//{
//    private String username;
//    private String password;
//    public UserLogin(String username, String password)
//    {
//        this.username = username;
//        this.password = password;
//    }
//    public String getUsername()
//    {
//        return username;
//    }
//    public String getPassword()
//    {
//        return password;
//    }
//}
public class UserLogin
{
    protected String username;
    protected String password;

    public UserLogin(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public UserLogin(String username)
    {
        this.username=username;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}