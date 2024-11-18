package com.example.demo.domain.member.repository;

import com.example.demo.domain.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByUserName(String userName);
    int countByUserName(String userName);

}
