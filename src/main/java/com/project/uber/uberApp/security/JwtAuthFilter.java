package com.project.uber.uberApp.security;

import com.project.uber.uberApp.entities.User;
import com.project.uber.uberApp.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final UserService userService;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private final HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            //fetch token from request header
            final String requestTokenHeader = request.getHeader("Authorization");
            if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer")) {
                filterChain.doFilter(request, response);
                return;
            }

            //fetch token value excluding bearer
            String token = requestTokenHeader.split("Bearer ")[1];

            Long userId = jwtService.getUserIdFromToken(token);

            //The userId is validated to ensure it's not null, and
            // the SecurityContextHolder is checked to see if the current request is already authenticated.
            if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                User user = userService.getUserById(userId);

                // Fetching the User and Creating Authentication Object
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(user, null, null);

                //pass additional information like - IP address and sessionId
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //set user authentication token in security context
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

            //pass on to next filter
            filterChain.doFilter(request, response);
        } catch (Exception ex) {
            //errors in security filter chain aren't automatically handled by spring security so
            //handlerExceptionResolver is used
            handlerExceptionResolver.resolveException(request, response, null, ex);
        }
    }
}
