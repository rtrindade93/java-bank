package controller.transaction;

import controller.Controller;

import java.util.Set;

public interface AccountTransactionController extends Controller {

    Set<Integer> getAccountIds();

    void submitTransaction(int accountId, double amount);

}
