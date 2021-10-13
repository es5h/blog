package com.es5h.blog.service;

import com.es5h.blog.controller.dto.PostsSaveRequestDto;
import com.es5h.blog.domain.posts.PostsRepository;
import com.es5h.blog.util.mapstruct.PostsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    private final PostsMapper postsMapper;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(postsMapper.toEntity(requestDto)).getPostSeq();
    }
}
