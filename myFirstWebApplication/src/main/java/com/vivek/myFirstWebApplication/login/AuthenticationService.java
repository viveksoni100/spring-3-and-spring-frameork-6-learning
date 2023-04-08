package com.vivek.myFirstWebApplication.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        if (username.equalsIgnoreCase("vivek") && password.equalsIgnoreCase("pass"))
            return true;
        return false;
    }
}
