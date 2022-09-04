package com.clinic.clinicapp.buisnessLayer.logic.toolsManagement;
import com.clinic.clinicapp.buisnessLayer.entities.Tool;
import com.clinic.clinicapp.dataLayer.DataManager;
import com.clinic.clinicapp.dataLayer.ArrayDataManager;

import java.util.ArrayList;

public class ToolsManager {
    private DataManager dataManager = new ArrayDataManager();

    public boolean addTool(Tool tool) {
        return dataManager.addTool(tool);
    }
    public ArrayList<Tool> filterByPrice(int start, int end){ return dataManager.filterByPrice(start,end); }

}
