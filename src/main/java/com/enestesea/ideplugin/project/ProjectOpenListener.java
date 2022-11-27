package com.enestesea.ideplugin.project;

import com.esotericsoftware.kryo.NotNull;
import com.intellij.build.events.BuildEventsNls;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import com.intellij.openapi.ui.Messages;

public class ProjectOpenListener implements ProjectManagerListener {

    @Override
    public void projectOpened(Project project){
        if (ApplicationManager.getApplication().isUnitTestMode()){
            return;
        }
        DanilaService service = ApplicationManager.getApplication().getService(DanilaService.class);
        Messages.showMessageDialog("Aboba","Aboba", Messages.getInformationIcon());
    }

}
