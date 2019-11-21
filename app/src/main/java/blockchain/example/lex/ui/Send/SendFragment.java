package blockchain.example.lex.ui.Send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import blockchain.example.lex.Model.Token;
import blockchain.example.lex.Model.User;
import blockchain.example.lex.R;
import blockchain.example.lex.ui.home.LexFragment;

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

    public SendFragment(User indUser, int i)
    {
        this.indUser = indUser;
        this.indToken = indUser.getUserTokens().get(i);
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
        sendingFrom.setText(indUser.getPhone());

        TextView sendAmount = root.findViewById(R.id.amount_transfer);
        TextView confirmAmount = root.findViewById(R.id.amount_confirm);


        Button sendBtn = root.findViewById(R.id.send_btn);

        sendBtn.setOnClickListener(v -> {
            if(Double.parseDouble(sendAmount.getText().toString()) != Double.parseDouble(confirmAmount.getText().toString()))
            {
                Toast t = Toast.makeText(root.getContext(),"Please ensure that both fields are equal.",Toast.LENGTH_SHORT);
                t.show();
            }
            else
            {
                if(indToken.reduceValue(Double.parseDouble(sendAmount.getText().toString())))
                {
                    Toast t = Toast.makeText(root.getContext(), "Success! New amount = " + indToken.getValue(), Toast.LENGTH_SHORT);
                    t.show();
                    LexFragment nextFrag= new LexFragment(indUser);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.send_fragment, nextFrag, "findSendFragment")
                            .addToBackStack(null)
                            .commit();
                }
                else
                {
                    Toast t = Toast.makeText(root.getContext(), "Unable to process transaction, please ensure you have enough funds to transfer.", Toast.LENGTH_SHORT);
                    t.show();
                }


            }
        });

        return root;
    }
}