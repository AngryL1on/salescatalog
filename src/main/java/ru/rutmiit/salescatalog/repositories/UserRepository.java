package ru.rutmiit.salescatalog.repositories;

import ru.rutmiit.salescatalog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
