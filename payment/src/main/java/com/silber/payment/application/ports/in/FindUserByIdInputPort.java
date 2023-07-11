package com.silber.payment.application.ports.in;

import com.silber.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdInputPort {

    User find(Integer id);
}
