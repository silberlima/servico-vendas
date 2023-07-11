package com.silber.payment.adapters.out;

import com.silber.payment.adapters.out.repository.UserRepository;
import com.silber.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.silber.payment.application.core.domain.User;
import com.silber.payment.application.ports.out.FindUserByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindUserByIdAdapter implements FindUserByIdOutputPort {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> find(Integer id) {
        var userEntity = userRepository.findById(id);

        return userEntity.map(userEntityMapper::toUser);
    }
}
