package org.example.userservice.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("postgres")
@Primary
public interface UserPostgresDAO extends UserRepository {
}
