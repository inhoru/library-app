package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.reponse.UserResponse;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //아래 있는 함수가 시작될때 start transaction;을 해준다.(트랜잭션 시작!)
    //함수가 예외없이 잘끝낫다면 commit
    //혹시라도 문제가 있다면 rollback
    @Transactional
    public void saveUser(UserCreateRequest request){
        //insert sql이 자동으로 나간다.
        userRepository.save(new User(request.getName(), request.getAge()));
    }

//    public List<UserResponse> getUsers(){
//     return userRepository.findAll()
//        .stream().map(user -> new UserResponse(user.getId(),new User(user.getName(),user.getAge())))
//             .collect(Collectors.toList());
//
//    }
@Transactional(readOnly = true)
    public List<UserResponse> getUsers(){
        return userRepository.findAll()
                .stream().map(UserResponse::new)
                .collect(Collectors.toList());

    }
    @Transactional
    public void updateUser(UserUpdateRequest request){
        //select * from user where id = ?;
        //Optinal<User>
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
        userRepository.save(user);
    }
    @Transactional
    public void deleteUser(String name){

        User user = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
        userRepository.delete(user);
    }

}
