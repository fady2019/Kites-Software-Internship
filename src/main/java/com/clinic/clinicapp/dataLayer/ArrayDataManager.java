package com.clinic.clinicapp.dataLayer;

import com.clinic.clinicapp.buisnessLayer.entities.Tool;
import com.clinic.clinicapp.buisnessLayer.entities.ToolCategory;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayDataManager implements DataManager {

    private HashMap<Long,Tool> tools = new HashMap<>();

    @Override
    public boolean addTool(Tool newTool) {
        if(tools.containsKey(newTool.getLabel()))
            return false;
        tools.put(newTool.getLabel(), newTool);
        return true;
    }

    @Override
    public ArrayList<Tool> filterByCategory(ToolCategory category) {
        ArrayList<Tool> filteredTools = new ArrayList<>();
        for (Tool tool : tools.values()){
            if(tool.getCategory().equals(category)){
                filteredTools.add(tool);
            }
        }
        return filteredTools;
    }

    @Override
    public Tool searchByName(String name) {
        for (Tool tool : tools.values()){
            if (tool.getName().equals(name)){
                return tool;
            }
        }
        return null;
    }
}
