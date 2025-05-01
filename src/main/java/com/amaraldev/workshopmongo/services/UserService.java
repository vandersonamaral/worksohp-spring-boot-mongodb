package com.amaraldev.workshopmongo.services;

import com.amaraldev.workshopmongo.domain.User;
import com.amaraldev.workshopmongo.dto.UserDTO;
import com.amaraldev.workshopmongo.repository.UserRepository;
import com.amaraldev.workshopmongo.services.exception.ObjectNotFoundExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExeception("Objeto não encontrado"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User user){
        User newObjs = userRepository.findById(user.getId())
                .orElseThrow(() -> new ObjectNotFoundExeception("Objeto não encontrado"));
        updateData(newObjs,user);
        return userRepository.save(newObjs);
    }

    public void updateData(User newObjs, User user){
        newObjs.setName(user.getName());
        newObjs.setEmail(user.getEmail());
    }

    public User fromDto(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
