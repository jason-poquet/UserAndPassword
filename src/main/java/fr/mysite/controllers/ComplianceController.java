package fr.mysite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.mysite.dto.ComplianceDto;
import fr.mysite.services.ComplianceService;

@RestController
@RequestMapping(value="/api/compliance")
public class ComplianceController {
    
    @Autowired
    private ComplianceService complianceService;

    @GetMapping(produces = "application/json",value="/password/{password}")
    public ComplianceDto verifyCompliance(@PathVariable("password") String password) {
         return complianceService.verifyCompliance(password);
    }
}
