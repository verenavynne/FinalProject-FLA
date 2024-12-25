package com.shashi.servlets;

public class MessageFactory {
    public static String getMessage(String type) {
        switch (type) {
            case "INVALID_USERNAME":
                return "<div class='tab'>Invalid Username!</div>";
            case "WRONG_OLD_PASSWORD":
                return "<div class='tab'>Wrong Old Password!</div>";
            case "PASSWORD_UPDATED":
                return "<div class='tab'>Your password has been updated successfully. Please login again!</div>";
            case "UPDATE_FAILED":
                return "<div class='tab'>Failed to update password!</div>";
            default:
                return "<div class='tab'>Unexpected error occurred.</div>";
        }
    }
}
