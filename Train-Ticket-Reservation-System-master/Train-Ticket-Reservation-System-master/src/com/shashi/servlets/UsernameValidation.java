package com.shashi.servlets;

import com.shashi.beans.UserBean;
import com.shashi.service.ValidationForChangePassword;

public class UsernameValidation implements ValidationForChangePassword{
    @Override
    public boolean validate(UserBean user, String input) {
        return user.getMailId().equals(input);
    }
}