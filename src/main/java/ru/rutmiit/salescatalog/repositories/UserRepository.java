package ru.rutmiit.salescatalog.repositories;

import org.springframework.stereotype.Repository;
import ru.rutmiit.salescatalog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    List<Users> findAllByFirstName(String firstName);
    List<Users> findAllByLastName(String lastName);
}
