/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vocabularymaster.Entities;

import com.mycompany.vocabularymaster.utils.ResultEnum;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

/**
 *
 * @author papar
 */
@Entity
public final class SeenWord {
    
    @Id
    private String word;
    @Basic
    private LocalDate lastTimeSeen;
    @Basic
    private LocalDate revisionDay;
    private int daySpan;
    
    public SeenWord() {}

    public SeenWord(String word, ResultEnum result) {
        this.word = word;
        this.updateWordData(result);
    }
    
    public void updateWordData(ResultEnum result) {
        this.lastTimeSeen = LocalDate.now();
        if(result == ResultEnum.SURRENDERED) this.daySpan = 0;
        else{
            if(this.daySpan == 0) this.daySpan = 1;
            else this.daySpan = (int) Math.ceil(this.daySpan * 1.5);
        }
        this.revisionDay = LocalDate.now().plusDays(daySpan);
    }

    public String getWord() {
        return word;
    }

    public LocalDate getLastTimeSeen() {
        return lastTimeSeen;
    }

    public LocalDate getRevisionDay() {
        return revisionDay;
    }

    public int getDaySpan() {
        return daySpan;
    }

    @Override
    public String toString() {
        return "SeenWord{" + "word=" + word + ", lastTimeSeen=" + lastTimeSeen + ", revisionDay=" + revisionDay + ", daySpan=" + daySpan + '}';
    }
    
}
