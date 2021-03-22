package com.alphagfx.testrail;

import org.json.JSONObject;

public interface Project extends JsonReadable, JsonPatchable {

    int SINGLE_SUITE = 1;
    int SINGLE_SUITE_AND_BASELINES = 2;
    int MULTIPLE_SUITES = 3;


    TestRail testrail();

    int id();

    void delete();

    Runs runs();

    Plans plans();

    Suites suites();

    Iterable<Template> templates();

    Milestones milestones();


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
        public void delete() {
            project.delete();
        }

        public String name() {
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
        public Iterable<Template> templates() {
            return project.templates();
        }

        @Override
        public Milestones milestones() {
            return project.milestones();
        }

        @Override
        public JSONObject json() {
            return project.json();
        }

        @Override
        public void patch(JSONObject json) {
            project.patch(json);
        }
    }
}
