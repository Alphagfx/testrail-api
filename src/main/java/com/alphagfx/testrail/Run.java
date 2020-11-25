package com.alphagfx.testrail;

import java.io.IOException;

public interface Run extends JsonReadable, JsonPatchable {

    Project project();

    int id();

    void close() throws IOException;

    void delete() throws IOException;

    Iterable<Test> tests() throws IOException;
}
