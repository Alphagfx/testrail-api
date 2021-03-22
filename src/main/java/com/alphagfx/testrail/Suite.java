package com.alphagfx.testrail;

public interface Suite extends JsonReadable, JsonPatchable {

    Project project();

    int id();

    void delete();

    Cases cases();
}
