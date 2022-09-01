package com.clinic.clinicapp.buisnessLayer.logic.toolsManagement;
import com.clinic.clinicapp.buisnessLayer.entities.Tool;
import com.clinic.clinicapp.dataLayer.DataManager;
import com.clinic.clinicapp.dataLayer.ArrayDataManager;

public class ToolsManager {
    private DataManager dataManager=new ArrayDataManager();

    public boolean addTool(Tool tool) {
        return dataManager.addTool(tool);
    }

}
