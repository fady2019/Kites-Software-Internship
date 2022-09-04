package com.clinic.clinicapp.tdd;

import com.clinic.clinicapp.buisnessLayer.entities.Tool;
import com.clinic.clinicapp.buisnessLayer.entities.ToolCategory;
import com.clinic.clinicapp.buisnessLayer.logic.toolsManagement.ToolsManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
import java.util.ArrayList;

public class ToolManagerTest {
    ToolsManager manager;
    LocalDate expDate;

    @BeforeEach
    public void arrange() {
        expDate = LocalDate.of(2023, 1, 1);
    }

    @DisplayName("Add New Tool")
    @Test
    public void addNewTool() {
        manager = new ToolsManager();
        Tool newTool = new Tool("Needle holder", "1215", expDate, 200,
                ToolCategory.SURGICAL, 20, "s1", true, 3);
        assertTrue(manager.addTool(newTool));
    }

    @DisplayName("Add existing Tool")
    @Test
    public void addExistingTool() {
        manager = new ToolsManager();
        Tool tool =new Tool("Elevator", "1214", expDate, 200,
                ToolCategory.SURGICAL, 20, "s1", true, 3);
        manager.addTool(tool);
        assertFalse(manager.addTool(tool));
    }
    @DisplayName ("Filter tools by price and price found")
    @Test
    public void filterToolsByPriceAndToolsFound(){
        manager = new ToolsManager();
        Tool tool1 = new Tool("Elevator", "1214", expDate, 200,
                ToolCategory.SURGICAL, 20, "s1", true, 3);
        Tool tool2 = new Tool("Needle holder", "1215", expDate, 400,
                ToolCategory.SURGICAL, 20, "s1", true, 3);
        manager.addTool(tool1);
        manager.addTool(tool2);
        ArrayList<Tool> filterResult = manager.filterByPrice(100,300);
        assertEquals(expectedFilteredListForFilterToolsByPriceAndToolsFound(),filterResult);
    }
    Tool createTool(String name, String label, LocalDate expDate, int price, ToolCategory category, int quantity,
                    String supplier, Boolean reusable, int minQuantity){
        return new Tool (name, label, expDate, price, category, quantity, supplier, reusable, minQuantity);
    }
    ArrayList<Tool> expectedFilteredListForFilterToolsByPriceAndToolsFound(){
        ArrayList<Tool> expectedResult = new ArrayList<>();
        expectedResult.add(createTool("Elevator", "1214", expDate, 200,
                ToolCategory.SURGICAL, 20, "s1", true, 3));
        return expectedResult;
    }
    @DisplayName ("Filter tools by price and tools not found")
    @Test
    public void filterToolsByPriceAndToolsNotFound(){
        manager = new ToolsManager();
        Tool tool1 = new Tool("Elevator", "1214", expDate, 200,
                ToolCategory.SURGICAL, 20, "s1", true, 3);
        Tool tool2 = new Tool("Needle holder", "1215", expDate, 400,
                ToolCategory.SURGICAL, 20, "s1", true, 3);
        manager.addTool(tool1);
        manager.addTool(tool2);
        ArrayList<Tool> filterResult = manager.filterByPrice(500,600);
        assertEquals(expectedFilteredListForFilterToolsByPriceAndToolsNotFound(),filterResult);

    }
    ArrayList<Tool> expectedFilteredListForFilterToolsByPriceAndToolsNotFound(){
        ArrayList<Tool> expectedResult = new ArrayList<>();
        return expectedResult;
    }
}

