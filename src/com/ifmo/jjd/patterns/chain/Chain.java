package com.ifmo.jjd.patterns.chain;

public class Chain {
    public static void main(String[] args) {

    }
}
interface IHandler {
   IHandler setNext(IHandler handler);
   void handleRequest(Object someData, Handler.Priority priority);
}

abstract class Handler implements IHandler {
    public enum Priority {
        HIGH, MIDDLE, LOW
    }
    private IHandler nextHandler;
    private Priority priority;

    @Override
    public IHandler setNext(IHandler handler) {
        nextHandler = handler;
        return handler;
    }

    @Override
    public void handleRequest(Object someData, Priority priority) {
        if (this.priority == priority) handlerAction(someData);
        if (nextHandler != null) nextHandler.handleRequest(someData, priority);
    }
    abstract public void handlerAction(Object data);
}

// данные/запрос

// обработчик1
// обработчик2
// обработчик3 *

// обработчик1->обработчик2->обработчик3->null

// обработчик.обработкаЗапроса(данные/запрос)