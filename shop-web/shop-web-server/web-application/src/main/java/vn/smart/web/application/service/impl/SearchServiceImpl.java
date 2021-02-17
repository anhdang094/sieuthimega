package vn.smart.web.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.smart.web.application.service.SearchService;
import vn.smart.web.domain.model.Search;
import vn.smart.web.domain.repository.SearchRepository;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Override
    public List<Search> getMenuSearch() {
        return searchRepository.findAll();
    }
}
