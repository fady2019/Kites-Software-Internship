package com.clinic.clinicapp.dataLayer;

import com.clinic.clinicapp.buisnessLayer.entities.Tool;

import java.util.ArrayList;

public interface DataManager {
    public boolean addTool(Tool tool);

    ArrayList<Tool> filterByPrice(int start, int end);
}
