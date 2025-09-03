package exercise;

public final class EmployeeDB {
  private final int id;
  private final String firstName;
  private final String surname;
  private final String emailAddress;

  public EmployeeDB(int id, String firstName, String surname, String emailAddress) {
    this.id = id; this.firstName = firstName; this.surname = surname; this.emailAddress = emailAddress;
  }
  public int getId() { return id; }
  public String getFirstName() { return firstName; }
  public String getSurname() { return surname; }

  public String getEmailAddress() {
    return emailAddress;
  }
  
  public String getEmail() {
    return getEmailAddress();
  }

  public String getFullName() {
    return getFirstName() + " " + getSurname();
  }

  public String getJobTitle() {
    return "Employee";
  }

  public String getLastName() {
    return getSurname();
  }
}
