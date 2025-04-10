package com.adminservice.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.adminservice.entities.Admin;
import com.adminservice.repo.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin registerAdmin(Admin admin) {
        // Implement registration logic
        return adminRepository.save(admin);
    }

    @Override
    public Admin loginAdmin(String username, String password) {
        // Implement login logic
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        // Implement update logic
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(String adminId) {
        // Implement delete logic
        adminRepository.deleteById(adminId);
    }

    @Override
    public Admin getAdminById(String adminId) {
        // Retrieve admin by ID
        Optional<Admin> adminOptional = adminRepository.findById(adminId);
        return adminOptional.orElse(null);
    }

    @Override
    public List<Admin> getAllAdmins() {
        // Retrieve all admins
        return adminRepository.findAll();
    }
}