package com.alphagfx.testrail;

import java.io.IOException;

public interface Case extends JsonReadable, JsonPatchable {

    Section section();


    int id();

    String title() throws IOException;

    int templateId() throws IOException;

    void delete() throws IOException;
}