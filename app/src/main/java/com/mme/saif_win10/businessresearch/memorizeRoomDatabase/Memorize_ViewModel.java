package com.mme.saif_win10.businessresearch.memorizeRoomDatabase;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.annotation.NonNull;


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