package main;

import java.util.ArrayList;

public class Notification {
    private final ArrayList<String> errors = new ArrayList<String>();

    public void addError(final String message) {
        this.errors.add(message);
    }

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public String errorMessage() {
        return this.errors.toString();
    }

    public ArrayList<String> getErrors() {
        return this.errors;
    }

}