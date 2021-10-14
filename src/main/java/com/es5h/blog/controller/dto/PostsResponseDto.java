package com.es5h.blog.controller.dto;

import com.es5h.blog.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long postSeq;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.postSeq=entity.getPostSeq();
        this.title=entity.getTitle();
        this.content= entity.getContent();
        this.author=entity.getAuthor();
    }
}
