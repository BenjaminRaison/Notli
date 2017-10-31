package ch.notli.notli.db;


import android.arch.persistence.room.TypeConverter;

import java.math.BigDecimal;
import java.util.Date;

public class Converter {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static String bigDecimalToString(BigDecimal value) {
        return value == null ? null : value.toString();
    }

    @TypeConverter
    public static BigDecimal fromString(String value) {
        return value == null ? null : new BigDecimal(value);
    }


}
