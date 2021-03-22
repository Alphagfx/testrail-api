package com.alphagfx.testrail;

public interface Plan extends JsonReadable, JsonPatchable {

    TestRail testrail();


    int id();


    void close();

    void delete();

    Entry create(JsonReadable entryConfig); //todo verify number of required parameters

    Iterable<Entry> entries();


    interface Entry extends JsonReadable, JsonPatchable {

        Plan plan();


        int id();

        void delete();

        Runs runs();
    }
}
