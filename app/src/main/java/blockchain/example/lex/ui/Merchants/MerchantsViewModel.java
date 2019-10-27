package blockchain.example.lex.ui.Merchants;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MerchantsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MerchantsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}