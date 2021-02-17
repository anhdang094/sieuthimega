package vn.smart.web.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.smart.web.application.service.MerchantService;
import vn.smart.web.domain.model.Merchant;
import vn.smart.web.domain.repository.MerchantRepository;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public Merchant findMerchantInfor(int merchantId) {
        return merchantRepository.findFirstById(merchantId);
    }
}
