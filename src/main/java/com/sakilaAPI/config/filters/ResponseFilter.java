package com.sakilaAPI.config.filters;

import com.sakilaAPI.database.Database;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class ResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
            chain.doFilter(request, response);
        }catch (Exception e){
            throw new RuntimeException("Error during serving request please try again");
        }finally {
            Database.closeEntityManager();
        }
    }
}

