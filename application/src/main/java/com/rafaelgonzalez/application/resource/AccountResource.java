package com.rafaelgonzalez.application.resource;

import com.rafaelgonzalez.application.model.Account;
import com.rafaelgonzalez.application.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rafaelgonzalez.application.resource.EmployeeResource.getLocation;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountResource {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount (@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.created(getLocation(newAccount.getId().intValue())).body(newAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccount(){
        return ResponseEntity.ok(accountService.getAccounts());
    }
}
