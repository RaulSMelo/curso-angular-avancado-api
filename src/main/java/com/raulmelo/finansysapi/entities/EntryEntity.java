package com.raulmelo.finansysapi.entities;

import com.raulmelo.finansysapi.dtos.EntryDto;
import com.raulmelo.finansysapi.util.Convertible;
import com.raulmelo.finansysapi.util.Util;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "tb_entries")
public class EntryEntity implements Serializable, Convertible<EntryDto>{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "Nome não pode ser vazio")
    private String name;

    private String description;
    
    @NotNull
    private Integer type;
    
    @NotNull(message = "Valor informado é inválido")
    @Column(precision = 9, scale = 2)
    private BigDecimal amount;

    @NotNull(message = "Data informada é inválida")
    private LocalDate date;
    
    @NotNull
    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public EntryEntity() {}

    public EntryEntity(Long id, String name, String description, Integer type, String amount, String date, boolean paid, CategoryEntity category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = Util.convertStringToBigDecimal(amount);
        this.date = Util.isDateValid(date);
        this.paid = paid;
        this.category = category;
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
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.trim();
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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Override
    public EntryDto convertToDTO() {
        
        return new EntryDto(this);
    }   
}


