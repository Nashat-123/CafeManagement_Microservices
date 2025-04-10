package com.adminservice.services;

import com.adminservice.entities.Admin;
import java.util.*;
public interface AdminService {
	Admin registerAdmin(Admin admin);
    Admin loginAdmin(String username, String password);
    Admin updateAdmin(Admin admin);
    void deleteAdmin(String adminId);
    Admin getAdminById(String adminId);
    List<Admin> getAllAdmins();
}