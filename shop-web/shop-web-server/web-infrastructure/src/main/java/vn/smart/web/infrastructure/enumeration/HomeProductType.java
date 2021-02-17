package vn.smart.web.infrastructure.enumeration;

import java.util.HashMap;

public enum HomeProductType {

  BASE(1),
  HOT(2),
  FORYOU(3);

  private static final HashMap<Integer, HomeProductType> AdsMap = new HashMap<>();

  static {
    for (HomeProductType status : HomeProductType.values()) {
      AdsMap.put(status.code, status);
    }
  }

  private final int code;

  HomeProductType(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public static HomeProductType fromValue(int value) {
    return AdsMap.get(value);
  }

}
