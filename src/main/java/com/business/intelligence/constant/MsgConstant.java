package com.business.intelligence.constant;


public class MsgConstant {
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";

    public interface User {
        String REGISTERED = "User registered successfully";
        String USER_ALREADY_EXISTS = "User already exists";
        String NOT_FOUND = "User not found";
        String INVALID_CREDENTIALS = "Invalid credentials";
    }

    public interface Login {
        String SUCCESS = "Login successfully";
        String FAILED = "Invalid user credentials";
    }

    public interface Exception {
        String AUTHENTICATION_FAILED = "Authentication failed";
        String TOKEN_EXPIRED = "Authentication token has expired";
        String TOKEN_INVALID = "Invalid authentication token";
        String ACCESS_DENIED = "Access denied";
        String UNAUTHORIZED_ACCESS = "Unauthorized access";
        String AUTHENTICATION_REQUIRED = "Authentication required. Please provide a valid access token.";
        String INSUFFICIENT_PERMISSIONS = "Access denied. You don't have permission to access this resource.";
        String INVALID_TOKEN_FORMAT = "Invalid token format. Please provide a valid Bearer token.";

        String VALIDATION_FAILED = "Validation failed";
        String INVALID_INPUT = "Invalid input provided";
        String INTERNAL_SERVER_ERROR = "An internal server error occurred";
        String UNEXPECTED_ERROR = "An unexpected error occurred";
        String RESOURCE_NOT_FOUND = "Requested resource not found";
        String DATABASE_ERROR = "Database operation failed";
        String DATA_INTEGRITY_VIOLATION = "Data integrity violation";
        String USER_ROLE_NOT_FOUND = "Role USER not found";
    }
}
