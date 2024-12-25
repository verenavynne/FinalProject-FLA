package com.shashi.service;

import com.shashi.beans.UserBean;

public interface ValidationForChangePassword {
    boolean validate(UserBean user, String input);
}
