package com.etiya.fullstack.core.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {
            final String authHeader = request.getHeader("Authorization");
            //Eğer auth headeri gönderilmemiş veya yanlış gönderilmiş ise
            if(authHeader==null || !authHeader.startsWith("Bearer ")){
                filterChain.doFilter(request,response);
                return;
            }

            final String jwt = authHeader.substring(7);
            final String username = jwtService.extractUsername(jwt);

            // username null değilse ve böyle bir user varsa?
            // token süresi geçmemiş ve benim ürettiğim bir tokensa
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null)
            {
                UserDetails user = this.userDetailsService.loadUserByUsername(username);
                if(jwtService.isTokenValid(jwt,user)){
                    // Giriş işlemleri
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
            filterChain.doFilter(request,response);
    }
}
//10:10
