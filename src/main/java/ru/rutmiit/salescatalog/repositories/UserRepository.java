package ru.rutmiit.salescatalog.repositories;

import ru.rutmiit.salescatalog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
}
