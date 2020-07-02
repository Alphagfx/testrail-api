package com.alphagfx.testrail;

import java.io.IOException;

public interface Suites {

    Project project();


    Suite create(String name) throws IOException;

    Suite get(int id) throws IOException;

    Iterable<Suite> list() throws IOException;
}