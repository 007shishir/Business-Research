package com.mme.saif_win10.businessresearch.mcqRoomDatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class Mcq_ViewModel extends AndroidViewModel {
    Mcq_Repository mcq_repository;
    private LiveData<List<Mcq_Q_entity>> select_row;
    //private List<Mcq_Q_entity> find_quest_option;

    //Not sure if this works
//    String get_id;

    public Mcq_ViewModel(Application application) {
        super(application);
        mcq_repository = new Mcq_Repository(application);
//        select_row = mcq_repository.select_row(get_id);
    }
//
//    LiveData<List<Mcq_Q_entity>> select_row(String id)
//    {
//        get_id = id;
//        return select_row;
//    }

    public LiveData<List<Mcq_Q_entity>> getSelect_row(String id) {
//        get_id = id;
        select_row = mcq_repository.getSelect_row(id);
        return select_row;
    }


    public void addMcq_q (Mcq_Q_entity entity)
    {
        mcq_repository.addMcq_q(entity);
    }
}
