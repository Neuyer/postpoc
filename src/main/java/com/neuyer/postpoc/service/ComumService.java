package com.neuyer.postpoc.service;

import com.neuyer.postpoc.model.Publition;
import com.neuyer.postpoc.model.User;

public interface ComumService {

    public void createUser(User user);
    public void createPost(Long userId, Publition publition);
    public void like(Long userId, Long postId);
}
