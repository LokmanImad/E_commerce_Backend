package org.example.userservice.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("h2")
@Primary
public interface UserH2DAO extends UserRepository {
}