package com.example.priyapc.navigationtask;

import java.util.List;

/**
 * Created by PriyaPC on 03-04-2017.
 */

public class Notice {

    String schoolName;
    String noticeSubject;
    int schoolLogo;

    Notice(String schoolName, String noticeSubject, int schoolLogo) {
        this.schoolName = schoolName;
        this.noticeSubject = noticeSubject;
        this.schoolLogo = schoolLogo;
    }

    private List<Notice> notices;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
}
