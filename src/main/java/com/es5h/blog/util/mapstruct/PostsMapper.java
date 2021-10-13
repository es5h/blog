package com.es5h.blog.util.mapstruct;

import com.es5h.blog.controller.dto.PostsSaveRequestDto;
import com.es5h.blog.domain.posts.Posts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostsMapper extends GenericMapper<PostsSaveRequestDto, Posts> {
}
