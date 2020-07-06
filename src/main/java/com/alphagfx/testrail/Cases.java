package com.alphagfx.testrail;

import java.io.IOException;

public interface Cases {

    Case create(String title, int templateId) throws IOException;

    Case get(int id) throws IOException;

    Iterable<Case> list() throws IOException;
}