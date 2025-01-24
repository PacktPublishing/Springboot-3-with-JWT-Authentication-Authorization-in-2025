package com.mycompany.generic.controller;

import com.mycompany.generic.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    private CommonUtil commonUtil;

    @GetMapping("/all")
    public String allAccess() {
        System.out.println(commonUtil.loggedInUser());
        return "Public Content. ";
    }

    @GetMapping("/moderator")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "MODERATOR/ADMIN Content."+commonUtil.loggedInUser().getFirstName();
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String moderatorAccess() {
        return "USER Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
