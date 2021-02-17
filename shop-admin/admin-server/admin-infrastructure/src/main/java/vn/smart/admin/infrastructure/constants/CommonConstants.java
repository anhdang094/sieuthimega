package vn.smart.admin.infrastructure.constants;

public abstract class CommonConstants {

  public static final int MAX_IMAGE_NAME = 45;

  public static final int MAX_QUEUE_COUTER = 3;

  public static final String IMAGE_PATH = "image";

  public static final String CS_AUTHOR = "CS_ZaloPay";

  public static final String TICKET_QUEUE_NAME = "zalopayticket_ticketQueue";

  public static final String COMMENT_QUEUE_NAME = "zalopayticket_commentQueue";

  public static final String RATE_QUEUE_NAME = "zalopayticket_rateQueue";

  //fresdesk field
  public static final String FRESHDESK_NAME = "name";
  public static final String FRESHDESK_CHOICES = "choices";
  public static final String FRESHDESK_TYPE = "ticket_type";
  public static final String FRESHDESK_GROUP = "group";
  public static final String FRESHDESK_PIORITY = "priority";
  public static final String FRESHDESK_STATUS = "status";

  //message
  public static final String NOTIFY_TITLE = "Hỗ trợ";
  public static final String NOTIFY_MESSAGE = "Bộ phận hỗ trợ đã phản hồi cho vấn đề \"%s\" của bạn";

  //email
  public static final String EMAIL_SUBJECT = "Lỗi freshdesk cho Ticket In APP";
  public static final String EMAIL_CONTENT = "%s inapp không thể đẩy freshdesk, lỗi %s";
}
