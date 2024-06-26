package com.rafaelgonzalez.application.repository;

import com.rafaelgonzalez.application.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername (String username);
}
