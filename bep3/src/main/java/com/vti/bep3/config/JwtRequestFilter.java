package com.vti.bep3.config;

import com.vti.bep3.utils.JwtUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // B1: Lấy giá trị token
        String token = request.getHeader("Authorization") != null ? request.getHeader("Authorization").substring(7) : "";

        //B2: Giải mã token (nếu token ko hợp lệ, hết hạn,.. -> trả về null thông tin đăng nhập)
        UsernamePasswordAuthenticationToken authentication = JwtUtils.checkToken(token, request);

        // Set đối tượng Athen trên vào Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //B3: do fillter -> bước tiêp theo
        filterChain.doFilter(request, response);
    }
}
