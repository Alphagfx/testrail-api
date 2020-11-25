package com.alphagfx.testrail;

import java.io.File;
import java.io.IOException;

public interface Test extends JsonReadable {

    Run run();


    int id();

    void assign(User assignee, String comment, Iterable<File> attachments) throws IOException;

    Result addResult(JsonReadable result) throws IOException;
}
