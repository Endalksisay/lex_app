package blockchain.example.lex.ui.Transactions;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import blockchain.example.lex.R;

public class TransactionsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TransactionsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is transactions fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }
}