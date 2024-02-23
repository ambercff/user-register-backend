package com.example.userregister.controller;

import com.example.userregister.dto.UserRecordDTO;
import com.example.userregister.model.UserModel;
import com.example.userregister.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserRepository repository;

    @CrossOrigin(origins="*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<UserModel> saveProduct(@RequestBody @Valid UserRecordDTO productRecordDto) {
        var userModel = new UserModel(); //iniciando o model

        BeanUtils.copyProperties(productRecordDto, userModel); //convertendo o dto para model, o método copyProperties recebe como parâmetro o objeto a ser convertido e para o que será convertido

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(userModel)); //retorna o status da ação e coloca no body o objeto convertido
    }

    @CrossOrigin(origins="*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        List<UserModel> userList = repository.findAll();

        if  (!userList.isEmpty()) {
            for (UserModel user: userList){
                UUID ID = user.getIdUser();
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }
}
