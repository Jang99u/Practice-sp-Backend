package sideproject.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.practice.domain.User;
import sideproject.practice.dto.user.request.CreateUserRequest;
import sideproject.practice.repository.UserRepository;

@Service
public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(CreateUserRequest createUserRequest) {
        userRepository.save(new User(createUserRequest.getName()));
    }

    @Transactional(readOnly = true)
    public String getUserName(Long userId) {
        User user = userRepository
                .findById(userId).orElseThrow(IllegalAccessError::new);
        return user.getName();
    }
}
