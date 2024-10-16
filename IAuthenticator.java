public interface IAuthenticator {
  boolean handleAuthentication(String username, String password);
}
