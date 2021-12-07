package fr.lernejo.todo;

import org.springframework.stereotype.Component;
import java.util.UUID;
import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

@Component
public class ApplicationIdentifierFilter implements Filter {
    private String uuid;
    //constructeur
    public ApplicationIdentifierFilter() {
        uuid = UUID.randomUUID().toString();

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("Instance-Id", this.uuid);
        filterChain.doFilter(servletRequest, httpServletResponse);
    }
}
