package com.clinic.clinicapp.tdd;

import com.clinic.clinicapp.buisnessLayer.entities.Tool;
import com.clinic.clinicapp.buisnessLayer.entities.ToolCategory;
import com.clinic.clinicapp.buisnessLayer.logic.toolsManagement.ToolsManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;

public class ToolManagerTest {
    ToolsManager manager;
    LocalDate expDate;

    @BeforeEach
    public void arrange() {
        manager = new ToolsManager();
        expDate = LocalDate.of(2023, 1, 1);
    }

    @DisplayName("Add New Tool")
    @Test
    public void addNewTool() {
        Tool newTool = new Tool("Needle holder", "1215", expDate, 200,
                ToolCategory.SURGICAL, 20, "s1", true, 3);

        assertTrue(manager.addTool(newTool));
    }

    @DisplayName("Add existing Tool")
    @Test
    public void addExistingTool() {
        Tool tool = new Tool("Elevator", "1214", expDate, 200,
                ToolCategory.SURGICAL, 20, "s1", true, 3);
        manager.addTool(tool);
        assertFalse(manager.addTool(tool));
    }
}

