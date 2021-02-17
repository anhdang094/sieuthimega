package vn.smart.admin.application.configuration.application;

import vn.smart.admin.application.WebApplication;
import vn.smart.admin.application.configuration.base.ApplicationInfo;

public class BeanConfig {

    public static ApplicationInfo APPLICATION_CONFIG = WebApplication.getCtx().getBean(ApplicationInfo.class);

}
