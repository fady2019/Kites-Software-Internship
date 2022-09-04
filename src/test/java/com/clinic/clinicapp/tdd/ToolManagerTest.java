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

    @BeforeEach
    public void arrange() {
    }

    @DisplayName("Add New Tool")
    @Test
    public void addNewTool() {
        manager = new ToolsManager();
        LocalDate expDate = getDate(1, 1, 2023);
        Tool newTool = new Tool("Needle holder", 1215, expDate, 200,
                ToolCategory.SURGICAL, 20, "s1", true, 3);

        assertTrue(manager.addTool(newTool));
    }

    @DisplayName("Add existing Tool")
    @Test
    public void addExistingTool() {
        manager = new ToolsManager();
        LocalDate expDate = getDate(1, 1, 2023);
        Tool tool = new Tool("Elevator", 1214, expDate, 200,
                ToolCategory.SURGICAL, 20, "s1", true, 3);
        manager.addTool(tool);
        assertFalse(manager.addTool(tool));
    }

    @DisplayName("filter tools by category (there are items in this category)")
    @Test
    public void filteByCatWithExistingTools() {
        // arrange
        manager = new ToolsManager();


        Tool elevator = new Tool("Elevator", 555, getDate(1, 1, 2023), 500,
                ToolCategory.SURGICAL, 10, "supplier1", true, 3);
        Tool needleHolder = new Tool("needle holder", 1215, getDate(1, 1, 2023), 200,
                ToolCategory.SURGICAL, 10, "s1", true, 3);
        Tool bracketTweezers = new Tool("bracket tweezers", 840, getDate(1, 5, 2023), 150,
                ToolCategory.ORTHODONTIC, 10, "s2", true, 3);

        manager.addTool(elevator);
        manager.addTool(needleHolder);
        manager.addTool(bracketTweezers);

        //act
        ArrayList<Tool> surgicalTools = manager.filterByCategory(ToolCategory.SURGICAL);
        assertEquals(expectedToolsinExistingCategorySurgical(), surgicalTools);
    }

    @DisplayName("filter tools by category (there are no items in this category)")
    @Test
    public void filteByCatWithNoExistingTools() {
        // arrange
        manager = new ToolsManager();
        Tool elevator = new Tool("Elevator", 555, getDate(1, 1, 2023), 500,
                ToolCategory.SURGICAL, 10, "supplier1", true, 3);
        Tool needleHolder = new Tool("needle holder", 1215, getDate(1, 1, 2023), 200,
                ToolCategory.SURGICAL, 10, "s1", true, 3);
        Tool bracketTweezers = new Tool("bracket tweezers", 840, getDate(1, 5, 2023), 150,
                ToolCategory.ORTHODONTIC, 10, "s2", true, 3);

        manager.addTool(elevator);
        manager.addTool(needleHolder);
        manager.addTool(bracketTweezers);

        //act
        ArrayList<Tool> periodontalTools = manager.filterByCategory(ToolCategory.PERIODONTAL);
        assertEquals(expectedToolsinNoExistingCategoryPeriodontal(), periodontalTools);
    }

    @DisplayName("search for an existing item by name")
    @Test
    public void searchForExistingName() {
        // arrange
        manager = new ToolsManager();
        Tool elevator = new Tool("Elevator", 555, getDate(1, 1, 2023), 500,
                ToolCategory.SURGICAL, 10, "supplier1", true, 3);
        Tool needleHolder = new Tool("needle holder", 1215, getDate(1, 1, 2023), 200,
                ToolCategory.SURGICAL, 10, "s1", true, 3);
        Tool bracketTweezers = new Tool("bracket tweezers", 840, getDate(1, 5, 2023), 150,
                ToolCategory.ORTHODONTIC, 10, "s2", true, 3);

        manager.addTool(elevator);
        manager.addTool(needleHolder);
        manager.addTool(bracketTweezers);

        //act
        Tool searchedTool = manager.searchByName("Elevator");
        assertEquals(expectedSearchByNameElevator(), searchedTool);
    }

    @DisplayName("search for a tool by name that is not found in database")
    @Test
    public void searchForNonExistingName() {
        // arrange
        manager = new ToolsManager();
        Tool elevator = new Tool("Elevator", 555, getDate(1, 1, 2023), 500,
                ToolCategory.SURGICAL, 10, "supplier1", true, 3);
        Tool needleHolder = new Tool("needle holder", 1215, getDate(1, 1, 2023), 200,
                ToolCategory.SURGICAL, 10, "s1", true, 3);
        Tool bracketTweezers = new Tool("bracket tweezers", 840, getDate(1, 5, 2023), 150,
                ToolCategory.ORTHODONTIC, 10, "s2", true, 3);

        manager.addTool(elevator);
        manager.addTool(needleHolder);
        manager.addTool(bracketTweezers);

        //act
        Tool searchedTool = manager.searchByName("drill");
        assertEquals(expectedSearchByNameDrill(), searchedTool);
    }


    private LocalDate getDate (int day, int month, int year){
        return LocalDate.of(year, month, day);
    }

    private ArrayList<Tool> expectedToolsinExistingCategorySurgical(){
        ArrayList<Tool> expectedTools = new ArrayList<>();

        Tool elevator = new Tool("Elevator", 555, getDate(1, 1, 2023), 500,
                ToolCategory.SURGICAL, 10, "supplier1", true, 3);
        Tool needleHolder = new Tool("needle holder", 1215, getDate(1, 1, 2023), 200,
                ToolCategory.SURGICAL, 10, "s1", true, 3);
        
        expectedTools.add(elevator);
        expectedTools.add(needleHolder);

        return expectedTools;
    }

    private ArrayList<Tool> expectedToolsinNoExistingCategoryPeriodontal(){
        return new ArrayList<>();
    }

    private Tool expectedSearchByNameElevator(){
        return new Tool("Elevator", 555, getDate(1, 1, 2023), 500,
        ToolCategory.SURGICAL, 10, "supplier1", true, 3);
    }

    private Tool expectedSearchByNameDrill(){
        return null;
    }
}

