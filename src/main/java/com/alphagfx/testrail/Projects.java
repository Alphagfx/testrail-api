package com.alphagfx.testrail;

public interface Projects {

    Project create(String name, int suiteMode);

    Project get(int id);

    Iterable<Project> list();
}
