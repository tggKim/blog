package com.example.demo.controller;

import com.example.demo.dto.RequestPost;
import com.example.demo.dto.ResponsePost;
import com.example.demo.Model.Post;
import com.example.demo.service.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogApiController {
    private final PostRepository repository;
    @GetMapping("/api/posts")
    public List<ResponsePost> getAllApi(){
        return repository.getAllPost()
                .stream()
                .map(ResponsePost::new)
                .toList();
    }
    @GetMapping("/api/posts/{id}")
    public ResponsePost getApi(@PathVariable("id") Long id){
        return new ResponsePost(repository.getById(id));
    }
    @PostMapping("/api/posts")
    public Post saveApi(@RequestBody RequestPost requestPost){
        return repository.savePost(requestPost);
    }
    @PutMapping("/api/posts/{id}")
    public Post updateApi(@PathVariable("id") Long id,@RequestBody RequestPost requestPost){
        return repository.updatePost(id,requestPost);
    }
    @DeleteMapping("/api/posts/{id}")
    public void deleteApi(@PathVariable("id") Long id){
        repository.removeById(id);
    }
}
