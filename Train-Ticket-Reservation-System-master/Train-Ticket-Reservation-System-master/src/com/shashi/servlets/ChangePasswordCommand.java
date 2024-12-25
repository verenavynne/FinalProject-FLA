package com.shashi.servlets;

import javax.servlet.http.HttpServletRequest;

import com.shashi.beans.UserBean;
import com.shashi.service.Command;
import com.shashi.service.UserService;
import com.shashi.service.ValidationForChangePassword;
import com.shashi.utility.TrainUtil;

public class ChangePasswordCommand implements Command {
    private final UserService userService;

    public ChangePasswordCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        UserBean currentUser = TrainUtil.getCurrentCustomer(req);
        String username = req.getParameter("username");
        String oldPassword = req.getParameter("oldpassword");
        String newPassword = req.getParameter("newpassword");

        ValidationForChangePassword usernameValidation = new UsernameValidation();
        ValidationForChangePassword passwordValidation = new PasswordValidation();

        if (!usernameValidation.validate(currentUser, username)) {
            return "INVALID_USERNAME";
        }

        if (!passwordValidation.validate(currentUser, oldPassword)) {
            return "WRONG_OLD_PASSWORD";
        }

        currentUser.setPWord(newPassword);
        String message = userService.updateUser(currentUser);
        return "SUCCESS".equalsIgnoreCase(message) ? "PASSWORD_UPDATED" : "UPDATE_FAILED";
    }
}
