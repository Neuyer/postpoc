package com.neuyer.postpoc.service;

import com.neuyer.postpoc.model.Like;
import com.neuyer.postpoc.model.Publition;
import com.neuyer.postpoc.model.User;
import com.neuyer.postpoc.repository.PostRepository;
import com.neuyer.postpoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComumServiceImpl implements ComumService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void createUser(User user) {
        List<Like> likeList = new ArrayList<>();
        List<Publition> publitionList = new ArrayList<>();
        user.setLikes(likeList);
        user.setPublitions(publitionList);
        userRepository.save(user);
    }

    @Override
    public void createPost(Long userId, Publition publition) {
        Optional<User> user = userRepository.findById(userId);
        List<Publition> postsList = user.get().getPublitions();
        postsList.add(publition);
        user.get().setPublitions(postsList);
        publition.setUser(user.get());
        userRepository.save(user.get());
        postRepository.save(publition);
    }

    @Override
    public void like(Long userId, Long postId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Publition> post = postRepository.findById(postId);

        Like like = new Like(null, user.get(), post.get());

        List<Like> userLikesList = user.get().getLikes();
        List<Like> postLikessList = post.get().getLikes();

        userLikesList.add(like);
        postLikessList.add(like);

        userRepository.save(user.get());
        postRepository.save(post.get());

    }
}
