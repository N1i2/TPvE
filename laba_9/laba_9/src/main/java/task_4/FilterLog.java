package task_4;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;

public class FilterLog implements Filter {
    private FilterConfig filterConfigObj = null;
    static {
        new DOMConfigurator().doConfigure("D:/univer/TPvE/laba_9(-)/laba_/log/log.xml", LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(FilterLog.class);
    public void init(FilterConfig config) throws ServletException {
        this.filterConfigObj = config;
    }

    public void destroy() {
        filterConfigObj = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String remoteAddress =  request.getRemoteAddr();
        String uri = ((HttpServletRequest) request).getRequestURI();
        String protocol = request.getProtocol();

        chain.doFilter(request, response);
        LOG.info("Logging Filter Servlet called");
        LOG.info("=====================================================================");
        LOG.info("User Logged! User IP: " + remoteAddress +
                " Resource File: " + uri + " Protocol: " + protocol);
    }
}
