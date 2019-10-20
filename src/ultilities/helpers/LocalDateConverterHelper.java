/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultilities.helpers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

/**
 *
 * @author Khang
 */

public class LocalDateConverterHelper{
 
  
    public static Date convertToDatabaseColumn(LocalDate localDate) {
        return Optional.ofNullable(localDate)
          .map(Date::valueOf)
          .orElse(null);
    }
 
    public static LocalDate convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date)
          .map(Date::toLocalDate)
          .orElse(null);
    }
}