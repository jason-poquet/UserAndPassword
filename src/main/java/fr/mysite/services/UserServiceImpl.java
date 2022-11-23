package fr.mysite.services;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.mysite.dto.ComplianceDto;
import fr.mysite.dto.LoginResponseDto;
import fr.mysite.dto.UserDto;
import fr.mysite.entities.User;
import fr.mysite.repositories.UserRepository;
import fr.mysite.tools.DtoTools;
import fr.mysite.tools.HashTools;
import fr.mysite.tools.JwtTokenUtil;
import fr.mysite.tools.TokenSaver;

/**
 * 
 * @author Admin stagiaire
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    /**
     * the repository to communicate with db
     */
    @Autowired
    private UserRepository userRepository;
    
    /**
     * Tool to generate the token
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    /**
     * Service to verify the password compliance 
     */
    @Autowired
    private ComplianceService complianceService;

    /**
     * Get a user by name
     */
    @Override
    public UserDto getUserByName(String name) {
        User u = userRepository.findUserByName(name);
        
        return DtoTools.convert(u, UserDto.class);
    }

    /**
     * Save or update a user
     */
    @Override
    public UserDto saveOrUpdate(UserDto uDto) throws Exception {
        User u = DtoTools.convert(uDto, User.class);
        
            if (u.getId() == 0) { // insertion
                ComplianceDto cDto = complianceService.verifyCompliance(u.getPassword());
                if(!cDto.isValid()) {
                    throw new Exception(cDto.getReason());
                }
                u.setPassword(HashTools.hashSHA512(u.getPassword()));
            } else { // modif
                UserDto userInDb = getUserByName(u.getName());
                if(!userInDb.getPassword().contentEquals(u.getPassword())) {
                    u.setPassword(HashTools.hashSHA512(u.getPassword()));
                }
            }

        u = userRepository.saveAndFlush(u);
        return DtoTools.convert(u, UserDto.class);
    }

    /**
     * check if name and password match with the user's login informations in DB
     */
    @Override
    public LoginResponseDto checkLogin(UserDto udto) throws Exception {
        User u = userRepository.findUserByName(udto.getName());
        if(u!=null && u.getPassword().equals(HashTools.hashSHA512(udto.getPassword()))) {
            LoginResponseDto result = DtoTools.convert(u, LoginResponseDto.class);
            //generate JWT TOKEN
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put("user_id", u.getId());
            claims.put("user_name", u.getName());
            claims.put("user_pwd", u.getPassword().toString());
            
            String token = jwtTokenUtil.doGenerateToken(claims , udto.getName());
            TokenSaver.tokensByName.put(u.getName(), token);
            //générer le token
            //le sauvegarder côté service pour pouvoir le vérifier lors des prochaines requêtes
            result.setToken(token);
            return result;
        }else
            throw new Exception("Error : invalid credentials !");
    }

}
