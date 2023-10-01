package sopt.org.ThirdSeminarChallenge.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    /*
    user
     */
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료되었습니다."),
    /*
    post
    */
    POST_CREATE_SUCCESS(HttpStatus.CREATED, "게시글 작성이 완료되었습니다."),
    POST_GET_SUCCESS(HttpStatus.OK, "게시글 조회가 완료되었습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
