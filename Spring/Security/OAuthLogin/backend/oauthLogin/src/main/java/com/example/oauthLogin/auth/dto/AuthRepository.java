package com.example.oauthLogin.auth.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Long> {

    boolean existByMemberId(Long memberId);

}
