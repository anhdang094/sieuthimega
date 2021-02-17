package vn.smart.web.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.smart.web.application.cache.*;
import vn.smart.web.application.dto.MenuByDateDto;
import vn.smart.web.application.service.HomePageService;
import vn.smart.web.domain.model.*;
import vn.smart.web.infrastructure.enumeration.HomeProductType;
import vn.smart.web.infrastructure.enumeration.MenuLevel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static vn.smart.web.application.factory.MenuFactory.mapperMenuByDateDto;

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

    @Autowired
    private CollectionCache collectionCache;

    @Autowired
    private QuickDealCache quickDealCache;

    @Autowired
    private HomeBasicCache homeBasicCache;

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

    @Override
    public List<Collection> getAllCollection() {
        return collectionCache.findAll();
    }

    @Override
    public List<QuickDeal> loadQuickDeal() {
        return quickDealCache.findAll();
    }

    @Override
    public List<HomeBasicProduct> loadHomeBasicProduct(Integer type) {
        switch (HomeProductType.fromValue(type)) {
            case BASE:
                return homeBasicCache.findBaseProduct();
            case HOT:
                return homeBasicCache.findHotProduct();
            case FORYOU:
                return homeBasicCache.findForUProduct();
        }
        return homeBasicCache.findAll();
    }
}
