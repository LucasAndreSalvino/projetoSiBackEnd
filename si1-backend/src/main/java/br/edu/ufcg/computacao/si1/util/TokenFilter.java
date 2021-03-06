package br.edu.ufcg.computacao.si1.util;

import br.edu.ufcg.computacao.si1.controller.LoginController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TokenFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer")) {
            throw new ServletException("Token inexistente ou inválido.");
        }

        String token = header.substring(7);

        try {
            Jwts.parser()
                    .setSigningKey(LoginController.KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            throw new ServletException("Token inválido.");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
