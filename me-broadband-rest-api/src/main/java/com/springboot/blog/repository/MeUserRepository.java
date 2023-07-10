package com.springboot.blog.repository;

import com.springboot.blog.entity.MeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeUserRepository extends JpaRepository<MeUser,String> {
}
