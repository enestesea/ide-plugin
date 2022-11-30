package com.enestesea.ideplugin.project;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import org.jetbrains.annotations.NotNull;

public class ShowAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        if (ApplicationManager.getApplication().isUnitTestMode()){
            return;
        }
        DanilaService service = ApplicationManager.getApplication().getService(DanilaService.class);
        service.display();
    }

    @Override
    public boolean isDumbAware(){
        return false;
    }
}
