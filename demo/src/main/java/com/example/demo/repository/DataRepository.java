package com.example.demo.repository;

import com.example.demo.Model.Post;

import java.util.List;

public interface DataRepository {
    public List<Post> getAll();
    public Post get(Long id);
    public void remove(Long id);
    public Post save(Post post);
    public Post update(Long id,Post updatePost);
}
