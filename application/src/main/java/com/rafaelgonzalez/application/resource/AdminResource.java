package com.rafaelgonzalez.application.resource;

import com.rafaelgonzalez.application.model.Admin;
import com.rafaelgonzalez.application.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminResource {
    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> addAdmin (@RequestBody Admin admin){
        Admin createdAdmin = adminService.addAdmin(admin);
        return ResponseEntity.ok(createdAdmin);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin updateAdmin){
        try {
            Admin admin = adminService.updateAdmin(id, updateAdmin);
            return ResponseEntity.ok(admin);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable Long id){
        adminService.deleteAdminById(id);
        return ResponseEntity.noContent().build();
    }
}
