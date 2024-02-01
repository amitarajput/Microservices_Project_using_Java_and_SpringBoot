package com.amita.user.service.services.impl;

import com.amita.user.service.entities.Rating;
import com.amita.user.service.entities.User;
import com.amita.user.service.exceptions.ResourceNotFound;
import com.amita.user.service.repositories.UserRepository;
import com.amita.user.service.services.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class UserServiceImpl implements Service {

    @Autowired
    private UserRepository userRepository;// for saving

    @Autowired
    private RestTemplate restTemplate;// client for calling APIs

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();// generate user unique Id
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user =  userRepository.findById(userId).orElseThrow(() -> new ResourceNotFound("User not found : "+userId));
        ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+ user.getUserId(), ArrayList.class);
        logger.info("{} ", ratingsOfUser);
        List<Rating> ratingList = ratingsOfUser.stream().map(rating -> {}


                ).collect(Collectors.toList());

        user.setRatings(ratingsOfUser);

        return user;
    }
}
