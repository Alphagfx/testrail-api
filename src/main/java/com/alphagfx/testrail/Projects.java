package com.alphagfx.testrail;

import java.io.IOException;

public interface Projects {

    Project create(String name, int suiteMode) throws IOException;

    Project get(int id) throws IOException;

    Iterable<Project> list() throws IOException;
}