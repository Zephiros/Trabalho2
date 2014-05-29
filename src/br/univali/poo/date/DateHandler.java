/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhom2.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Fornece operações para manipulação e formatação de datas.
 * @author Heverton
 */
public class DateHandler {
    
    /**
     * Recupera data de hoje conforme configuração da máquina.
     * @return data atual.
     */
    public static Calendar today()
    {
        Calendar now = new GregorianCalendar();
        now.setTime(new Date());
        return now;
    }
    
    /**
     * Formata uma data a partir de uma mácara fornecida.
     * @param date data a ser fornecida
     * @param formattingMask máscara de formatação> dd/MM/yyyy, ddMMyyyy,
     * ddMMy, etc.
     * @return string com a data foratada de acordo com a máscara fornecida.
     */
    public static String format(Calendar date, String formattingMask)
    {
        SimpleDateFormat fmt = new SimpleDateFormat(formattingMask);
        return fmt.format(date.getTime());
    }
    
    /**
     * Calcula a diferença de anos entre hoje e uma determinada data.
     * @param date data referência para calculo.
     * @return diferença de anos entre hoje e uma data determinada.
     */
    public static int yearsFromToday(Calendar date)
    {
        return (yearsBetween(today(), date));
    }
    
    /**
     * Calcula a diferença de anos entre duas datas.
     * @param startingDate data inicial.
     * @param finishingDate data final.
     * @return diferença de anos entre as duas datas fornecidas.
     */
    public static int yearsBetween(Calendar startingDate, Calendar finishingDate)
    {
        int years = startingDate.get(Calendar.YEAR) - finishingDate.get(Calendar.YEAR);
        if(startingDate.get(Calendar.DAY_OF_YEAR) < finishingDate.get(Calendar.DAY_OF_YEAR))
        {
            years--;
        }
        return (years);
    }
}
