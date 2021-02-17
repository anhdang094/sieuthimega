package vn.smart.admin.application.dto;

public class MenuByDateDto {

  private int id;
  private String text;
  private int level;
  private String url;
  private MenuByDateDto subMenu;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public MenuByDateDto getSubMenu() {
    return subMenu;
  }

  public void setSubMenu(MenuByDateDto subMenu) {
    this.subMenu = subMenu;
  }
}
