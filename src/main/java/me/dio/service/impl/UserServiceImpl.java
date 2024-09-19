package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new); // Caso o id buscado não seja, sera
                                                                                     // lançado uma exception
    }

    @Override
    public User create(User userToCreate) {

        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("Esse numero de conta de usuario ja existe");
        }
        return userRepository.save(userToCreate);
    }

}
