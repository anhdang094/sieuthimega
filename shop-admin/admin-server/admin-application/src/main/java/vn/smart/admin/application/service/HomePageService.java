package vn.smart.admin.application.service;

import org.springframework.stereotype.Service;
import vn.smart.admin.application.dto.MenuByDateDto;
import vn.smart.admin.domain.model.BestBuy;
import vn.smart.admin.domain.model.Menu;
import vn.smart.admin.domain.model.Slide;

import java.util.List;

@Service
public interface HomePageService {

    /**
     * get menu
     *
     * @return
     */
    List<Menu> getMenu();

    /**
     * get slide
     *
     * @return
     */
    List<Slide> getSlide();

    /**
     * get menu by day
     *
     * @return
     */
    List<MenuByDateDto> getMenuByDay();

    /**
     * get best buy
     *
     * @return
     */
    List<BestBuy> getAllBestBuy();
}
