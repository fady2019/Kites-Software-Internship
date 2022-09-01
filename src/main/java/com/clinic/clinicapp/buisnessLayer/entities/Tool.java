package com.clinic.clinicapp.buisnessLayer.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Tool {
    private String name;
    private String label;
    private LocalDate expDate;
    private int price;
    private ToolCategory category;
    private int quantity;
    private String supplier;
    private boolean reusable;
    private int minQuantity;

    public Tool(String name, String label,LocalDate expDate, int price, ToolCategory category,
                int quantity, String supplier, boolean reusable, int minQuantity) {
        this.name = name;
        this.label = label;
        this.expDate = expDate;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.supplier = supplier;
        this.reusable = reusable;
        this.minQuantity = minQuantity;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public int getPrice() {
        return price;
    }

    public ToolCategory getCategory() {
        return category;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public boolean isReusable() {
        return reusable;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    @Override
    public boolean equals(Object o) {
        return this.label.equals(((Tool) o).getLabel());
    }

}
