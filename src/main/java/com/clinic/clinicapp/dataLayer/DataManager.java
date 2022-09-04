package com.clinic.clinicapp.dataLayer;

import java.util.ArrayList;

import com.clinic.clinicapp.buisnessLayer.entities.Tool;
import com.clinic.clinicapp.buisnessLayer.entities.ToolCategory;

import java.util.ArrayList;

public interface DataManager {
    public boolean addTool(Tool tool);
    public ArrayList<Tool> filterByCategory(ToolCategory category);
    public Tool searchByName(String name);
    public ArrayList<Tool> filterByPrice(int start, int end);
}
