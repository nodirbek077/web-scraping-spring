package uz.trading.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.trading.dto.AuthRequestDTO;
import uz.trading.dto.AuthResponseDTO;
import uz.trading.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Authentication operations")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login1")
    @Operation(summary = "Authorization", description = "API for login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Valid AuthRequestDTO dto) throws Exception {
        return ResponseEntity.ok(authService.login(dto));
    }
}
