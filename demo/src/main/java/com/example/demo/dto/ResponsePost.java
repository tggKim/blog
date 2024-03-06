package com.example.demo.dto;

import com.example.demo.Model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ResponsePost {
    private String title;
    private String content;
    public ResponsePost(Post post){
        this.title=post.getTitle();
        this.content=post.getContent();
    }
}
