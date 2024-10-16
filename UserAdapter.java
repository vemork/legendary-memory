import java.util.ArrayList;

public class UserAdapter implements IAuthenticator {

  public UserAdapter(User userLegacy) {
  }

  @Override
  public boolean handleAuthentication(String username, String password) {
    System.out.println("New authentication service process ... " + username);
    return password.length() > 6;
  }
}