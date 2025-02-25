package https.github.com.NiamaAqarail.backend.auth;


import https.github.com.NiamaAqarail.backend.config.JwtService;
import https.github.com.NiamaAqarail.backend.model.User;
import https.github.com.NiamaAqarail.backend.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationService(PasswordEncoder passwordEncoder, UserRepository userRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public String register(RegisterRequest request) {
        User user = new User(request.getUsername(), request.getEmail(), passwordEncoder.encode(request.getPassword()), "user");
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return jwtToken;
    }
    public String authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        return jwtService.generateToken(user);
    }
}
