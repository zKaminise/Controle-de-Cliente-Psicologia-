package com.example.PsicologiaSystemBackEnd.Services;

import com.example.PsicologiaSystemBackEnd.Entities.User;
import com.example.PsicologiaSystemBackEnd.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get().getPassword().equals(password);
        }
        return false;
    }
}
