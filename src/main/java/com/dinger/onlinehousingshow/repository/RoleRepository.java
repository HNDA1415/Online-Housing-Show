package com.dinger.onlinehousingshow.repository;

import com.dinger.onlinehousingshow.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String role_admin);
}
