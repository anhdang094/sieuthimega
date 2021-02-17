package vn.smart.web.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.smart.web.application.cache.GroupMenuCache;
import vn.smart.web.application.service.ProductGroupService;
import vn.smart.web.domain.model.GroupMenu;
import vn.smart.web.domain.model.menu.ThietBiDienTu;
import vn.smart.web.domain.repository.menu.*;
import vn.smart.web.infrastructure.enumeration.MenuType;
import vn.smart.web.infrastructure.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anhdx
 */
@Service
public class ProductGroupServiceImpl implements ProductGroupService {

    private final GroupMenuCache groupMenuCache;

    private final ThietBiDienTuRepository thietBiDienTuRepository;

    private final CameraRepository cameraRepository;

    private final ChodocuRepository chodocuRepository;

    private final GiaytuixachRepository giaytuixachRepository;

    private final MaytinhRepository maytinhRepository;

    private final MevaBeRepository mevaBeRepository;

    private final NhabepRepository nhabepRepository;

    private final NoithatGiadungRepository noithatGiadungRepository;

    private final ThoitrangNamRepository thoitrangNamRepository;

    private final ThoitrangNuRepository thoitrangNuRepository;

    @Autowired
    public ProductGroupServiceImpl(CameraRepository cameraRepository, GroupMenuCache groupMenuCache,
                                   ThietBiDienTuRepository thietBiDienTuRepository, ChodocuRepository chodocuRepository,
                                   GiaytuixachRepository giaytuixachRepository, MaytinhRepository maytinhRepository,
                                   MevaBeRepository mevaBeRepository, NhabepRepository nhabepRepository,
                                   NoithatGiadungRepository noithatGiadungRepository, ThoitrangNamRepository thoitrangNamRepository,
                                   ThoitrangNuRepository thoitrangNuRepository) {
        this.cameraRepository = cameraRepository;
        this.groupMenuCache = groupMenuCache;
        this.thietBiDienTuRepository = thietBiDienTuRepository;
        this.chodocuRepository = chodocuRepository;
        this.giaytuixachRepository = giaytuixachRepository;
        this.maytinhRepository = maytinhRepository;
        this.mevaBeRepository = mevaBeRepository;
        this.nhabepRepository = nhabepRepository;
        this.noithatGiadungRepository = noithatGiadungRepository;
        this.thoitrangNamRepository = thoitrangNamRepository;
        this.thoitrangNuRepository = thoitrangNuRepository;
    }

    @Override
    public List<GroupMenu> findAllByType(String filter) {
        if (!StringUtils.isEmpty(filter)) {
            return groupMenuCache.findAllByType(MenuType.fromMessage(filter));
        }
        return new ArrayList<>();
    }

    @Override
    public Page<?> getAllProductInGroup(String filter, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        switch (MenuType.fromMessage(filter)) {
            case CAMERA:
                return cameraRepository.findAll(pageable);
            case NHA_BEP:
                return nhabepRepository.findAll(pageable);
            case CHO_DOCU:
                return chodocuRepository.findAll(pageable);
            case ME_VA_BE:
                return mevaBeRepository.findAll(pageable);
            case GIAY_TUIXACH:
                return giaytuixachRepository.findAll(pageable);
            case THOITRANG_NU:
                return thoitrangNuRepository.findAll(pageable);
            case THOITRANG_NAM:
                return thoitrangNamRepository.findAll(pageable);
            case THIETBI_DIENTU:
                return thietBiDienTuRepository.findAll(pageable);
            case NOITHAT_GIADUNG:
                return noithatGiadungRepository.findAll(pageable);
            case LINHKIEN_MAYTINH:
                return maytinhRepository.findAll(pageable);
            default:
                return null;
        }
    }
}
