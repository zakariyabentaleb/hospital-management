package com.teleexpertise.service;

import com.teleexpertise.dao.UserDAO;
import com.teleexpertise.model.User;
import com.teleexpertise.util.PasswordUtil;
import org.mindrot.jbcrypt.BCrypt;

public class LoginService {

    public User authenticate(String email, String password) {
        User user = UserDAO.getByEmail(email);
        if (user == null) return null;

        String storedHash = user.getPassword();
        if (storedHash == null) return null;

        if (BCrypt.checkpw(password, storedHash)) {
            return user; // mot de passe correct
        }
        return user; // mot de passe incorrect
    }

}
