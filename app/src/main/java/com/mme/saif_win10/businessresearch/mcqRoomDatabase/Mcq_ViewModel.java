package com.mme.saif_win10.businessresearch.mcqRoomDatabase;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import java.util.List;

public class Mcq_ViewModel extends AndroidViewModel {
    private Mcq_Repository mcq_repository;

    public Mcq_ViewModel(Application application) {
        super(application);
        mcq_repository = new Mcq_Repository(application);
    }


    void addMcq_q(Mcq_Q_entity entity)
    {
        mcq_repository.addMcq_q(entity);
    }
}
