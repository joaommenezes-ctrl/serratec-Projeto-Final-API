package org.serratec.comercio.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
// Classe converter, serve para persistir o tipo YearMonth usado na 
// entidade Cartão no banco de dados como uma String
public class YearMonthConverter implements AttributeConverter<YearMonth, String> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

    @Override
    public String convertToDatabaseColumn(YearMonth attribute) {
        return attribute != null ? attribute.format(formatter) : null;
    }

    @Override
    public YearMonth convertToEntityAttribute(String dbData) {
        return dbData != null ? YearMonth.parse(dbData, formatter) : null;
    }
}
