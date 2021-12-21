package com.dangsan.sinsa.repository;

import com.dangsan.sinsa.entity.User;
import java.util.Optional;
import java.util.stream.DoubleStream;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsername(String username);
}
