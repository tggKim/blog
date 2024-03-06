package com.example.demo.repository;
import com.example.demo.Model.Post;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostDataRepository implements DataRepository{
    static Map<Long, Post> store = new HashMap();
    static private long count=0;

    @Override
    public List<Post> getAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Post get(Long id) {
        return store.get(id);
    }

    @Override
    public void remove(Long id) {
        store.remove(id);
    }

    @Override
    public Post save(Post post) {
        post.setId(++count);
        store.put(post.getId(),post);
        return post;
    }

    @Override
    public Post update(Long id, Post updatePost) {
        Post post = store.get(id);
        post.setTitle(updatePost.getTitle());
        post.setContent(updatePost.getContent());
        return post;
    }

    @PostConstruct
    public void method(){
        save(new Post("제목1","내용1"));
        save(new Post("제목2","내용2"));
    }
}
