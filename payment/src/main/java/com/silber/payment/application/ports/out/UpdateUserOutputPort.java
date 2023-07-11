package com.silber.payment.application.ports.out;

import com.silber.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);
}

