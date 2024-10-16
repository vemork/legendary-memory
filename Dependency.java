import java.util.ArrayList;
import java.util.List;

public class Dependency {
  private final String dependencyname;
  private final List<Dependency> branches;
  private final List<User> users;

  public Dependency(String name) {
    this.dependencyname = name;
    this.branches = new ArrayList<>();
    this.users = new ArrayList<>();
  }

  public void addBranch(Dependency branch) {
    branches.add(branch);
  }

  public void addUser(User user) {
    users.add(user);
  }

  public List<User> getUsers() {
    return users;
  }



  public void printStructure(String label) {
    System.out.println(label + dependencyname);
    for (User user : users) {
      System.out.println("  User: " + user.getFirstname() + " " + user.getLastname());
    }
    for (Dependency unit : branches) {
      unit.printStructure("Branch: ");
    }
  }
}