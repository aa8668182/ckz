package com.ckz.core.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author zhurenjie
 * @version V1.0
 * @Title:
 * @Package com.live.channel.manager.utils
 * @Description: 使用ThreadLocal来避免线程安全问题
 * @date 2019/2/25 10:09
 */
public class DateUtils {
    private DateUtils(){

    }

    private static final ZoneId ZONE_ID = ZoneId.systemDefault();

    /**
     * LocalDateTime转化为Date
     *
     * @param localDateTime
     * @return
     */
    public static Date toDate(LocalDateTime localDateTime){
        return Date.from(localDateTime.atZone(ZONE_ID).toInstant());

    }

    /**
     * localDate转化为Date
     *
     * @param localDate
     * @return
     */
    public static Date toDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZONE_ID).toInstant());
    }

    /**
     * Date转化为LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZONE_ID);
    }

    /**
     * LocalDate转化为LocalDateTime
     *
     * @param localDate
     * @return
     */
    public static LocalDateTime toLocalDateTime(LocalDate localDate) {
        return LocalDateTime.of(localDate, LocalTime.MIN);
    }

    /**
     * Date转化为LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZONE_ID).toLocalDate();
    }

    /**
     * Date转化为字符串
     *
     * @param date
     * @param formatter
     * @return
     */
    public static String format(Date date, DateFormatter formatter) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZONE_ID);
        return formatter.getDateTimeFormatter().format(localDateTime);
    }

    /**
     * 字符串转化为Date
     *
     * @param text
     * @param formatter
     * @return
     */
    public static Date parse(String text, DateFormatter formatter) {
        return formatter.parse(text);
    }

    public static enum DateFormatter {

        /**
         * 格式yyyy
         *
         * @author Val Song Dec 17, 2017 7:21:12 PM
         *
         */
        YEAR_FORMATTER(DateTimeFormatter.ofPattern("yyyy", Locale.CHINA)) {
            @Override
            public Date parse(String text) {
                Year year = Year.parse(text, dateTimeFormatter);
                return Date.from(year.atDay(1).atStartOfDay(ZONE_ID).toInstant());
            }
        },

        /**
         *
         * 格式yyyy-MM
         *
         * @author Val Song Dec 17, 2017 7:21:30 PM
         *
         */
        YEAR_MONTH_FORMATTER(DateTimeFormatter.ofPattern("yyyy-MM", Locale.CHINA)) {
            @Override
            public Date parse(String text) {
                YearMonth yearMonth = YearMonth.parse(text, dateTimeFormatter);
                return Date.from(yearMonth.atDay(1).atStartOfDay(ZONE_ID).toInstant());
            }
        },

        /**
         *
         * 格式yyyy-MM-dd
         *
         * @author Val Song Dec 17, 2017 7:26:25 PM
         *
         */
        DATE_FORMATTER(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA)) {
            @Override
            public Date parse(String text) {
                LocalDate localDate = LocalDate.parse(text, dateTimeFormatter);
                return Date.from(localDate.atStartOfDay(ZONE_ID).toInstant());
            }
        },

        /**
         * 格式yyyy-MM-dd HH:mm:ss
         *
         * @author Val Song Dec 17, 2017 7:26:39 PM
         *
         */
        DATE_TIME_FORMATTER(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA)) {
            @Override
            public Date parse(String text) {
                LocalDateTime localDateTime = LocalDateTime.parse(text, dateTimeFormatter);
                return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
            }
        },

        /**
         * 格式yyyyMMdd_HHmmss
         *
         * @author Val Song Dec 17, 2017 7:26:59 PM
         *
         */
        YYYYMMDD_HHMMSS_FORMATTER(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss", Locale.CHINA)) {
            @Override
            public Date parse(String text) {
                LocalDateTime localDateTime = LocalDateTime.parse(text, dateTimeFormatter);
                return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
            }
        };

        protected DateTimeFormatter dateTimeFormatter;

        private DateFormatter(DateTimeFormatter dateTimeFormatter) {
            this.dateTimeFormatter = dateTimeFormatter;
        }

        public DateTimeFormatter getDateTimeFormatter() {
            return dateTimeFormatter;
        }

        public abstract Date parse(String text);
    }

    public static Integer getAgeByBirth(String birthDay){
        int age = 0;
        try {
            Date birthDate = parse(birthDay, DateFormatter.DATE_FORMATTER);
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthDate);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }

}
