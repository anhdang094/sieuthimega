package vn.smart.web.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.smart.web.application.service.PromotionService;
import vn.smart.web.domain.model.Promotion;
import vn.smart.web.domain.repository.PromotionRepository;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public List<Promotion> getAllPromotionActive() {
        return promotionRepository.findAllByIsActive(1);
    }
}
