package vn.smart.web.infrastructure.enumeration;

public enum ResponseMessage {
  SUCCESS(1);

  private final int code;

  private ResponseMessage(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
