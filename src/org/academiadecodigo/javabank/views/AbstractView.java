package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.models.Bank;

public abstract class AbstractView implements View {

    protected Prompt prompt;
    protected Bank bank;

    public AbstractView(Bank bank, Prompt prompt) {
        this.bank = bank;
        this.prompt = prompt;
    }
}
