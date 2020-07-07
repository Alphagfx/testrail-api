package com.alphagfx.testrail;

import java.io.IOException;

public interface Section extends JsonReadable, JsonPatchable {

    Suite suite();


    int id();

    void delete() throws IOException;

    Section createSection(String name) throws IOException;

    Case createCase(String title, int templateId) throws IOException;

    Cases cases();
}