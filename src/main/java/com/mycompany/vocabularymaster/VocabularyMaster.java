/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vocabularymaster;

import Utils.ResultEnum;
import com.mycompany.vocabularymaster.Entities.SeenWord;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author papar
 */
public class VocabularyMaster {

    public static void main(String[] args) {
        var prueba = new SeenWord("Pepe", ResultEnum.GUESSED);
        
    }
}
