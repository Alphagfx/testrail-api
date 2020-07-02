package com.alphagfx.testrail;

import java.io.IOException;

public interface Suite extends JsonReadable, JsonPatchable {

    Project project();


    int id();

    void delete() throws IOException;

    Cases cases();
}