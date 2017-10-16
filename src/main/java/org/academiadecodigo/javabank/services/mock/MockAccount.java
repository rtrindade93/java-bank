package org.academiadecodigo.javabank.services.mock;

import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.services.Account;

public class MockAccount extends AbstractMock<org.academiadecodigo.javabank.model.account.Account> implements Account {

    public void deposit(Integer id, double amount) {
        modelMap.get(id).credit(amount);
    }

    public void withdraw(Integer id, double amount) {

        org.academiadecodigo.javabank.model.account.Account account = modelMap.get(id);
        if (account.getAccountType() == AccountType.SAVINGS) {
            return;
        }

        modelMap.get(id).debit(amount);
    }

    public void transfer(Integer srcId, Integer dstId, double amount) {

        org.academiadecodigo.javabank.model.account.Account srcAccount = modelMap.get(srcId);
        org.academiadecodigo.javabank.model.account.Account dstAccount = modelMap.get(dstId);

        // make sure transaction can be performed
        if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
            srcAccount.debit(amount);
            dstAccount.credit(amount);
        }
    }
}
