package com.carlosdiaz.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlosdiaz.seguridad.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByNombre(String username);
}
