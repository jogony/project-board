package com.board.project.domain.user.mapper;

import com.board.project.domain.user.dto.UserAccountDto;
import com.board.project.domain.user.entity.UserAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserAccount toUserAccountEntity(UserAccountDto userAccountDto);
    UserAccountDto toUserAccountDto(UserAccount userAccount);
}
