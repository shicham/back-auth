package com.crm.controller;


import com.crm.commun.exceptions.WebException;
import com.crm.commun.results.Response;
import com.crm.forms.Login;
import com.crm.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Response login(@RequestBody Login login)  throws WebException {
        return authService.login(login.getUsername(),login.getPassword(), login.getSource());
    }

}