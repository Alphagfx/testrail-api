package com.alphagfx.testrail;

import java.io.IOException;

public interface Milestones {

    Milestone create(JsonReadable milestoneConfig) throws IOException;

    Iterable<Milestone> list() throws IOException;
}
