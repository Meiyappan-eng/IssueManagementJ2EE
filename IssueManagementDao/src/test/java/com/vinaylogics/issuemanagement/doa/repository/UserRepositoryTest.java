package com.vinaylogics.issuemanagement.doa.repository;

import com.vinaylogics.issuemanagement.doa.core.exceptions.BaseException;
import com.vinaylogics.issuemanagement.doa.models.User;
import com.vinaylogics.issuemanagement.doa.repository.impl.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class helps to unit test {@link UserRepository}
 */
class UserRepositoryTest {

    private UserRepository repository;

    @BeforeEach
    void setUp() throws BaseException {
        repository = new UserRepositoryImpl();
    }

    @Test
    void testFindAll_ReturnsTheList() {
        List<User> users = null;
        try {
            users = repository.findAll();
        } catch (BaseException e) {
            e.printStackTrace();
            fail("Exception Not Expected");
        }

        assertNotNull(users);
        users.forEach(System.out::println);
    }

    @Test
    void testFindById_ReturnsTheUserObject() {
        Optional<User> user = Optional.empty();
        try {
            user = repository.findById(1);
        } catch (BaseException e) {
            e.printStackTrace();
            fail("Exception Not Expected");
        }
        assertTrue(user.isPresent());
        assertNotNull(user.get());
        System.out.println(user.get());
    }
}