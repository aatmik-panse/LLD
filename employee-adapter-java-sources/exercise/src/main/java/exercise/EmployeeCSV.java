package exercise;

import java.util.Objects;

public final class EmployeeCSV {
  private final String csvRow;
  public EmployeeCSV(String csvRow) { this.csvRow = Objects.requireNonNull(csvRow); }
  public String getCsvRow() { return csvRow; }

  public String[] tokens() {
    return csvRow.split("\\s*,\\s*");
  }

  public String getId() {
    return tokens()[0];
  }

  public String getFirstName() {
    return tokens()[1];
  }

  public String getLastName() {
    return tokens()[2];
  }

  public String getEmail() {
    return tokens()[3];
  }
}
