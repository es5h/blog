package com.es5h.blog.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After // 단위테스트 끝날때
    public void cleanup(){
        postsRepository.deleteAll();;
    }

    @Test
    public void savePostTest(){
        String title="제목";
        String content = "본문";

        postsRepository.save(Posts.builder().title(title).content(content).build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
    @Test
    public void baseTimeEntityTest(){
        //Given
        String title="title";
        String content="content";
        LocalDateTime now = LocalDateTime.now();

        postsRepository.save(Posts.builder().title(title).content(content).build());

        //When
        List<Posts> postsList = postsRepository.findAll();

        //Then
        Posts posts = postsList.get(0);
        assertThat(posts.getCreatedDate()).isAfterOrEqualTo(now);
        assertThat(posts.getModifedDatee()).isAfterOrEqualTo(now);
    }
}
