package com.clinic.clinicapp.buisnessLayer.entities;

import java.time.LocalDate;

public class Tool {
    private String name;
    private long label;
    private LocalDate expDate;
    private int price;
    private ToolCategory category;
    private int quantity;
    private String supplier;
    private boolean reusable;
    private int minQuantity;

    public Tool(String name, long label,LocalDate expDate, int price, ToolCategory category,
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

    public long getLabel() {
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
        return  this.label == ((Tool) o).getLabel() //&&
//                this.name.equals(((Tool) o).getName()) &&
//                this.expDate.equals(((Tool) o).getExpDate()) &&
//                this.price == ((Tool) o).getPrice() &&
//                this.category.equals(((Tool) o).getCategory()) &&
//                this.quantity == ((Tool) o).getQuantity() &&
//                this.supplier.equals(((Tool) o).getSupplier()) &&
//                this.reusable == ((Tool) o).isReusable() &&
//                this.minQuantity == ((Tool) o).getMinQuantity()
        ;
    }

}
