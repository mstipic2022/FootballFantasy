package com.football_fantasy.demo.player.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class TrackingIdFilter implements Filter {

    private static final String TRACKING_ID_HEADER = "X-Tracking-Id";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String trackingId = httpRequest.getHeader(TRACKING_ID_HEADER);
        if (trackingId == null || trackingId.isEmpty()) {
            trackingId = UUID.randomUUID().toString();
        }

        MDC.put("trackingId", trackingId);

        httpResponse.setHeader(TRACKING_ID_HEADER, trackingId);

        try {
            chain.doFilter(request, response);
        } finally {
            MDC.remove("trackingId");
        }
    }
}
