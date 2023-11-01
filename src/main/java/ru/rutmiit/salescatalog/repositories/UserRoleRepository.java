package ru.rutmiit.salescatalog.repositories;

import org.springframework.stereotype.Repository;
import ru.rutmiit.salescatalog.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
}
