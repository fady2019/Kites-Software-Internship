package com.clinic.clinicapp.dataLayer;

import com.clinic.clinicapp.buisnessLayer.entities.Tool;

import java.util.ArrayList;

public class ArrayDataManager implements DataManager {

    private static final ArrayList<Tool> tools = new ArrayList<>();

    public boolean addTool(Tool newTool) {

        if(tools.contains(newTool)) return false;
        tools.add(newTool);
        return true;
    }
}
