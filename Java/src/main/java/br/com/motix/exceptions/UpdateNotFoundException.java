package br.com.motix.exceptions;

public class UpdateNotFoundException extends RuntimeException {
    public UpdateNotFoundException(String message) {
        super(message);
    }
}
