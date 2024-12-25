package com.shashi.servlets;

import com.shashi.beans.UserBean;
import com.shashi.service.ValidationForChangePassword;

public class PasswordValidation implements ValidationForChangePassword {
    @Override
    public boolean validate(UserBean user, String input) {
        return user.getPWord().equals(input);
    }
}
