package com.dangsan.sinsa.util;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Slf4j
public class SecurityUtil {
    private SecurityUtil() {}

    public static Optional<String> getCurrentUsername() {
        final Authentication authentication = SecurityContextHolder.
            getContext().getAuthentication();
        if(authentication==null) {
            log.info("context에 로그인 정보가 없습니다.");
            return Optional.empty(); // 빈 객체 생성
        }
        String username= null;
        if(authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails=(UserDetails) authentication.getPrincipal();
            username=userDetails.getUsername();
        }
        else if(authentication.getPrincipal() instanceof String) {
            username = (String) authentication.getPrincipal();
        }
        /*
        ofNullable은 null 값도 들어갈 수 있다.
         */
        return Optional.ofNullable(username);
    }
}
