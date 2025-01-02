package org.example.userservice.repository;

import org.springframework.stereotype.Repository;

@Repository("postgres")
public interface UserPostgresDAO extends UserRepository {
}
