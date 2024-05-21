package com.rafaelgonzalez.application.repository;

import com.rafaelgonzalez.application.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
