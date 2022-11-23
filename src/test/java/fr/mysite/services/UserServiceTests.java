package fr.mysite.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.mysite.dto.ComplianceDto;
import fr.mysite.dto.UserDto;
import fr.mysite.entities.Compliance;
import fr.mysite.entities.User;
import fr.mysite.repositories.UserRepository;
import fr.mysite.tools.DtoTools;
import fr.mysite.tools.JwtTokenUtil;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    UserRepository mockRepo;
    
    
    @Spy
    ComplianceService complianceService;
    
    
    @Mock
    JwtTokenUtil jwtTokenUtil;
    
    @InjectMocks
    UserServiceImpl userServiceImpl;
    
    
    
    List<User> users;
    
    User user;
    
    UserDto userDto;
    
    MockedStatic<DtoTools> dtoToolStatic ;
    
    ComplianceDto complianceDto;
    
    Compliance compliance;
    
    
    @BeforeEach
    public void init() {
        users = new ArrayList<User>();
        user = new User("user1","0000000000","Secret1+");
        userDto = new UserDto("user1","0000000000","Secret1+");
        compliance = new Compliance(true,"");
        complianceDto = new ComplianceDto(true,"");
        users.add(user);
        try {
            dtoToolStatic= Mockito.mockStatic(DtoTools.class);
            dtoToolStatic.when(() -> DtoTools.convert(complianceDto, Compliance.class)).thenReturn(compliance);
            dtoToolStatic.when(() -> DtoTools.convert(compliance, ComplianceDto.class)).thenReturn(complianceDto);
            dtoToolStatic.when(() -> DtoTools.convert(userDto, User.class)).thenReturn(user);
            dtoToolStatic.when(() -> DtoTools.convert(user, UserDto.class)).thenReturn(userDto);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    @AfterEach
    public void clean() {
        dtoToolStatic.close();
    }
    
    @Test
    public void save_test() throws Exception {
        when(complianceService.verifyCompliance(user.getPassword())).thenReturn(complianceDto);
        when(mockRepo.saveAndFlush(user)).thenReturn(user);
        UserDto savedU  = userServiceImpl.saveOrUpdate(userDto);
        assertEquals("user1", savedU.getName());
    }
    
    @Test
    public void getByName_test() throws Exception {
        
        when(mockRepo.findUserByName(user.getName())).thenReturn(user);
        UserDto uDto = userServiceImpl.getUserByName("user1");
        assertEquals("user1", uDto.getName());
    }
    
}
