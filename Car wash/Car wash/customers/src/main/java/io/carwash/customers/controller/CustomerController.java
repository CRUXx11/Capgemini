package io.carwash.customers.controller;

import io.carwash.customers.model.AuthenticationRequest;
import io.carwash.customers.model.AuthenticationResponse;
import io.carwash.customers.model.Customer;
import io.carwash.customers.service.CustomerService;
import io.carwash.customers.util.JwtUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Api
@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthenticationManager authenticationManager;

    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/create")
    public String create(@RequestBody Customer customer) {
        Customer p = customerService.create(customer);
        return p.toString();
    }

    @GetMapping("/testing")
    public RedirectView testing() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:4200/admin");
        return redirectView;
    }

    @CrossOrigin(origins="*",allowedHeaders = "*")
    @PostMapping("/authenticate")
    private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        String email=authenticationRequest.getEmail();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        }catch (Exception e){
            return ResponseEntity.ok(new AuthenticationResponse("Invalid Username or Password")) ;
        }
        UserDetails loadedUser=customerService.loadUserByUsername(email);
        String generatedToken =jwtUtil.generateToken(loadedUser);
        return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
    }
    @CrossOrigin(origins="*",allowedHeaders = "*")
    @GetMapping("/test")
    public String test(){
        return "working";
    }

    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/get")
    public Customer getCustomer(@RequestBody AuthenticationRequest authenticationRequest){
        Customer p=customerService.getByEmail(authenticationRequest.getEmail());
        return p;
    }
    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/getlogin")
    public String getCustomer(@RequestParam String email) {
        Customer p = customerService.getByEmail(email);
        return p.toString();
    }

    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/getAll")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/update")
    public String update(@RequestParam String Name, @RequestParam String password,@RequestParam String email,@RequestParam String contact) {
        Customer p = customerService.update(Name, password,email,contact);
        return p.toString();
    }

}