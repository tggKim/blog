package com.example.demo.controller;

import com.example.demo.dto.ResponseBlogPost;
import com.example.demo.service.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogController {
    private final PostRepository repository;
    @GetMapping("/blog/posts")
    public String showBlogs(Model model){
        List<ResponseBlogPost> posts = repository.getAllPost()
                .stream()
                .map(ResponseBlogPost::new)
                .toList();
        model.addAttribute("posts",posts);
        return "posts";
    }
    @GetMapping("/blog/posts/{id}")
    public String showBlog(@PathVariable("id") Long id,Model model){
        ResponseBlogPost post = new ResponseBlogPost(repository.getById(id));
        model.addAttribute("post",post);
        return "post";
    }
    @GetMapping("/blog/post")
    public String addOrUpdate(@RequestParam(value = "id",required = false) Long id,Model model){
        ResponseBlogPost post;
        if(id==null){
            post = new ResponseBlogPost();
        }
        else{
            post = new ResponseBlogPost(repository.getById(id));
        }
        model.addAttribute("post",post);
        return "addOrUpdate";
    }
}
