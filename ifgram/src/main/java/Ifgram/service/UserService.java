package Ifgram.service;

import Ifgram.dto.UserRequest;
import Ifgram.dto.UserResponse;
import Ifgram.Model.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import Ifgram.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    // injeção de dependêcia pelo construtor
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserResponse cria(UserRequest request) throws Exception {
        // regra de negócios: o e-mail não pode repetir
        if (repository.existsByEmail(request.email())) {
            throw new Exception(request.email());
        }
        User salvo = repository.save(new User(request.nome(), request.email()));
        return UserResponse.from(salvo);
    }

    public UserResponse atualizarUsuario (UserRequest request) throws Exception {
        Optional <User> usuario = repository.findByEmail (request.email());
        if (usuario.isEmpty()){
            throw new Exception("usuário não existe na base de dados.");
    }
        User usuarioSalvo = usuario.get();
        usuarioSalvo.setNome (request.nome());
        repository.save (usuarioSalvo);

        return UserResponse.from(usuarioSalvo);
    }
    public void deletarUsuario (UserRequest request) throws Exception {
        Optional<User> usuario = repository.findByEmail(request.email());
        if(usuario.isEmpty()) {
            throw new Exception("Usuário não encontrado!");
        }

        User usuarioDeletar = usuario.get();
        usuarioDeletar.setNome(request.nome());
        repository.delete(usuarioDeletar);


    }
}




