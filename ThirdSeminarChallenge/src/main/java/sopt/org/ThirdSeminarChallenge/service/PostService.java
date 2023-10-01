package sopt.org.ThirdSeminarChallenge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThirdSeminarChallenge.controller.dto.request.PostRequestDto;
import sopt.org.ThirdSeminarChallenge.controller.dto.response.PostResponseDto;
import sopt.org.ThirdSeminarChallenge.domain.Post;
import sopt.org.ThirdSeminarChallenge.domain.User;
import sopt.org.ThirdSeminarChallenge.infrastructure.PostRepository;
import sopt.org.ThirdSeminarChallenge.infrastructure.UserRepository;
import sopt.org.ThirdSeminarChallenge.service.UserService;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public PostResponseDto create(PostRequestDto request) {
        Post post = Post.builder()
                .user(userRepository.findUserById(request.getUserId()))
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        postRepository.save(post);

        return PostResponseDto.of(post.getUser().getNickname(), post.getTitle(), post.getContent());
    }

    @Transactional(readOnly = true)
    public PostResponseDto getOne(Long postId) {
        Post post = postRepository.findPostById(postId);
        return PostResponseDto.of(post.getUser().getNickname(), post.getTitle(), post.getContent());
    }
}
