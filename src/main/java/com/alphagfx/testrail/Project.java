package com.alphagfx.testrail;

import java.io.IOException;

import org.json.JSONObject;

public interface Project extends JsonReadable, JsonPatchable {

    int SINGLE_SUITE = 1;
    int SINGLE_SUITE_AND_BASELINES = 2;
    int MULTIPLE_SUITES = 3;


    TestRail testrail();

    int id();

    void delete() throws IOException;

    Runs runs();

    Plans plans();

    Suites suites();

    Iterable<Template> templates() throws IOException;


    final class Smart implements Project {

        private final Project project;


        public Smart(Project project) {
            this.project = project;
        }


        @Override
        public TestRail testrail() {
            return project.testrail();
        }

        @Override
        public int id() {
            return project.id();
        }

        @Override
        public void delete() throws IOException {
            project.delete();
        }

        public String name() throws IOException {
            return json().getString("name");
        }

        @Override
        public Runs runs() {
            return project.runs();
        }

        @Override
        public Plans plans() {
            return project.plans();
        }

        @Override
        public Suites suites() {
            return project.suites();
        }

        @Override
        public Iterable<Template> templates() throws IOException {
            return project.templates();
        }

        @Override
        public JSONObject json() throws IOException {
            return project.json();
        }

        @Override
        public void patch(JSONObject json) throws IOException {
            project.patch(json);
        }
    }
}