package com.raulmelo.finansysapi.enums;

import com.raulmelo.finansysapi.exceptions.ObjectNotFoundException;

public enum TypeFinansys {

    EXPENSE(1),
    REVENUE(2);

    private Integer cod;

    TypeFinansys(Integer cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public static TypeFinansys type(Integer cod){

        if(cod == null) return null;
        
        if(cod == 1) return TypeFinansys.EXPENSE;
        if(cod == 2) return TypeFinansys.REVENUE;

        throw new ObjectNotFoundException("Opção inválida ! Selecione uma opção uma das opções corretas - RECEITAS ou DESPESAS");
    }
}
