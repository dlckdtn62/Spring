package kr.co.fastcampus.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j//LOMBOK
public class SimpleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        log.info("Filter - Hello World");
        HttpSession session = ((HttpServletRequest)request).getSession();
        String username = (String)session.getAttribute("username");
        if(username==null) {
            log.info("new user");
            session.setAttribute("username", "Lee Chang Soo");
        }else{
            log.info("user ->" + username);
        }

        chain.doFilter(request, response);
        PrintWriter writer = response.getWriter();
        writer.println("filter - Hello World");
    }
    //나머지는 default method이므로 구현의 필요 없다
    //session에 의해서 식별이 되는 점 꼭 기억해두자
}
