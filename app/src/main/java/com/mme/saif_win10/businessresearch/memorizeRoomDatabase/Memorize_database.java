package com.mme.saif_win10.businessresearch.memorizeRoomDatabase;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Memorize_entity.class}, version = 1, exportSchema = false)
public abstract class Memorize_database extends RoomDatabase {
    public abstract Memorize_Dao memorize_dao();
    private static volatile Memorize_database INSTANCE;

    static Memorize_database getINSTANCE(final Context context){
        if (INSTANCE == null){
            synchronized (Memorize_database.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Memorize_database.class, "MemorizeDB")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
