package com.alphagfx.testrail;

public interface Sections {

	Section create(String name);

	Section get(int id);

	Iterable<Section> list();
}
