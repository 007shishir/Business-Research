package com.mme.saif_win10.businessresearch.memorizeRoomDatabase;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import java.util.List;

public class Memorize_ViewModel extends AndroidViewModel {
    private Memorize_Repository repository;

    public Memorize_ViewModel(@NonNull Application application) {
        super(application);
        repository = new Memorize_Repository(application);
    }

    void addMemorizeQ(Memorize_entity entity){
        repository.addMemorizeQ(entity);
    }

}