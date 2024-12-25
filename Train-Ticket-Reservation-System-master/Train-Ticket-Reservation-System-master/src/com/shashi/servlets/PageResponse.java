package com.shashi.servlets;

import com.shashi.beans.UserBean;

public class PageResponse {
    public static String generateResponse(String title, String content) {
        return "<html><head><title>" + title + "</title></head><body>" + content + "</body></html>";
    }

    public static String generateMainContent(UserBean user) {
        return "<div class='main'><p1 class='menu'><a href='viewuserprofile'>View Profile</a></p1>&nbsp;"
                + "<p1 class='menu'><a href='edituserprofile'>Edit Profile</a></p1>&nbsp;"
                + "<p1 class='menu'><a href='changeuserpassword'>Change Password</a></p1></div>";
    }
}