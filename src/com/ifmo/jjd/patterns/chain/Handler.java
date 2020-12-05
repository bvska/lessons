package com.ifmo.jjd.patterns.chain;

import java.util.ArrayList;
import java.util.Arrays;

abstract public class Handler implements IHandler {
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
