package app.room.todo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import app.room.todo.database.AppDatabase;
import app.room.todo.database.TaskEntry;

public class MainViewModel extends AndroidViewModel {

    //Constant for Logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDatabase database = AppDatabase.getsInstance(this.getApplication());
        Log.d(TAG,"Actively retrieving the task from the Database");
        tasks = database.taskDao().loadAllTasks();
    }


    public LiveData<List<TaskEntry>> getTasks(){
        return tasks;
    }
}
