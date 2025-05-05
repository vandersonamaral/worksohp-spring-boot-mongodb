package com.amaraldev.workshopmongo.services;

import com.amaraldev.workshopmongo.domain.Post;
import com.amaraldev.workshopmongo.repository.PostRepository;
import com.amaraldev.workshopmongo.services.exception.ObjectNotFoundExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        return postRepository.searchTitle(title);
    }
    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate= new Date(maxDate.getTime()+24*60*60*1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }

}