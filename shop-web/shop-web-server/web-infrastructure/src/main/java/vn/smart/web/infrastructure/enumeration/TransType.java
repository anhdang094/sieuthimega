package vn.smart.web.infrastructure.enumeration;

public enum TransType {
  UNKNOW(0),
  CHARGE(1),
  RECHARGE(2),
  TRANSFER_CASH(3),
  WITH_DRAWAL(4);


  private final int type;

  private TransType(int type) {
    this.type = type;
  }

  public int getType() {
    return type;
  }
}
