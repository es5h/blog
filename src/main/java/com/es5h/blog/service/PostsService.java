package com.es5h.blog.service;

import com.es5h.blog.controller.dto.PostsListResponseDto;
import com.es5h.blog.controller.dto.PostsResponseDto;
import com.es5h.blog.controller.dto.PostsSaveRequestDto;
import com.es5h.blog.controller.dto.PostsUpdateRequestDto;
import com.es5h.blog.domain.posts.Posts;
import com.es5h.blog.domain.posts.PostsRepository;
import com.es5h.blog.util.mapstruct.PostsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    private final PostsMapper postsMapper;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(postsMapper.toEntity(requestDto)).getPostSeq();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다"));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto readPost(Long id){
        Posts entity=postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다"));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> readPostLists(){
        return postsRepository.findAllByOrderByPostSeqDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }
}
