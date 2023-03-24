package com.board.project.domain.user.service;

import com.board.project.domain.user.entity.UserAccount;
import com.board.project.domain.user.repository.UserAccountRepository;
import com.board.project.domain.user.dto.UserAccountDto;
import com.board.project.domain.user.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final UserMapper userMapper;

    public UserAccountDto getReferenceById(String userId) {
        return userMapper.toUserAccountDto(
                userAccountRepository.getReferenceById(userId));
    }

    public UserAccountDto getUserAccount(String userId) {
        return userMapper.toUserAccountDto(
                userAccountRepository.findById(userId)
                        .orElseThrow(() -> new EntityNotFoundException("게시글이 없습니다")));
    }

    @Transactional(readOnly = true)
    public Optional<UserAccountDto> searchUser(String username) {
        return userAccountRepository.findById(username)
                .map(UserAccountDto::from);
    }

    public UserAccountDto saveUser(String username, String password, String email, String nickname, String memo) {
        return UserAccountDto.from(
                userAccountRepository.save(UserAccount.of(username, password, email, nickname, memo, username))
        );
    }
}
