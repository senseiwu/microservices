package com.rysiekblah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tomek on 10/30/16.
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository repository;

    @RequestMapping("/role/{accountId}")
    public String getAccountRole(@PathVariable("accountId") Integer accountId) throws AccountRepositoryException {
        return repository.findById(accountId).getRole();
    }

    @RequestMapping("/{accountId}")
    public String getAccountObject(@PathVariable("accountId") Integer accountId) throws AccountRepositoryException {
        return repository.findById(accountId).toJson();
    }

    @RequestMapping("/byName")
    public List<Account> getAccountsByName(@RequestParam("name") String name) throws AccountRepositoryException {
        return repository.findByName(name);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAccount(@RequestBody Account account) {
        repository.insert(account);
    }

    @ExceptionHandler(AccountRepositoryException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Error handleQueryFailre(AccountRepositoryException ex) {
        return new Error(1, ex.getMessage());
    }

}
