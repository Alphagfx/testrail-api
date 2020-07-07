package com.alphagfx.testrail;

import java.io.IOException;

public interface Cases {

    Case get(int id) throws IOException;

    Iterable<Case> list() throws IOException;
}