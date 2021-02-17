package vn.smart.web.infrastructure.enumeration;

import java.util.HashMap;

public enum MenuType {

    CAMERA(4, "camera"),
    CHO_DOCU(5, "chodocu"),
    GIAY_TUIXACH(6, "giaytuixach"),
    LINHKIEN_MAYTINH(7, "linhkienmaytinh"),
    ME_VA_BE(8, "mevabe"),
    NHA_BEP(9, "nhabep"),
    NOITHAT_GIADUNG(10, "noithatgiadung"),
    THIETBI_DIENTU(11, "thietbidientu"),
    THOITRANG_NAM(12, "thoitrangnam"),
    THOITRANG_NU(13, "thoitrangnu");

    private static final HashMap<Integer, MenuType> typeMaps = new HashMap<>();
    private static final HashMap<String, MenuType> messageMaps = new HashMap<>();

    static {
        for (MenuType type : MenuType.values()) {
            typeMaps.put(type.code, type);
            messageMaps.put(type.message, type);
        }
    }

    private final int code;
    private final String message;

    MenuType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static MenuType fromValue(int value) {
        return typeMaps.get(value);
    }

    public static MenuType fromMessage(String message) {
        return messageMaps.get(message);
    }

}
