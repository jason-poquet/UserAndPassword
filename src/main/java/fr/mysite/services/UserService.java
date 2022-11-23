package fr.mysite.services;
import fr.mysite.dto.LoginResponseDto;
import fr.mysite.dto.UserDto;


public interface UserService {

    UserDto getUserByName(String name);
    
    UserDto saveOrUpdate(UserDto uDto) throws Exception;
        
    LoginResponseDto checkLogin(UserDto udto) throws Exception;

}
