package com.alphagfx.testrail;

import java.io.IOException;

public interface Plan extends JsonReadable, JsonPatchable {

    TestRail testrail();


    int id();


    void close() throws IOException;

    void delete() throws IOException;

    //todo verify number of required parameters
    Entry create(JsonReadable entryConfig) throws IOException;

    Iterable<Entry> entries();


    interface Entry extends JsonReadable, JsonPatchable {

        Plan plan();


        int id();

        void delete() throws IOException;

        Runs runs();
    }
}
