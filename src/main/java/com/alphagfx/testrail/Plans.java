package com.alphagfx.testrail;

import java.io.IOException;

interface Plans {

    Plan create(/* todo verify number of required parameters */) throws IOException;

    Plan get(int id);

    //todo how to use internal filters?
    Iterable<Plan> list() throws IOException;
}