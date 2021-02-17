package vn.smart.web.infrastructure.utils;

public class FreshDeskUtils {

  public static String addHeaderTrans(long transID) {
    if (transID != 0) {
      return "";
    } else {
      return " ( Mã giao dịch: " + transID + " ) ";
    }
  }

  public static String addMoreInforToDecription(String description, String userID, long transID, String ticketPhone, String service) {
    String desciptionWithInfo = "";
    if (!StringUtils.isEmpty(userID)) {
       desciptionWithInfo += "+ UserID: " + userID + "<br><br>";
    }
    if (transID != 0) {
       desciptionWithInfo += "+ TransID: " + transID + "<br><br>";
    }
    if (!StringUtils.isEmpty(ticketPhone)) {
      desciptionWithInfo += "+ Số điện thoại liên lạc: " + ticketPhone + "<br><br>";
    }
    if (!StringUtils.isEmpty(service)) {
      desciptionWithInfo += "+ Dịch vụ: " + service + "<br><br>";
    }
    desciptionWithInfo += "+ Mô tả: <br><br>   " + description;
    return desciptionWithInfo;

  }

}
