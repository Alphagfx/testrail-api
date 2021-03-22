package com.alphagfx.testrail;

public interface Runs {

    Run create(/* todo verify number of required parameters */);

    Run get(int id);

    Iterable<Run> list();
}
