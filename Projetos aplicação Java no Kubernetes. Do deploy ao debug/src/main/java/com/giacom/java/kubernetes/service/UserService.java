package com.giacom.java.kubernetes.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.giacom.java.kubernetes.domain.User;
import com.giacom.java.kubernetes.persistence.UserRepository;

@Service
public class UserService { //Controle de usuários
    //Serviço do repositório do usuário
    private UserRepository userRepository;

    //Construtor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    //Cria um usuário no banco e salva
    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    //Busca um usuário por ID
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User not found with id:" + id)); //Caso falhe, informa que não foi encontrado
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    //Busca todos os usuários do banco
    public List<User> findAll() {
        List<User> people = new ArrayList<>(); //Variável auxiliar para listar os usuários
        Iterator<User> iterator = userRepository.findAll().iterator(); //Pega todos os usuários como uma lista Iterable
        iterator.forEachRemaining(people::add); //Adiciona os usuários à variável auxiliar
        return people; //Retorna a lista
    }

    @Transactional(propagation = Propagation.REQUIRED)
    //Deleta o usuário
    public void delete(User user) {
        userRepository.delete(user);
    }
}
