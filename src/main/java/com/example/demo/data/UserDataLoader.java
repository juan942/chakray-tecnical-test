package com.example.demo.data;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.utils.AesEncryptionUtil;
import com.example.demo.utils.DateTimeUtil;

import java.util.List;
import java.util.UUID;

public final class UserDataLoader {
    public static List<User> loadInitialUsers() {
        User userOne = new User(
                UUID.randomUUID(),
                "userOne@mail.com",
                "Usuario Prueba 1",
                "+15555555555",
                AesEncryptionUtil.encrypt("passwordOne"),
                "AARR990101XXX",
                DateTimeUtil.nowInMadagascar(),
                List.of(new Address(1L, "workaddressU1", "street No. 1", "UK"),
                        new Address(2L, "homeaddressU1", "street No. 2", "AU"))
        );
        User userTwo = new User(
                UUID.randomUUID(),
                "userTwo@mail.com",
                "Usuario Prueba 2",
                "+525555555555",
                AesEncryptionUtil.encrypt("passwordTwo"),
                "BERR990101XXX",
                DateTimeUtil.nowInMadagascar(),
                List.of( new Address(1L, "homeaddressU2", "street No. 332", "MX"))
        );
        User userThree = new User(
                UUID.randomUUID(),
                "userThree@mail.com",
                "Usuario Prueba 3",
                "+525512345678",
                AesEncryptionUtil.encrypt("passwordThree"),
                "CERR990101XXX",
                DateTimeUtil.nowInMadagascar(),
                List.of(new Address(1L, "officeaddressU3", "street No. 445", "US"))
        );

        return List.of(userOne, userTwo, userThree);
    }
}
