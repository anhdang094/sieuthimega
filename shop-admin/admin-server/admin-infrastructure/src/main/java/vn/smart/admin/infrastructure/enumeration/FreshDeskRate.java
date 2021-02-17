package vn.smart.admin.infrastructure.enumeration;

import java.util.HashMap;

public enum FreshDeskRate {

  HAPPY(103),
  NEUTRAL(100),
  UNHAPPY(-103);

  private static final HashMap<Integer, FreshDeskRate> statusMap = new HashMap<>();

  static {
    for (FreshDeskRate status : FreshDeskRate.values()) {
      statusMap.put(status.code, status);
    }
  }

  private final int code;

  private FreshDeskRate(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public static FreshDeskRate fromValue(int value) {
    return statusMap.get(value);
  }

}
