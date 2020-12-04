package com.ifmo.jjd.patterns.chain;

import java.util.ArrayList;
import java.util.Arrays;

public class Chain {
    public static void main(String[] args) {
        IHandler handler = getHandlerChain();

        handler.handleRequest("данные в консоль", Handler.Priority.MIDDLE);

        handler.handleRequest("данные в файл", Handler.Priority.HIGH);

        handler.handleRequest("данные в консоль", Handler.Priority.MIDDLE);

        handler.handleRequest("данные в консоль", Handler.Priority.LOW);
        handler.handleRequest("данные в бд", Handler.Priority.URGENT);
        // consoleHandler.next = FileHandler
        // FileHandler.next = DBHandler
    }

    private static IHandler getHandlerChain(){
        IHandler first = new ConsoleHandler(Handler.Priority.LOW, Handler.Priority.MIDDLE);
        IHandler next1 = first.setNext(new FileHandler(Handler.Priority.HIGH));
        IHandler next2 = next1.setNext(new DBHandler(Handler.Priority.URGENT));
        return first;
    }
}
interface IHandler {
   IHandler setNext(IHandler handler);
   void handleRequest(Object someData, Handler.Priority priority);
}

abstract class Handler implements IHandler {
    public enum Priority {
        URGENT, HIGH, MIDDLE, LOW
    }
    private IHandler nextHandler;
    private ArrayList<Priority> priorities;

    public Handler(Priority... priority) {
        this.priorities = new ArrayList<>(Arrays.asList(priority));
    }

    @Override
    public IHandler setNext(IHandler handler) {
        nextHandler = handler;
        return handler;
    }

    @Override
    public void handleRequest(Object someData, Priority priority) {
//        if (this.priority == priority) handlerAction(someData);
        if (priorities.contains(priority)) handlerAction(someData);
        if (nextHandler != null) nextHandler.handleRequest(someData, priority);
    }
    abstract public void handlerAction(Object data);
}

class ConsoleHandler extends Handler {

    public ConsoleHandler(Priority... priority) {
        super(priority);
    }

    @Override
    public void handlerAction(Object data) {
        System.out.println("ConsoleHandler: " + data);
    }
}

class FileHandler extends Handler{

    public FileHandler(Priority... priority) {
        super(priority);
    }

    @Override
    public void handlerAction(Object data) {
        System.out.println("FileHandler: " + data);
    }
}

class DBHandler extends Handler {

    public DBHandler(Priority... priority) {
        super(priority);
    }

    @Override
    public void handlerAction(Object data) {
        System.out.println("DBHandler: " + data);
    }
}

// данные/запрос

// обработчик1
// обработчик2
// обработчик3 *

// обработчик1->обработчик2->обработчик3->null

// обработчик.обработкаЗапроса(данные/запрос)