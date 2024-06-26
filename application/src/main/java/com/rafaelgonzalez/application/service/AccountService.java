package com.rafaelgonzalez.application.service;

import com.rafaelgonzalez.application.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account findByUsername(String username);
    List<Account> getAccounts();
}
