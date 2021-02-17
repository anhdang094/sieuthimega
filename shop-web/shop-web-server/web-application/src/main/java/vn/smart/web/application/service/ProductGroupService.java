package vn.smart.web.application.service;

import org.springframework.data.domain.Page;
import vn.smart.web.domain.model.GroupMenu;

import java.util.List;

public interface ProductGroupService {

    /**
     * findAllByType
     * @param filter
     * @return
     */
    List<GroupMenu> findAllByType(String filter);

    /**
     * getAllProductInGroup
     * @param filter
     * @param page
     * @param pageSize
     * @return
     */
    Page<?> getAllProductInGroup(String filter, int page, int pageSize);

}
