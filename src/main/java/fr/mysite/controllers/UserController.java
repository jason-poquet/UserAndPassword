package fr.mysite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.mysite.dto.LoginResponseDto;
import fr.mysite.dto.UserDto;
import fr.mysite.services.UserService;
/**
 * Controller for create, get and login user
 * @author Jason POQUET
 *
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    /**
     * user service
     */
    @Autowired
    private UserService userService;
    
    /**
     * Get http method to get a user by name
     * @param name the name of the user
     * @return a user
     */
    @GetMapping(produces = "application/json",value="/{name}")
    public UserDto getUserByName(@PathVariable("name") String name) {
        return userService.getUserByName(name);
    }
    
    /**
     * POST http method to save a user
     * @param uDto the user to save
     * @return http status created
     * @throws Exception when the password doesn't respect the compliance
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDto> save(@RequestBody UserDto uDto) throws Exception {
        UserDto result = userService.saveOrUpdate(uDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    
    /**
     * POST method to login
     * @param uDto the user to login
     * @return 
     * @throws Exception
     */
    @PostMapping(value="/login/verify", consumes="application/json", produces="application/json")
    public LoginResponseDto checkLogin(@RequestBody UserDto uDto) throws Exception {
           return userService.checkLogin(uDto);
    }
    
}
