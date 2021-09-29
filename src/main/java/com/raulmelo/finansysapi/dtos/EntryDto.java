package com.raulmelo.finansysapi.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.raulmelo.finansysapi.entities.CategoryEntity;
import com.raulmelo.finansysapi.entities.EntryEntity;
import com.raulmelo.finansysapi.util.Util;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class EntryDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;
    private String description;
    private Integer type;
    private BigDecimal amount;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    
    private boolean paid;
    private Long category;

    public EntryDto() {}

    public EntryDto(Long id, String name, String description, Integer type, String amount, String date, boolean paid, CategoryEntity category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = Util.convertStringToBigDecimal(amount);
        this.date = Util.isDateValid(date);
        this.paid = paid;
        this.category = category.getId();
    }
    
    public EntryDto(EntryEntity entry) {
        this.id = entry.getId();
        this.name = entry.getName();
        this.description = entry.getDescription();
        this.type = entry.getType();
        this.amount = entry.getAmount();
        this.date = entry.getDate();
        this.paid = entry.isPaid();
        this.category = entry.getCategory().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = Util.convertStringToBigDecimal(amount);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = Util.isDateValid(date);
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
    
}
