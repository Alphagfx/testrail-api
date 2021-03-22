package com.alphagfx.testrail;

public interface TestRail {

    CaseFields caseFields();

    Iterable<CaseType> caseTypes();

    Iterable<Priority> priorities();

    Projects projects();

    Iterable<Status> statuses();

    Users users();
}
