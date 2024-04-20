package com.apptrove.TeamTracker.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String Class;

    private String path;

    private String property;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String class1, String path, String property) {
        super("The resource " + property + " was not found in the class " + class1 + " in method " + path);
        Class = class1;
        this.path = path;
        this.property = property;
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return "The resource " + this.property + " was not found in the class " + this.Class + " in method "
                + this.path;
    }

}
