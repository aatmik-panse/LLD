package exercise;

import java.util.*;

public class Client {
  public static void main(String[] args) {
    // Sample legacy data from three sources
    List<EmployeeCSV> csvRows = List.of(
        new EmployeeCSV("101,John,Doe,john.doe@acme.com"),
        new EmployeeCSV("102,Sarah,Lee,sarah.lee@acme.com"));

    List<EmployeeDB> dbRows = List.of(
        new EmployeeDB(201, "Ravi", "Kumar", "ravi.kumar@contoso.com"),
        new EmployeeDB(202, "Anita", "Sharma", "anita.sharma@contoso.com"));

    List<EmployeeLDAP> ldapRows = List.of(
        new EmployeeLDAP(Map.of("uid", "301", "givenName", "Wei", "sn", "Zhang", "mail", "wei.zhang@example.org")),
        new EmployeeLDAP(
            Map.of("uid", "302", "givenName", "Elena", "sn", "Garcia", "mail", "elena.garcia@example.org")));

    // TODO: Wrap each legacy object with the right adapter and collect into one list

    // Did this like made Adapters 

    List<IEmployee> all = new ArrayList<>();

    for (EmployeeCSV csv : csvRows) {
      all.add(new EmployeeCSVAdapter(csv));
    }

    for (EmployeeDB db : dbRows) {
      all.add(new EmployeeDBAdapter(db));
    }

    for (EmployeeLDAP ldap : ldapRows) {
      all.add(new EmployeeLDAPAdapter(ldap));
    }

    EmployeePrinter.print(all);
  }
}


interface IAdapter {
  String getId();
  String getFirstName();
  String getLastName();
  String getEmail();
}

class EmployeeCSVAdapter implements IEmployee {
  private final EmployeeCSV csv;

  public EmployeeCSVAdapter(EmployeeCSV csv) {
    this.csv = csv;
  }

  @Override
  public String getId() {
    return csv.getId();
  }

  @Override
  public String getFirstName() {
    return csv.getFirstName();
  }

  @Override
  public String getLastName() {
    return csv.getLastName();
  }

  @Override
  public String getEmail() {
    return csv.getEmail();
  }
}

class EmployeeDBAdapter implements IEmployee{
  private final EmployeeDB db;

  public EmployeeDBAdapter(EmployeeDB db) {
    this.db = db;
  }

  @Override
  public String getId() {
    return String.valueOf(db.getId());
  }

  @Override
  public String getFirstName() {
    return db.getFirstName();
  }

  @Override
  public String getLastName() {
    return db.getLastName();
  }

  @Override
  public String getEmail() {
    return db.getEmail();
  }
}

class EmployeeLDAPAdapter implements IAdapter , IEmployee {
  private final EmployeeLDAP ldap;

  public EmployeeLDAPAdapter(EmployeeLDAP ldap) {
    this.ldap = ldap;
  }

  @Override
  public String getId() {
    return ldap.getId();
  }

  @Override
  public String getFirstName() {
    return ldap.getFirstName();
  }

  @Override
  public String getLastName() {
    return ldap.getLastName();
  }

  @Override
  public String getEmail() {
    return ldap.getEmail();
  }
}