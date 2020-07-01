package com.alphagfx.testrail;

public interface Projects {
 
    Project create(ProjectConfig config);

    Project get(int id);

    Iterable<Project> list();

    
    interface ProjectConfig {}
}