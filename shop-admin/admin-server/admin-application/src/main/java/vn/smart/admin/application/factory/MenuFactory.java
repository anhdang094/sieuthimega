package vn.smart.admin.application.factory;

import vn.smart.admin.application.dto.MenuByDateDto;
import vn.smart.admin.domain.model.MenuByDay;

public final class MenuFactory {

    private MenuFactory() {
    }

    public static MenuByDateDto mapperMenuByDateDto(MenuByDay menuByDay) {
        MenuByDateDto result = new MenuByDateDto();
        result.setId(menuByDay.getId());
        result.setLevel(menuByDay.getLevel());
        result.setText(menuByDay.getText());
        return result;
    }

}
