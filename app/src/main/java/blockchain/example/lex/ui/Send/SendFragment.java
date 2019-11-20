package blockchain.example.lex.ui.Send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import blockchain.example.lex.Model.Token;
import blockchain.example.lex.Model.User;
import blockchain.example.lex.R;

public class SendFragment extends Fragment {

    private SendViewModel sendViewModel;
    private User indUser;
    private Token indToken;
    private boolean fromLex;

    public SendFragment()
    {
        indUser = new User();
        fromLex = false;
    }

    public SendFragment(User indUser)
    {
        this.indUser = indUser;
        fromLex = true;
    }

    public SendFragment(User indUser, Token indToken)
    {
        this.indUser = indUser;
        this.indToken = indToken;
        fromLex = true;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        final TextView textView = root.findViewById(R.id.text_transactions);
        sendViewModel.getText().observe(this, s -> textView.setText(s));


        TextView sendingFrom = root.findViewById(R.id.sending_account);
        sendingFrom.setText(indUser.getName());

        return root;
    }
}