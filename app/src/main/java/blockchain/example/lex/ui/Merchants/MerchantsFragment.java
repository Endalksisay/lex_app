package blockchain.example.lex.ui.Merchants;

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

import blockchain.example.lex.R;

public class MerchantsFragment extends Fragment {

    private MerchantsViewModel merchantsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        merchantsViewModel =

                ViewModelProviders.of(this).get(MerchantsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_merchants, container, false);
        final TextView textView = root.findViewById(R.id.text_merchants);
        merchantsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}