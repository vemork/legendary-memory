import java.util.List;
import javax.swing.text.AbstractDocument.BranchElement;

public class Main {
  public static void main(String[] args) {
    User legacyUser1 = new User("Doyler", "Rubio", "doyrub", "pass1234");
    User legacyUser2 = new User("Devisson", "Vasquez", "devvas", "dev123");

    UserAdapter uadptr1 = new UserAdapter(legacyUser1);
    UserAdapter uadptr2 = new UserAdapter(legacyUser2);

    Dependency mainOffice = new Dependency("Main Office");
    Dependency financialOffice = new Dependency("Financial office");
    Dependency itOffice = new Dependency("IT office");
    Dependency itBranch = new Dependency("Technical office");

    mainOffice.addBranch(financialOffice);
    mainOffice.addBranch(itOffice);
    itOffice.addBranch(itBranch);

    financialOffice.addUser(legacyUser1);
    itBranch.addUser(legacyUser2);

    if (uadptr1.handleAuthentication("doyrub", "pass1234")) {
      System.out.println("User Doyler Rubio successfully authenticated.");
    } else {
      System.out.println("Fail trying to attempt the authentication process.");
    }

    if (uadptr2.handleAuthentication("devvas", "ana123")) {
      System.out.println("User Devisson Vasquez successfully authenticated.");
    } else {
      System.out.println("Fail trying to attempt Devisson Vasquez's authentication process.");
    }

    // Get all users in a main office
    List<User> allUsers = mainOffice.getUsers();
    for (User user : allUsers) {
      System.out.println(user.getFirstname() + " " + user.getLastname());
    }

    // Print dependencies
    mainOffice.printStructure("Office: ");
  }
}

