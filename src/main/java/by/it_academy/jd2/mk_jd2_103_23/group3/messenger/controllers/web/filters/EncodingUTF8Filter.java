package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import javax.xml.crypto.dsig.spec.XPathType;
import java.io.IOException;

@WebFilter(urlPatterns = {"/"})
public class EncodingUTF8Filter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request,response);
    }
}
