package com.example.springdatajpaexample.service;

import com.example.springdatajpaexample.domain.User;
import com.example.springdatajpaexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User findUser(String email) {

        Optional<User> userOpt = userRepository.findById("kadun@gmail.com");

        userOpt.ifPresent(userRepository::delete);

        LocalDateTime createDate = LocalDateTime.now();

        User savedUser = userRepository.save(new User("kadun@gmail.com", "희나리", createDate));

        // page는 0부터 시작
        // 한 페이지에 10개 기준으로 두 번째 페이지 조회
        Pageable pageable = PageRequest.ofSize(10).withPage(1);

        // Sort 도 사용 가능
        Sort sort3 = Sort.by(Sort.Order.asc("name"), Sort.Order.desc("email"));
        Pageable pageable1 = PageRequest.ofSize(10).withPage(1).withSort(sort3);
        List<User> user3 = userRepository.findByNameLike("이름%", pageable);

        return savedUser;
    }
}
