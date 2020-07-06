package com.alphagfx.testrail;

import java.io.IOException;

public interface Sections {

    Section create(String name) throws IOException;

    Section get(int id) throws IOException;

    Iterable<Section> list() throws IOException;
}