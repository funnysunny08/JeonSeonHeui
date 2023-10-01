package sopt.org.ThirdSeminarChallenge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThirdSeminarChallenge.controller.dto.request.UserRequestDto;
import sopt.org.ThirdSeminarChallenge.domain.User;
import sopt.org.ThirdSeminarChallenge.infrastructure.UserRepository;
import java.util.Optional;
import sopt.org.ThirdSeminarChallenge.controller.dto.response.UserResponseDto;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(UserRequestDto request) {
        User user = User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();

        userRepository.save(user);

        return UserResponseDto.of(user.getId(), user.getNickname());
    }
}
