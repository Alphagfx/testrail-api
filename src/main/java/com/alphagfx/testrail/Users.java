package com.alphagfx.testrail;

public interface Users {

    User get(int id);

    Iterable<User> list();
}
