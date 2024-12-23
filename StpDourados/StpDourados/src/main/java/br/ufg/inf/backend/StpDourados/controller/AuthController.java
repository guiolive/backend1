package br.ufg.inf.backend.StpDourados.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.backend.StpDourados.domain.user.User;
import br.ufg.inf.backend.StpDourados.dto.LoginRequestDTO;
import br.ufg.inf.backend.StpDourados.dto.RegisterRequestDTO;
import br.ufg.inf.backend.StpDourados.dto.ResponseDTO;
import br.ufg.inf.backend.StpDourados.infra.security.TokenService;
import br.ufg.inf.backend.StpDourados.repository.UserRepository;


@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private final UserRepository repository = null;
	@Autowired
	private final PasswordEncoder passwordEncoder = null;
	@Autowired
	private final TokenService tokenService = null;
	
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body) {
		User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
		if(passwordEncoder.matches(body.password(), user.getPassword())) {
			String token = this.tokenService.generateToken(user);
			return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
	    }
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body) {
		Optional<User> user = this.repository.findByEmail(body.email());
		
		if(user.isEmpty()) {
			User newUser = new User();
			newUser.setPassword(passwordEncoder.encode(body.password()));
			newUser.setEmail(body.email());
			newUser.setName(body.name());
			this.repository.save(newUser);
		
			String token = this.tokenService.generateToken(newUser);
			return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
	    }
		return ResponseEntity.badRequest().build();
	}

}
