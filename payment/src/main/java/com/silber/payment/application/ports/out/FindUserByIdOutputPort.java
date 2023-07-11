package com.silber.payment.application.ports.out;

import com.silber.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> find(Integer id);
}
