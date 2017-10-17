package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.exceptions.TransactionException;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.AccountDao;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.managers.TransactionManager;

public class AccountServiceImpl implements AccountService {

    private TransactionManager transactionManager;
    private AccountDao accountDao;

    public AccountServiceImpl(TransactionManager transactionManager, AccountDao accountDao) {
        this.transactionManager = transactionManager;
        this.accountDao = accountDao;
    }

    @Override
    public void deposit(Integer id, double amount) {

        try {

            transactionManager.beginWrite();

            Account account = accountDao.findById(id);

            if (account == null) {
                transactionManager.rollback();
                throw new TransactionException("invalid account id");
            }

            account.credit(amount);
            accountDao.saveOrUpdate(account);
            transactionManager.commit();

        } catch (TransactionException ex) {
            transactionManager.rollback();
        }
    }

    @Override
    public void withdraw(Integer id, double amount) {

        try {

            transactionManager.beginWrite();

            Account account = accountDao.findById(id);

            if (account == null) {
                transactionManager.rollback();
                throw new TransactionException("invalid account");
            }

            account.debit(amount);
            accountDao.saveOrUpdate(account);
            transactionManager.commit();

        } catch (TransactionException ex) {
            transactionManager.rollback();
        }
    }

    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {

        try {

            transactionManager.beginWrite();

            Account srcAccount = accountDao.findById(srcId);
            Account dstAccount = accountDao.findById(dstId);

            if (srcAccount == null || dstAccount == null) {
                transactionManager.rollback();
                throw new TransactionException("invalid account id");
            }

            // make sure transaction can be performed
            if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
                srcAccount.debit(amount);
                dstAccount.credit(amount);
            }

            accountDao.saveOrUpdate(srcAccount);
            accountDao.saveOrUpdate(dstAccount);

            transactionManager.commit();

        } catch (TransactionException ex) {
            transactionManager.rollback();
        }
    }

    @Override
    public Account createAccount(Account account) {

        Account savedAccount = null;

        try {

            transactionManager.beginWrite();

            savedAccount = accountDao.saveOrUpdate(account);

            transactionManager.commit();

        } catch (TransactionException ex) {
            transactionManager.rollback();
        }

        return savedAccount;
    }
}
