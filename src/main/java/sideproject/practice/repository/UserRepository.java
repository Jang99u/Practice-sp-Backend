package sideproject.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sideproject.practice.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
