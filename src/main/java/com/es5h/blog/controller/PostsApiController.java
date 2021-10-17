package com.es5h.blog.controller;

import com.es5h.blog.controller.dto.PostsResponseDto;
import com.es5h.blog.controller.dto.PostsSaveRequestDto;
import com.es5h.blog.controller.dto.PostsUpdateRequestDto;
import com.es5h.blog.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto readPost(@PathVariable Long id){
        return postsService.readPost(id);
    }
}
