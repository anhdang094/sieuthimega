package vn.smart.admin.infrastructure.enumeration;

public enum IssueType {
  ANOTHER(0),
  SUCCESS(1),
  FAIL(2);

  private final int type;

  private IssueType(int type) {
    this.type = type;
  }

  public int getType() {
    return type;
  }
}
