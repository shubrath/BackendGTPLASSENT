package com.gtpl.Assent.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gtpl.Assent.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}