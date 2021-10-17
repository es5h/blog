package com.es5h.blog.controller;

import com.es5h.blog.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.readPostLists());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "post-save";
    }
}