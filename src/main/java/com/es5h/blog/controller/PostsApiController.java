package com.es5h.blog.controller;

import com.es5h.blog.controller.dto.PostsSaveRequestDto;
import com.es5h.blog.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostsApiController {
    private final PostsService postsServic;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsServic.save(requestDto);
    }
}
