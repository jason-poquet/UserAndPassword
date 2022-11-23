package fr.mysite.services;

import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.mysite.dto.ComplianceDto;
import fr.mysite.entities.Compliance;
import fr.mysite.tools.DtoTools;
/**
 * Service for verify the password compliance
 * @author Admin stagiaire
 *
 */
@Service
@Transactional
public class ComplianceServiceImpl implements ComplianceService {
    
    private static final String ONE_DIGIT_PATTERN = "(?=.*[0-9])";
    private static final String UPPER_CASE_PATTERN = "(?=.*[A-Z])";
    private static final String EIGHT_CHARS_PATTERN = ".{8,}" ;
    private static final String SPECIAL_CHAR_PATTERN = "(?=.*[@$!%*#?&])";
    private static final String MESSAGE_ONE_DIGIT = "Password must contain at least one digit [0-9].";
    private static final String MESSAGE_UPPER_CASE = "Password must contain at least one uppercase character [A-Z].";
    private static final String MESSAGE_EIGHT_CHARS = "Password must contain a length of at least 8 characters";
    private static final String MESSAGE_SPECIAL_CHARS = "Password must contain at least one special character like ! @ # & ( ).";

    /**
     * method to verify the compliance with patterns and return a ComplianceDto object
     */
    @Override
    public ComplianceDto verifyCompliance(String password) {
        Compliance c = new Compliance();
        boolean b= true;
        String message = "";
        if(!isMatchPattern(password,ONE_DIGIT_PATTERN)) {
            b = false;
            message += MESSAGE_ONE_DIGIT;
        }
        if(!isMatchPattern(password,UPPER_CASE_PATTERN)) {
            b = false;
            message += MESSAGE_UPPER_CASE;
        }
        if(!isMatchPattern(password,EIGHT_CHARS_PATTERN)) {
            b = false;
            message += MESSAGE_EIGHT_CHARS;
        }
        if(!isMatchPattern(password,SPECIAL_CHAR_PATTERN)) {
            b = false;
            message += MESSAGE_SPECIAL_CHARS;
        }
            c.setReason(message);
            c.setValid(b);
        return DtoTools.convert(c, ComplianceDto.class);
    }
    /**
     * method to verify if password match with a pattern
     * @param password the password to verify
     * @param pattern the pattern
     * @return true if it match, false if it doesn't match
     */
    private boolean isMatchPattern(String password, String pattern) {
        return Pattern.compile(pattern)
                .matcher(password)
                .find();
    }
}
