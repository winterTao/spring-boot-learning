package com.tao.spring.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Test;
import org.quartz.CronExpression;

/**
 * @author DongTao
 * @since 2019-03-25
 */
public class WebControllerTest {

    @Test
    public void test() throws ParseException {

        final boolean validExpression = CronExpression.isValidExpression("*/10 * * * * ?");

        Assert.assertTrue(validExpression);

        CronExpression cron = new CronExpression("* * * * * ?");

        System.out.println(cron.getTimeAfter(new Date()));

    }
}