package com.mme.saif_win10.businessresearch.memorizeRoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "Memorize")
public class Memorize_entity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID")
    private String id;

    @ColumnInfo(name = "Question")
    private String q;

    @ColumnInfo(name = "e1")
    private String e;

    @ColumnInfo(name = "e2")
    private String ee;

    @ColumnInfo(name = "Total_No_Question")
    private int total_N_Q;

    @ColumnInfo(name = "Total_No_Explanation")
    private int total_E;

    @ColumnInfo(name = "Level_of_Cards")
    private int level_cards;

    @ColumnInfo(name = "Level_of_question")
    private int level_question;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    String getQ() {
        return q;
    }

    void setQ(String q) {
        this.q = q;
    }

    String getE() {
        return e;
    }

    void setE(String e) {
        this.e = e;
    }

    String getEe() {
        return ee;
    }

    void setEe(String ee) {
        this.ee = ee;
    }

    int getTotal_N_Q() {
        return total_N_Q;
    }

    void setTotal_N_Q(int total_N_Q) {
        this.total_N_Q = total_N_Q;
    }

    int getTotal_E() {
        return total_E;
    }

    void setTotal_E(int total_E) {
        this.total_E = total_E;
    }

    int getLevel_cards() {
        return level_cards;
    }

    void setLevel_cards(int level_cards) {
        this.level_cards = level_cards;
    }

    int getLevel_question() {
        return level_question;
    }

    void setLevel_question(int level_question) {
        this.level_question = level_question;
    }
}
