package com.example.effectMobile.TestTask.repository;

import com.example.effectMobile.TestTask.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
