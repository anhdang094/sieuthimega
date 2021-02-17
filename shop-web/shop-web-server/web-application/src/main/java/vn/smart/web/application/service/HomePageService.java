package vn.smart.web.application.service;

import org.springframework.stereotype.Service;
import vn.smart.web.application.dto.MenuByDateDto;
import vn.smart.web.domain.model.*;

import java.util.List;

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

    /**
     * getAllCollection
     * @return
     */
    List<Collection> getAllCollection();

    /**
     * loadQuickDeal
     * @return
     */
    List<QuickDeal> loadQuickDeal();

    /**
     * loadHomeBasicProduct
     * @return
     */
    List<HomeBasicProduct> loadHomeBasicProduct(Integer type);
}
