package com.clinic.clinicapp.buisnessLayer.logic.toolsManagement;
import java.util.ArrayList;

import com.clinic.clinicapp.buisnessLayer.entities.Tool;
import com.clinic.clinicapp.buisnessLayer.entities.ToolCategory;
import com.clinic.clinicapp.dataLayer.DataManager;
import com.clinic.clinicapp.dataLayer.ArrayDataManager;
import com.clinic.clinicapp.dataLayer.Database;

import java.util.ArrayList;

public class ToolsManager {
    private DataManager dataManager = new ArrayDataManager();
    //private DataManager dataManager = new Database();
    public boolean addTool(Tool tool) {
        return dataManager.addTool(tool);
    }
    public ArrayList<Tool> filterByPrice(int start, int end){ return dataManager.filterByPrice(start,end); }

    public ArrayList<Tool> filterByCategory(ToolCategory category){
        return dataManager.filterByCategory(category);
    }

    public Tool searchByName(String name){
        return dataManager.searchByName(name);
    }
    public void removeTool(long label)
    {
        dataManager.removeTool(label);
    }

}
