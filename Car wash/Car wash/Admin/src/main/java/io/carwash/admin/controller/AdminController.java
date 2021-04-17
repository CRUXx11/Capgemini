package io.carwash.admin.controller;

import io.carwash.admin.model.Admin;
import io.carwash.admin.model.AuthenticationRequest;
import io.carwash.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/testing")
    public RedirectView testing() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:4200/admin");
        return redirectView;
    }

    @CrossOrigin(origins="*",allowedHeaders = "*")
    @GetMapping("/test")
    public String test(){
        return "working";
    }

    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/get")
    public Admin getAdmin(@RequestBody AuthenticationRequest authenticationRequest){
        Admin p=adminService.getByEmail(authenticationRequest.getEmail());
        return p;
    }
    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/getlogin")
    public String getAdmin(@RequestParam String email) {
        Admin p = adminService.getByEmail(email);
        return p.toString();
    }

    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/getAll")
    public List<Admin> getAll(){
        return adminService.getAll();
    }

    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/update")
    public String update(@RequestBody Admin req) {
        Admin p = adminService.update(req.getName(),req.getPassword(), req.getEmail(),req.getContact());
        return p.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName) {
        adminService.delete(firstName);
        return "Deleted "+firstName;
    }

    @RequestMapping ("/deleteAll")
    public String deleteAll() {
        adminService.deleteAll();
        return "Deleted all records";
    }

}