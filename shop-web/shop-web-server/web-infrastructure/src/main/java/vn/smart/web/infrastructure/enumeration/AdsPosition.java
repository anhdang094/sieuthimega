package vn.smart.web.infrastructure.enumeration;

import java.util.HashMap;

public enum AdsPosition {

  HEADER(1),
  LEFT(2),
  RIGHT(3),
  CAMERA(4),
  CHO_DOCU(5),
  GIAY_TUIXACH(6),
  LINHKIEN_MAYTINH(7),
  ME_VA_BE(8),
  NHA_BEP(9),
  NOITHAT_GIADUNG(10),
  THIETBI_DIENTU(11),
  THOITRANG_NAM(12),
  THOITRANG_NU(13);

  private static final HashMap<Integer, AdsPosition> AdsMap = new HashMap<>();

  static {
    for (AdsPosition status : AdsPosition.values()) {
      AdsMap.put(status.code, status);
    }
  }

  private final int code;

  private AdsPosition(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public static AdsPosition fromValue(int value) {
    return AdsMap.get(value);
  }

}
