package com.alphagfx.testrail;

import java.io.File;

public interface Test extends JsonReadable {

    Run run();


    int id();

    void assign(User assignee, String comment, Iterable<File> attachments);

    Result addResult(JsonReadable result);
}
