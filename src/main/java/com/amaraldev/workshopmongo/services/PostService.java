package com.amaraldev.workshopmongo.services;

import com.amaraldev.workshopmongo.domain.Post;
import com.amaraldev.workshopmongo.repository.PostRepository;
import com.amaraldev.workshopmongo.services.exception.ObjectNotFoundExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExeception("Objeto não encontrado"));
    }
    public List<Post> findByTitle(String title){
        return postRepository.findByTitleContainingIgnoreCase(title);
    }

}