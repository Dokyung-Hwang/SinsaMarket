package com.dangsan.sinsa.repository;

import com.dangsan.sinsa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
