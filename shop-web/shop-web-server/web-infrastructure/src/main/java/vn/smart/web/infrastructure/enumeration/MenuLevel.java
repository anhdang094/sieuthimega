package vn.smart.web.infrastructure.enumeration;

public enum MenuLevel {

  NONE(0),
  ROOT(1),
  SUB(2);

  private final int level;

  MenuLevel(int level) {
    this.level = level;
  }

  public int getLevel() {
    return level;
  }

}
