package vn.smart.web.application.configuration.application;

import vn.smart.web.application.WebApplication;
import vn.smart.web.application.configuration.base.ApplicationInfo;

public class BeanConfig {

    public static ApplicationInfo APPLICATION_CONFIG = WebApplication.getCtx().getBean(ApplicationInfo.class);

}
