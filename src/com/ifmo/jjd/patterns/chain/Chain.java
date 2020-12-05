package com.ifmo.jjd.patterns.chain;


public class Chain {

    public static IHandler getHandlerChain(){
        IHandler first = new ConsoleHandler(Handler.Priority.LOW, Handler.Priority.MIDDLE);
        IHandler next1 = first.setNext(new FileHandler(Handler.Priority.HIGH));
        IHandler next2 = next1.setNext(new DBHandler(Handler.Priority.URGENT));
        return first;
    }
}

// данные/запрос

// обработчик1
// обработчик2
// обработчик3 *

// обработчик1->обработчик2->обработчик3->null

// обработчик.обработкаЗапроса(данные/запрос)