package com.football_fantasy.demo.player.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

import static java.util.Objects.isNull;

@Component
public class TrackingIdFilter extends OncePerRequestFilter {

    private static final String TRACKING_ID_HEADER = "X-Tracking-Id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String trackingId = request.getHeader(TRACKING_ID_HEADER);

        if (isNull(trackingId) || trackingId.isEmpty()) {
            trackingId = UUID.randomUUID().toString();
        }

        MDC.put("trackingId", trackingId);


        response.setHeader(TRACKING_ID_HEADER, trackingId);

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove("trackingId");
        }
    }
}
