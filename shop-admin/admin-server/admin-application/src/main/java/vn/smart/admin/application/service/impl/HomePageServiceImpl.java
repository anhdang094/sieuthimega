package vn.smart.admin.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.smart.admin.application.cache.BestBuyCache;
import vn.smart.admin.application.cache.MenuByDateCache;
import vn.smart.admin.application.cache.MenuCache;
import vn.smart.admin.application.cache.SlideCache;
import vn.smart.admin.application.dto.MenuByDateDto;
import vn.smart.admin.application.service.HomePageService;
import vn.smart.admin.domain.model.BestBuy;
import vn.smart.admin.domain.model.Menu;
import vn.smart.admin.domain.model.MenuByDay;
import vn.smart.admin.domain.model.Slide;
import vn.smart.admin.infrastructure.enumeration.MenuLevel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static vn.smart.admin.application.factory.MenuFactory.mapperMenuByDateDto;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private MenuCache menuCache;

    @Autowired
    private SlideCache slideCache;

    @Autowired
    private MenuByDateCache menuByDateCache;

    @Autowired
    private BestBuyCache bestBuyCache;

    @Override
    public List<Menu> getMenu() {
        return menuCache.getAllMenu();
    }

    @Override
    public List<Slide> getSlide() {
        return slideCache.getAllSlide();
    }

    @Override
    public List<MenuByDateDto> getMenuByDay() {
        List<MenuByDay> menuByDays = menuByDateCache.getAllMenuByDate();
        Map<Integer, MenuByDateDto> map = new HashMap<>();
        List<MenuByDateDto> result = new LinkedList<>();
        menuByDays.stream().forEach(item -> {
            if (item.getLevel() == MenuLevel.ROOT.getLevel()) {
                MenuByDateDto mapObj = mapperMenuByDateDto(item);
                mapObj.setUrl(item.getParentUrl());
                result.add(mapObj);
            }
            if (item.getLevel() == MenuLevel.SUB.getLevel()) {
                MenuByDateDto mapObj = mapperMenuByDateDto(item);
                mapObj.setUrl(item.getSubUrl());
                map.put(item.getParentId(), mapObj);
            }
        });
        result.stream().forEach(item -> {
            if (item.getLevel() == MenuLevel.ROOT.getLevel()) {
                item.setSubMenu(map.get(item.getId()));
            }
        });
        return result;
    }

    @Override
    public List<BestBuy> getAllBestBuy() {
        return bestBuyCache.getAllBestBuy();
    }
}
