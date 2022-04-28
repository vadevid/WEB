package com.service;

import com.dto.*;
import com.repository.UserRepository;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;


import java.util.List;
import java.util.Locale;

@Singleton
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    public void main() {
        userRepository.getUserList().add(new User(1,"Кислицын Иван Александрович", 20, "kislitsun-van@mail.ru", "vadevid", "pass"));
        userRepository.getUserList().add(new User(2,"Широков Дмитрий Романович", 19, "chort@mail.ru", "chort", "pass"));
        userRepository.getUserList().add(new User(3,"Бессонов Иван Анатольевич", 3, "bida@mail.ru", "bida", "pass"));
    }

    @Override
    public GetUserByIdRsDto getById(int id) {
        for (Integer ur=0; ur<userRepository.getUserList().size(); ur++){
            if (id == ur+1){
                GetUserByIdRsDto user = new GetUserByIdRsDto();
                user.setUser(userRepository.getUserList().get(ur));
                return user;
                //return GetUserByIdRsDto.builder().user(userRepository.getUserList().get(ur)).build();
            }
        }
        return null;
    }

    @Override
    public List<User> getList() {
        return userRepository.getUserList();
    }

    @Override
    public LoginRsDto Verification(LoginRqDto loginRqDto) {
        boolean ver = false;
        String rqLogin = loginRqDto.getLogin();
        String rqPassword = loginRqDto.getPassword();

        for (User ur : userRepository.getUserList())
        {
            String userLogin =  ur.getLogin();
            String userPassword =  ur.getPassword();

            if (rqLogin.equals(userLogin)){
                if (rqPassword.equals(userPassword) ){
                    ver = true;
                }
            }
        }
        LoginRsDto loginRsDto = new LoginRsDto();
        loginRsDto.setVerification(ver);
        return loginRsDto;
        //return LoginRsDto.builder().verification(ver).build();
    }

    @Override
    public RegistrationRsDto Registration(RegistrationRqDto registrationRqDto) {
        boolean ver = true;
        String rqLogin = registrationRqDto.getLogin().toLowerCase(Locale.ROOT);
        String rqEmail = registrationRqDto.getEmail().toLowerCase(Locale.ROOT);

        for (User ur : userRepository.getUserList())
        {
            String userLogin =  ur.getLogin().toLowerCase(Locale.ROOT);
            String userEmail =  ur.getEmail().toLowerCase(Locale.ROOT);

            if (rqLogin.equals(userLogin) || rqEmail.equals(userEmail)) {
                ver = false;
            }
        }
        RegistrationRsDto registrationRsDto = new RegistrationRsDto();
        registrationRsDto.setVerification(ver);
        return registrationRsDto;
        //return RegistrationRsDto.builder().verification(ver).build();
    }
}
