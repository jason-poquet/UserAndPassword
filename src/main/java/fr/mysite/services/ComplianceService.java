package fr.mysite.services;

import fr.mysite.dto.ComplianceDto;

public interface ComplianceService {
    ComplianceDto verifyCompliance(String password);
}
