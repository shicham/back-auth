package com.crm.controller;


import com.crm.commun.exceptions.WebException;
import com.crm.commun.results.Response;
import com.crm.forms.RegistreForm;
import com.crm.services.RegistreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class RegistreController {
    @Autowired
    private RegistreService registreService;

    /**
     * registration
     * @param registre
     * @return
     * @throws WebException
     */
    @PostMapping(value = "/registre", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Response registre(@RequestBody RegistreForm registre)  throws WebException {
        return registreService.register(registre.getUsername(),registre.getPassword(), registre.getSource());
    }

}