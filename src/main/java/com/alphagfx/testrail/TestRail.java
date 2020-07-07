package com.alphagfx.testrail;

import java.io.IOException;

public interface TestRail {

    CaseFields caseFields();

    Iterable<CaseType> caseTypes() throws IOException;

    Iterable<Priority> priorities() throws IOException;

    Projects projects();

    Iterable<Status> statuses() throws IOException;

    Users users();
}