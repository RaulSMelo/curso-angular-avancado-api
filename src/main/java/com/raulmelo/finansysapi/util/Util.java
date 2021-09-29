
package com.raulmelo.finansysapi.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    
    /**
     * Função que recebe uma data no formato string (dd/MM/uuuu) e verifica se é uma data válida.
     * Caso seja uma data válida retorna um LocalDate no formato (uuuu-MM-dd).
     * Caso seja uma data inválida retorna null.  
     * 
     * @param strDate
     * @return LocalDate date
     */
    public static LocalDate isDateValid(String strDate){
        
        String format = "dd/MM/uuuu";
        
        DateTimeFormatter dateTimeFormater = DateTimeFormatter.ofPattern(format).withResolverStyle(ResolverStyle.STRICT);
        
        try {
            
            LocalDate date = LocalDate.parse(strDate.trim(), dateTimeFormater);
            
            return date;
            
        } catch (DateTimeParseException e) {
            
            return null;
        }
    }
    
    /**
     * Função que recebe uma valor monetário como String, 
     * verifica se é uma String correspondente a regex de valores monetários para depois
     * converter em BigDecimal.
     * 
     * @param strAmount
     * @return BigDecimal
     */
    public static BigDecimal convertStringToBigDecimal(String strAmount){
        
        if(strAmount.trim() == "") return null;
        
        String regex = "(\\d{1,9}(,\\d{2})?)|(\\d{1,3}(,\\d{2})?)|(\\d{1,3}\\.\\d{1,3}(,\\d{2})?)|(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}(,\\d{2})?)";
        
        Matcher regexPatternIsValid = (Pattern.compile(regex)).matcher(strAmount);
        
        if(!regexPatternIsValid.matches()) return null;
        
        strAmount = strAmount.replace(".", "").replace(",", ".").trim();
        
        return new BigDecimal(strAmount);
    }
    
}
