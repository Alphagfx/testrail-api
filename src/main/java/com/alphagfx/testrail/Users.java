package com.alphagfx.testrail;

import java.io.IOException;

public interface Users {

    User get(int id) throws IOException;

    Iterable<User> list() throws IOException;
}