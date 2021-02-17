package vn.smart.web.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.smart.web.application.service.ConfigService;
import vn.smart.web.application.service.EvalutionService;
import vn.smart.web.domain.model.Comment;
import vn.smart.web.domain.repository.CommentRepository;
import vn.smart.web.domain.repository.FeedbackRepository;

import static vn.smart.web.application.factory.FeedbackFactory.generateNewFeeback;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private Environment env;

    @Override
    public long getDefaultFee() {
        return Long.valueOf(env.getProperty("app.default-fee"));
    }
}
