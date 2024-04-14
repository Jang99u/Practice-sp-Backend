package sideproject.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.practice.domain.User;
import sideproject.practice.dto.user.request.CreateUserRequest;
import sideproject.practice.exeption.CustomErrorCode;
import sideproject.practice.exeption.CustomException;
import sideproject.practice.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;

    @Transactional
    public void saveUser(CreateUserRequest createUserRequest) {
        userRepository.save(new User(createUserRequest.name()));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<String> getUserName(Long userId) {
        User user = userRepository
                .findById(userId).orElseThrow(() -> new CustomException(CustomErrorCode.USER_NOT_FOUND));
        return ResponseEntity.ok().body(user.getName());
    }
}
