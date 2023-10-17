package ru.rutmiit.salescatalog.repositories;

import ru.rutmiit.salescatalog.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
