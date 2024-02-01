package com.amita.user.service.services;

import com.amita.user.service.entities.User;

import java.util.List;

public interface Service {

    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
}
