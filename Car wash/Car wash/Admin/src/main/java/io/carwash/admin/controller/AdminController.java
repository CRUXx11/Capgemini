package io.carwash.admin.controller;

import io.carwash.admin.model.AuthenticationRequest;
import io.carwash.admin.model.AuthenticationResponse;
import io.carwash.admin.model.Admin;
import io.carwash.admin.service.AdminService;
import io.carwash.admin.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("/create")
    public String create(@RequestBody Admin admin) {
        Admin p = adminService.create(admin);
        return p.toString();
    }

    @PostMapping("/authenticate")
    private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        String email=authenticationRequest.getName();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getName(), authenticationRequest.getPassword()));
        }catch (Exception e){
            return ResponseEntity.ok(new AuthenticationResponse("Invalid Username or Password")) ;
        }
        UserDetails loadedUser=adminService.loadUserByUsername(email);
        String generatedToken =jwtUtil.generateToken(loadedUser);
        return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
    }
    @RequestMapping("/get")
    public String getAdmin(@RequestBody AuthenticationRequest authenticationRequest){
        Admin p=adminService.getByName(authenticationRequest.getName());
        return p.toString();
    }
    @GetMapping("/test")
    public String test(){
        return "Admin Tested";
    }

    @RequestMapping("/getlogin")
    public String getAdminlogin(@RequestBody AuthenticationRequest authenticationRequest){
        Admin p=adminService.getByName(authenticationRequest.getName());
        return p.toString();
    }

    @RequestMapping("/getAll")
    public List<Admin> getAll(){
        return adminService.getAll();
    }


    @RequestMapping("/update")
    public String update(@RequestParam String id,@RequestParam String Name, @RequestParam String password) {
        Admin p = adminService.update(id,Name, password);
        return p.toString();
    }

    @RequestMapping("/admin/delete")
    public String delete(@RequestParam String firstName) {
        adminService.delete(firstName);
        return "Deleted "+firstName;
    }

    @RequestMapping ("/admin/deleteAll")
    public String deleteAll() {
        adminService.deleteAll();
        return "Deleted all records";
    }

}