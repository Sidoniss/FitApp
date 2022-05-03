package pl.example.fitapp.ui.training;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TrainingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TrainingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Choose what you want to train today");
    }

    public LiveData<String> getText() {
        return mText;
    }
}