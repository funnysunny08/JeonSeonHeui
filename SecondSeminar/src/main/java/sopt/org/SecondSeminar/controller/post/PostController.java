package sopt.org.SecondSeminar.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.post.dto.request.PostRequestDto;
import sopt.org.SecondSeminar.service.post.PostService;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public String post(@RequestBody final PostRequestDto request) {

        Long postId = postService.post(request);
        System.out.println(postList.get(postId.intValue() - 1).toString());

        return postId + " 번 게시글이 등록되었습니다. ";
    }

    @GetMapping("/post/{postId}")
    public String getOne(@PathVariable final Long postId) {

        String post = postList.get(postId.intValue() - 1).toString();
        return post;
    }

    @GetMapping("/post/search")
    public String search(@RequestParam final String name) {

        String searchedPost = postService.search(name);
        return searchedPost;
    }
}
