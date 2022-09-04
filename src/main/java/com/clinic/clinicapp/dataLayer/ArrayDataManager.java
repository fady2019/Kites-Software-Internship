package com.clinic.clinicapp.dataLayer;

import com.clinic.clinicapp.buisnessLayer.entities.Tool;
import com.clinic.clinicapp.buisnessLayer.entities.ToolCategory;

import java.util.ArrayList;

public class ArrayDataManager implements DataManager {

    private ArrayList<Tool> tools = new ArrayList<>();

    @Override
    public boolean addTool(Tool newTool) {

        if(tools.contains(newTool)) return false;
        tools.add(newTool);
        return true;
    }

    @Override
    public ArrayList<Tool> filterByCategory(ToolCategory category) {
        ArrayList<Tool> filteredTools = new ArrayList<>();
        for (Tool tool : tools){
            if(tool.getCategory().equals(category)){
                filteredTools.add(tool);
            }
        }
        return filteredTools;
    }

    @Override
    public Tool searchByName(String name) {
        for (Tool tool : tools){
            if (tool.getName().equals(name)){
                return tool;
            }
        }
        return null;
    }
}
