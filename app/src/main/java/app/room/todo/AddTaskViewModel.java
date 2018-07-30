package app.room.todo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import app.room.todo.database.AppDatabase;
import app.room.todo.database.TaskEntry;

public class AddTaskViewModel extends ViewModel{



    private LiveData<TaskEntry> task;

    public AddTaskViewModel(AppDatabase database, int taskId) {
        task = database.taskDao().loadTaskById(taskId);
    }

    public LiveData<TaskEntry> getTask(){
        return task;
    }
}
