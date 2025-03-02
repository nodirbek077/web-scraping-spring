package uz.trading.service;

import org.springframework.stereotype.Service;
import uz.trading.dto.AuthRequestDTO;
import uz.trading.dto.AuthResponseDTO;
import uz.trading.utils.JwtUtil;

@Service
public class AuthService {


    public AuthResponseDTO login(AuthRequestDTO dto) throws Exception {

        if (dto.getUsername() == null || dto.getPassword() == null) {
            throw new Exception(" Email or Password wrong");
        }
        if (!"scraping_app123".equals(dto.getPassword())) {
            throw new Exception(" Email or Password wrong");
        }

        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setToken(JwtUtil.encode(dto.getUsername(), dto.getPassword()));
        return authResponseDTO;
    }
}
