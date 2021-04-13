package io.carwash.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.carwash.admin.model.Admin;
import io.carwash.admin.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AdminService implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;

    //Create operation
    public Admin create(Admin admin) {
        return adminRepo.save(admin);
    }
    //Retrieve operation
    public List<Admin> getAll(){
        return adminRepo.findAll();
    }

    public Admin getByName(String name)
    {
        return adminRepo.findByName(name);
    }

    //Update operation
    public Admin update(String id,String name, String password) {
        Admin p = adminRepo.findByName(name);
        p.setName(name);
        p.setPassword(password);
        return adminRepo.save(p);
    }

    //Delete operation
    public void deleteAll()
    {
        adminRepo.deleteAll();
    }

    public void delete(String name) {
        Admin p = adminRepo.findByName(name);
        adminRepo.delete(p);
    }
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Admin p=adminRepo.findByName(name);
        if(p == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("admin"));
        return new User(p.getName(),p.getPassword(),authorities);
    }
}
