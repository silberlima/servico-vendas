package com.silber.payment.adapters.out;

import com.silber.payment.adapters.out.repository.UserRepository;
import com.silber.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.silber.payment.application.core.domain.User;
import com.silber.payment.application.ports.out.UpdateUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserAdapter implements UpdateUserOutputPort {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public void update(User user) {
        var userEntity = userEntityMapper.toUserEntity(user);
        userRepository.save(userEntity);
    }
}
