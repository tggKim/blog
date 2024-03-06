package com.example.demo.dto;

import com.example.demo.Model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPost {
    private String title;
    private String content;
    public Post toPost(){
        return new Post(this.title,this.content);
    }
}
