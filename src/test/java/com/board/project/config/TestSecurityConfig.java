package com.board.project.config;

import com.board.project.domain.user.dto.UserAccountDto;
import com.board.project.domain.user.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {
    @MockBean private UserAccountService userAccountService;

    TestSecurityConfig(@Autowired UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @BeforeTestMethod
    public void securitySetUp() {
        given(userAccountService.searchUser(anyString()))
                .willReturn(Optional.of(createUserAccountDto()));
        given(userAccountService.saveUser(anyString(), anyString(), anyString(), anyString(), anyString()))
                .willReturn(createUserAccountDto());
    }

    private UserAccountDto createUserAccountDto(){
        return UserAccountDto.of(
                "kswTest",
                "pw",
                "ksw-test@gmail.com",
                "ksw-test",
                "test-memo"
        );
    }
}
