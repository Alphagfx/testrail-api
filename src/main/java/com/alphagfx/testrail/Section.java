package com.alphagfx.testrail;

import java.io.IOException;

public interface Section extends JsonReadable, JsonPatchable {

    Suite suite();


    int id();

    void delete() throws IOException;

    Section create(String name) throws IOException;

    Cases cases() throws IOException;
}