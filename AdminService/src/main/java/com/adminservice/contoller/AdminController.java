package com.adminservice.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adminservice.entities.Admin;
import com.adminservice.services.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        // Handle admin registration request
        return adminService.registerAdmin(admin);
    }

    @PostMapping("/login")
    public Admin loginAdmin(@RequestParam String username, @RequestParam String password) {
        // Handle admin login request
        Admin admin = adminService.loginAdmin(username, password);
        if (admin != null) {
            return admin;
        } else {
            // Handle login failure (e.g., return an error response)
            return null;
        }
    }

    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin) {
        // Handle admin update request
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/delete/{adminId}")
    public void deleteAdmin(@PathVariable String adminId) {
        // Handle admin deletion request
        adminService.deleteAdmin(adminId);
    }
    
    @GetMapping("/{adminId}")
    public Admin getAdminById(@PathVariable String adminId) {
        // Retrieve admin by ID
        return adminService.getAdminById(adminId);
    }

    @GetMapping("/all")
    public List<Admin> getAllAdmins() {
        // Retrieve all admins
        return adminService.getAllAdmins();
    }
    
    
}
