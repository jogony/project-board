package com.board.project.domain.user.service;

import com.board.project.domain.user.UserAccountRepository;
import com.board.project.domain.user.dto.UserAccountDto;
import com.board.project.domain.user.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
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
}
