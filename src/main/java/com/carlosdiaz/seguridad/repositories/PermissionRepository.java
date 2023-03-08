package com.carlosdiaz.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlosdiaz.seguridad.models.Permission;




@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
