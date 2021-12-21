package com.dangsan.sinsa.service;

import com.dangsan.sinsa.entity.User;
import com.dangsan.sinsa.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDetailService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findOneWithAuthoritiesByUsername(username)
            .map(user->createUser(username,user))
            .orElseThrow(() -> new UsernameNotFoundException(username+"이 존재하지 않습니다."));
    }
    private org.springframework.security.core.userdetails.User createUser(String username, User user) {
        if(!user.isStatus()) {
            throw new RuntimeException(username + "는 휴면 계정입니다.");
        }
        List<GrantedAuthority> grantedAuthorityList= user.getAuthorities().stream()
            .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
            .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
            user.getPassword(), grantedAuthorityList);
    }
}
