
package br.com.flightmanager.config.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Configuration class responsible for converting {@link LocalDateTime} into a {@link Date} and vice versa.
 *
 * @author Rafael Ito
 * @version 1.0 05/04/2018
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(final LocalDateTime localDateTime) {
        return (localDateTime == null ? null : Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(final Date sqlDate) {
        return (sqlDate == null ? null : LocalDateTime.ofInstant(sqlDate.toInstant(), ZoneId.systemDefault()));
    }
}