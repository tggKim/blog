package com.example.demo.service;

import com.example.demo.Model.Post;
import com.example.demo.dto.RequestPost;
import com.example.demo.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostRepository {
    private final DataRepository repository;
    public List<Post> getAllPost(){
        return repository.getAll();
    }
    public Post getById(Long id){
        return repository.get(id);
    }
    public void removeById(Long id){
        repository.remove(id);
    }
    public Post savePost(RequestPost requestPost){
        return repository.save(requestPost.toPost());
    }
    public Post updatePost(Long id,RequestPost requestPost){
        Post updatePost = requestPost.toPost();
        return repository.update(id,updatePost);
    }
}
