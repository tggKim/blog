package com.example.demo.dto;

import com.example.demo.Model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ResponseBlogPost {
    private Long id;
    private String title;
    private String content;
    public ResponseBlogPost(Post post){
        this.id=post.getId();
        this.title=post.getTitle();
        this.content=post.getContent();
    }
}
