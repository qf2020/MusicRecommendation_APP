package cjk.design.music.activity.ui.personal_information;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class PersonalInformationViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PersonalInformationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}