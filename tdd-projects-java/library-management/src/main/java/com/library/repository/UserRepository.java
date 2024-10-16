package com.library.repository;

import com.library.model.User;

public interface UserRepository {
    User findById(String id);
    User save(User user);
    User update(User user);
    void delete(User user);
}
