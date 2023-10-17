package ru.rutmiit.salescatalog.repositories;

import ru.rutmiit.salescatalog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
