package com.arumosam.laktutor.repositories;

import com.arumosam.laktutor.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}
