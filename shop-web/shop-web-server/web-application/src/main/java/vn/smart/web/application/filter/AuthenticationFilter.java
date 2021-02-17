package vn.smart.web.application.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import vn.smart.web.application.configuration.base.AccessInfo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    private AccessInfo accessInfo;

    public AuthenticationFilter(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        String servletPath = "/".equals(accessInfo.getServletPath()) ? "" : accessInfo.getServletPath();
        String apiKey = req.getHeader("apiKey");
        if (req.getMethod().equals("OPTIONS")) {
            chain.doFilter(req, response);
        } else if (accessInfo.getEnv().equals("development") && (requestURI.equals(servletPath + "/swagger-ui.html") || requestURI
                .startsWith(servletPath + "/webjars/")
                || requestURI.equals(servletPath + "/configuration/ui") || requestURI
                .equals(servletPath + "/swagger-resources")
                || requestURI.equals(servletPath + "/v2/api-docs") || requestURI
                .equals(servletPath + "/configuration/security"))) {
            chain.doFilter(req, response);
        } else if (requestURI.startsWith(servletPath + "/api")) {
            if (apiKey != null && !apiKey.isEmpty() && accessInfo.getApiKeys().contains(apiKey)) {
                chain.doFilter(req, response);
            } else {
                HttpServletResponse resp = (HttpServletResponse) response;
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        } else {
            chain.doFilter(req, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}
