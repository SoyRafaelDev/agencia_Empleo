package com.rafaelgonzalez.application.service.impl;

import com.rafaelgonzalez.application.model.Admin;
import com.rafaelgonzalez.application.repository.AdminRepository;
import com.rafaelgonzalez.application.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminReposiroty;

    public Admin createAdmin(Admin admin){
        return adminReposiroty.save(admin);
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return adminReposiroty.save(admin);
    }

    public List<Admin> getAllAdmins(){
        return adminReposiroty.findAll();
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return Optional.empty();
    }

    public Admin updateAdmin(Long id, Admin updateAdmin){
        return adminReposiroty.findById(id).map(admin -> {
            admin.setDescription(updateAdmin.getDescription());
            return adminReposiroty.save(admin);
        })
                .orElseThrow(() -> new RuntimeException("Admin not found"));

    }

    @Override
    public Boolean deleteAdminById(Long id) {
        adminReposiroty.deleteById(id);
        return true;
    }

    public void deleteAdmin(Long id){
        adminReposiroty.deleteById(id);
    }
}
