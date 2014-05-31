/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.poo.io;

import java.util.Scanner;


/**
 * Manipulação da entrada de dados do console. Adicionando um identificador.
 * @author Professor - Alterado por Heverton de Lemos
 */
public class Keyboard {
    private static Scanner in = new Scanner(System.in);
    
    /**
     * Lê uma linha do console.
     * @param caption Texto que identifica o que está sendo solicitado (rótulo).
     * @return Uma string com a linha lida.
     */
    private static String readLine(String caption)
    {
        System.out.printf("%s",caption);
        return in.nextLine();
    }
    
    /**
     * Lê uma string do console.
     * @param caption Texto que identifica o que está sendo solicitado (rótulo).
     * @return Uma string com a linha lida.
     */
    public static String readlnString(String caption)
    {
        return readLine(caption);
    }
    
    /**
     * Lê um int do console.
     * @param caption Texto que identifica o que está sendo solicitado (rótulo).
     * @return Um int a partir da conversão da linha lida.
     */
    public static int readlnInt(String caption)
    {
        return Integer.parseInt(readLine(caption));
    }
    
    /**
     * Lê um float do console.
     * @param caption Texto que identifica o que está sendo solicitado (rótulo).
     * @return Um float a partir da conversão da linha lida.
     */
    public static float readlnFloat(String caption)
    {
        return Float.parseFloat(readLine(caption));
    }
    
    /**
     * Aguarda até que um ENTER seja teclado no console.
     */
    public static void waitEnter()
    {
        readLine("\n\n precione [ENTER] para continuar\n");
    }
}
