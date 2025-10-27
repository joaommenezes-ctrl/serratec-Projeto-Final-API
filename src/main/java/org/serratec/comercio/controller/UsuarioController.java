package org.serratec.comercio.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.comercio.domain.Usuario;
import org.serratec.comercio.dto.LoginDTO;
import org.serratec.comercio.dto.UsuarioDTO;
import org.serratec.comercio.dto.UsuarioInserirDTO;
import org.serratec.comercio.repository.UsuarioRepository;
import org.serratec.comercio.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getUsername(),
                            loginDTO.getPassword()
                    )
            );

            Usuario usuario = (Usuario) authentication.getPrincipal();
            String token = jwtUtil.generateToken(usuario.getUsername());

            return ResponseEntity.ok().body("Bearer " + token);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
        }
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody UsuarioInserirDTO dto) {

        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getPassword()));


        usuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuariosDTO.add(new UsuarioDTO(usuario));
        }
        return ResponseEntity.ok(usuariosDTO);
    }
}
