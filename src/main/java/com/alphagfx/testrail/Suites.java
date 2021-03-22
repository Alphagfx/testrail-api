package com.alphagfx.testrail;

public interface Suites {

    Suite create(String name);

    Suite get(int id);

    Iterable<Suite> list();
}
