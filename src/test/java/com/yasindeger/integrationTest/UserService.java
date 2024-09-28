package com.yasindeger.integrationTest;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<Long, UserModel> userRepository = new HashMap<>();

    public UserModel findById(Long id) {
        return userRepository.get(id);
    }

    public void save(UserModel user) {
        userRepository.put(user.getId(), user);
    }
}
