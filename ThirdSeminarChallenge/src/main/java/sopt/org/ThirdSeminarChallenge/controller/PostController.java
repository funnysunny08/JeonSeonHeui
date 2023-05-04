package sopt.org.ThirdSeminarChallenge.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.ThirdSeminarChallenge.common.dto.ApiResponseDto;
import sopt.org.ThirdSeminarChallenge.controller.dto.request.PostRequestDto;
import sopt.org.ThirdSeminarChallenge.controller.dto.response.PostResponseDto;
import sopt.org.ThirdSeminarChallenge.exception.SuccessStatus;
import sopt.org.ThirdSeminarChallenge.service.PostService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<PostResponseDto> create(@RequestBody @Valid final PostRequestDto request) {
        return ApiResponseDto.success(SuccessStatus.POST_CREATE_SUCCESS, postService.create(request));
    }

    @GetMapping("/post/{postId}")
    public ApiResponseDto<PostResponseDto> getOne(@PathVariable final Long postId) {
        return ApiResponseDto.success(SuccessStatus.POST_GET_SUCCESS, postService.getOne(postId));
    }

}
