package com.example.JS_HW3.service;

import com.example.JS_HW3.model.User;
import com.example.JS_HW3.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    /*Объект репозитория для работы с БД*/
    private final UserRepository userRepository;

    /*Конструктор*/
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById (Integer id){
        return userRepository.findUserById(id);
    }

    /* Получение списка всех пользователей*/
    public List<User> findAll(){
        return userRepository.findAll();
    }

    /**
     * Создание нового пользователя
     *
     * @param user объект пользователя
     */
    public void saveUser(User user) {
        userRepository.save( user );
    }

    /**
     * Удаление пользователя
     * @param id уникальный идентификатор пользователя
     */
    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    /**
     * Обновление данных пользователя
     * @param user объект пользователя с обновленными данными
     */
    public void updateUser(User user){
        userRepository.update(user);
    }
}
