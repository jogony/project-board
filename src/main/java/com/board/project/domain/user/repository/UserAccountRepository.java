package com.board.project.domain.user.repository;

import com.board.project.domain.user.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserAccountRepository extends
        JpaRepository<UserAccount, String>,
        QuerydslPredicateExecutor<UserAccount> {

}
