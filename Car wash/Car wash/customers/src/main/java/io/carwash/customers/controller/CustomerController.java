package io.carwash.customers.controller;

import io.carwash.customers.model.AuthenticationRequest;
import io.carwash.customers.model.AuthenticationResponse;
import io.carwash.customers.model.Customer;
import io.carwash.customers.service.CustomerService;
import io.carwash.customers.util.JwtUtil;
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

    @RequestMapping("/create")
    public String create(@RequestBody Customer customer) {
        Customer p = customerService.create(customer);
        return p.toString();
    }

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
    @RequestMapping("/get")
    public String getCustomer(@RequestBody AuthenticationRequest authenticationRequest){
        Customer p=customerService.getByEmail(authenticationRequest.getEmail());
        return p.toString();
    }


    @RequestMapping("/getAll")
    public List<Customer> getAll(){
        return customerService.getAll();
    }


    @RequestMapping("/update")
    public String update(@RequestParam String Name, @RequestParam String password,@RequestParam String email,@RequestParam String contact) {
        Customer p = customerService.update(Name, password,email,contact);
        return p.toString();
    }

//    @RequestMapping("/admin/delete")
//    public String delete(@RequestParam String firstName) {
//        customerService.delete(firstName);
//        return "Deleted "+firstName;
//    }

//    @RequestMapping ("/admin/deleteAll")
//    public String deleteAll() {
//        customerService.deleteAll();
//        return "Deleted all records";
//    }

}