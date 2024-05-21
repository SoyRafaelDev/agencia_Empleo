package com.rafaelgonzalez.application.service;

import com.rafaelgonzalez.application.model.Admin;

import java.util.List;
import java.util.Optional;


public interface AdminService {
    // Save admin
    Admin addAdmin(Admin admin);

    // Get all admins
    List<Admin> getAllAdmins();

    // Get one admin by ID
    Optional<Admin> getAdminById(Long id);

    // Update admin
    Admin updateAdmin(Long id, Admin admin);

    // Delete admin by ID
    Boolean deleteAdminById(Long id);
}
