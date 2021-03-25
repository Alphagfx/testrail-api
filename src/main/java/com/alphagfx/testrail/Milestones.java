package com.alphagfx.testrail;

public interface Milestones {

	Milestone create(JsonReadable milestoneConfig);

	Iterable<Milestone> list();
}
