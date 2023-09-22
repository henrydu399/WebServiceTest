package gosystem.utils;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase para obtener los formatos genericos de fechas
 */
public class DateUtil
{
    
    /** The Constant DEFAULT_FORMAT. */
    public static final String DEFAULT_FORMAT = "dd/MM/yyyy";
    
    /** The Constant DEFAULT_FORMAT_ALTERNATE_SEPARATOR. */
    public static final String DEFAULT_FORMAT_ALTERNATE_SEPARATOR = "dd-MM-yyyy";
        
    /** The Constant MINUTE_FORMAT. */
    public static final String MINUTE_FORMAT = "dd/MM/yyyy HH:mm";
    
    /** The Constant SECOND_FORMAT. */
    public static final String SECOND_FORMAT = "dd/MM/yyyy HH:mm:ss";
    
    /** The Constant SECOND_FORMAT. */
    public static final String SECOND_FORMAT_SICURLOCK = "yyyy-MM-dd HH:mm:ss";
    
    /** The Constant SECOND_FORMAT_ALTERNATE_SEPARATOR. */
    public static final String SECOND_FORMAT_ALTERNATE_SEPARATOR = "dd-MM-yyyy_HH-mm-ss";
    
    /** The Constant MILLISECOND_FORMAT. */
    public static final String MILLISECOND_FORMAT = "dd/MM/yyyy HH:mm:ss:SS";
    
    /** The Constant HOURSMINUTES_FORMAT. */
    public static final String HOURSMINUTES_FORMAT = "HH:mm";
    
    // jsr (09/2016)
    // 13371-98 RI4. Locken. Accesos reales
    public static final String YEARMONTHDAY_FILE_FORMAT = "yyyyMMdd";

    // jsr (09/2016)
    // 13371-96 RI2. Locken. Envío de acceso.
    public static final String YEARMONTHDAY_WITH_HOURMINUTE_FILE_FORMAT = "yyyyMMdd HH:mm";
    
    /**
     * Instantiates a new date util.
     */
    private DateUtil()
    {

    }

    /**
     * Creates the default format - DEFAULT_FORMAT = "dd/MM/yyyy".
     * 
     * @return the simple date format
     */
    public static SimpleDateFormat createDefaultFormat()
    {
	return new SimpleDateFormat(DEFAULT_FORMAT);
    }

    /**
     * Creates the default format with an alternate separator '-' - DEFAULT_FORMAT_ALTERNATE_SEPARATOR = "dd-MM-yyyy".
     * 
     * @return the simple date format
     */
    public static SimpleDateFormat createDefaultFormatAlternateSeparator()
    {
	return new SimpleDateFormat(DEFAULT_FORMAT_ALTERNATE_SEPARATOR);
    }

    
    /**
     * Creates the minute format - MINUTE_FORMAT = "dd/MM/yyyy HH:mm".
     * 
     * @return the simple date format
     */
    public static SimpleDateFormat createMinuteFormat()
    {
	return new SimpleDateFormat(MINUTE_FORMAT);
    }

    /**
     * Creates the second format - SECOND_FORMAT = "dd/MM/yyyy HH:mm:ss".
     * 
     * @return the simple date format
     */
    public static SimpleDateFormat createSecondFormat()
    {
	return new SimpleDateFormat(SECOND_FORMAT);
    }
    
    /**
     * Creates the second format - SECOND_FORMAT_ALTERNATE_SEPARATOR = "dd-MM-yyyy_HH-mm-ss".
     * 
     * @return the simple date format
     */
    public static SimpleDateFormat createSecondFormatAlternateSeparator()
    {
	return new SimpleDateFormat(SECOND_FORMAT_ALTERNATE_SEPARATOR);
    }
    
    /**
     * Creates the millisecond format - MILLISECOND_FORMAT = "dd/MM/yyyy HH:mm:ss:SS".
     * 
     * @return the simple date format
     */
    public static SimpleDateFormat createMillisecondFormat()
    {
	return new SimpleDateFormat(MILLISECOND_FORMAT);
    }

    /**
     * Creates the only hours minutes - HOURSMINUTES_FORMAT = "HH:mm".
     * 
     * @return the simple date format
     */
    public static SimpleDateFormat createOnlyHoursMinutes()
    {
	return new SimpleDateFormat(HOURSMINUTES_FORMAT);
    }

    
    // jsr (09/2016)
    // 13371-98 RI4. Locken. Accesos reales
    public static SimpleDateFormat createYearMonthDayFileFormat() {
    	return new SimpleDateFormat(YEARMONTHDAY_FILE_FORMAT);
    }
    
    // jsr (09/2016)
    // 13371-96 RI2. Locken. Envío de acceso.
    public static SimpleDateFormat createYearMonthDayWithHourMinuteFileFormat() {
    	return new SimpleDateFormat(YEARMONTHDAY_WITH_HOURMINUTE_FILE_FORMAT);
    }
    
    public static Date incrementaDias(Date fecha, int dias) {
        GregorianCalendar fechaCalendar = obtenNormalizado();
        fechaCalendar.setTime(fecha);
        fechaCalendar.add(GregorianCalendar.DATE, dias);
        return fechaCalendar.getTime();
    }
    
    private static GregorianCalendar obtenNormalizado() {

        GregorianCalendar gc = new GregorianCalendar();
        gc.setFirstDayOfWeek(GregorianCalendar.MONDAY);
        gc.setMinimalDaysInFirstWeek(4);

        return gc;

    }  
}
