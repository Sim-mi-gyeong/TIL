package com.example.SessionLoginTest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SessionLoginTest.model.Member;
import com.example.SessionLoginTest.model.SecurityUser;
import com.example.SessionLoginTest.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

	/**
	 * memberRepository 를 주입받고 -> findByUserName 메서드를 이용해 입력된 username 이 유효한지 확인
	 * -> username 이 유효하지 않다면 -> 예외 발생시키고,
	 * -> username 이 유효하다면 -> username 으로 찾아온 Member 를 이용해 Custom User 인 SecurityUser 를 생성하여 반환
	 */
	@Autowired
	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> findMember = memberRepository.findByUserName(username);
		if (!findMember.isPresent()) throw new UsernameNotFoundException("존재하지 않는 username 입니다.");

		log.info("loadUserByUsername member.userName : {}", username);

		return new SecurityUser(findMember.get());
	}
}
