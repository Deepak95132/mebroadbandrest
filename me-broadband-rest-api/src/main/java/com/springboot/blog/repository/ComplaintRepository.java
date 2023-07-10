package com.springboot.blog.repository;

import com.springboot.blog.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComplaintRepository extends JpaRepository<Complaint,Long> {

    Optional<Complaint> findByPhoneNumberOrEmail(String phoneNumber, String email);
}
