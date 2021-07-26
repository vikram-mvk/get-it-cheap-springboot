package com.getitcheap.API.Security;

import com.getitcheap.API.DTO.MessageResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class GetItCheapAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if (httpServletResponse.getStatus() == 429) {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);

        } else {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT Token. Please Sign in again");
        }
      }
}
