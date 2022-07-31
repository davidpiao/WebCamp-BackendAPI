package com.rest.api.service;


import com.rest.api.common.APIResponse;
import com.rest.api.dto.LoginRequestDTO;
import com.rest.api.dto.SignUpRequestDTO;
import com.rest.api.model.User;
import com.rest.api.repository.UserRepository;
import com.rest.api.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;

    public APIResponse signUp(SignUpRequestDTO signUpRequestDTO) {
        APIResponse apiResponse = new APIResponse();

        // validation

        // dto to entity
        User userEntity = new User();
        userEntity.setName(signUpRequestDTO.getName());
        userEntity.setUser(signUpRequestDTO.getEmailId());
        userEntity.setPwd(signUpRequestDTO.getPassword());

        // store entity
        userEntity = userRepository.save(userEntity);

        // generate jwt
        String token = jwtUtils.generateJwt(userEntity);

        Map<String , Object> data = new HashMap<>();
        data.put("accessToken", token);

        apiResponse.setData(data);

        // return
        return apiResponse;
    }

    public APIResponse login(LoginRequestDTO loginRequestDTO) {

        APIResponse apiResponse = new APIResponse();

        // validation

        // verify user exist with given email and password
        User user = userRepository.findOneByEmailIdIgnoreCaseAndPassword(loginRequestDTO.getEmailId(), loginRequestDTO.getPassword());

        // response
        if(user == null){
            apiResponse.setData("User login failed");
            return apiResponse;
        }

        // generate jwt
        String token = jwtUtils.generateJwt(user);

        Map<String , Object> data = new HashMap<>();
        data.put("accessToken", token);

        apiResponse.setData(data);

        return apiResponse;
    }
}
