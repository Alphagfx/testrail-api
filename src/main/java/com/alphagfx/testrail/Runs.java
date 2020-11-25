package com.alphagfx.testrail;

import java.io.IOException;

public interface Runs {

    Run create(/* todo verify number of required parameters */) throws IOException;

    Run get(int id) throws IOException;

    Iterable<Run> list() throws IOException;
}