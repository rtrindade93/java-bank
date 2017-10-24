package org.academiadecodigo.javabank.converters;

import org.academiadecodigo.javabank.command.AccountForm;
import org.academiadecodigo.javabank.model.account.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountToAccountForm implements Converter<Account, AccountForm> {

    @Override
    public AccountForm convert(Account account) {
        AccountForm accountForm = new AccountForm();
        accountForm.setId(account.getId());
        accountForm.setBalance(account.getBalance());

        return accountForm;
    }
}
