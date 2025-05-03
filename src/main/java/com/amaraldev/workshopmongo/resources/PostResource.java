package com.amaraldev.workshopmongo.resources;

import com.amaraldev.workshopmongo.domain.Post;
import com.amaraldev.workshopmongo.resources.util.URL;
import com.amaraldev.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String title){
        title= URL.decodeParam(title);
        List<Post> list = postService.findByTitle(title);
        return ResponseEntity.ok().body(list);
    }

}

