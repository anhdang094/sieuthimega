package vn.smart.web.application.factory;

import vn.smart.web.application.dto.MenuByDateDto;
import vn.smart.web.domain.model.MenuByDay;

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
