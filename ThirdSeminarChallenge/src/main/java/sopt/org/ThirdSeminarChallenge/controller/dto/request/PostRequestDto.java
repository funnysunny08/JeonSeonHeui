package sopt.org.ThirdSeminarChallenge.controller.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PostRequestDto {

    private Long userId;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;
}
