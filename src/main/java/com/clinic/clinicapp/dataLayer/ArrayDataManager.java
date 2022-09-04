package com.clinic.clinicapp.dataLayer;

import com.clinic.clinicapp.buisnessLayer.entities.Tool;

import java.util.ArrayList;

public class ArrayDataManager implements DataManager {

    private   final ArrayList<Tool> tools = new ArrayList<>();

    public boolean addTool(Tool newTool) {

        if(tools.contains(newTool)) return false;
        tools.add(newTool);
        return true;
    }
    public ArrayList<Tool> filterByPrice(int start, int end){
        ArrayList<Tool> result = new ArrayList<>();
        for(Tool tool : tools){
            if(tool.getPrice() >= start && tool.getPrice() <= end){
                result.add(tool);
            }
        }
        return result;
    }
}
