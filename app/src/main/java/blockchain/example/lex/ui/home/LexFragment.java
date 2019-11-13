package blockchain.example.lex.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import java.util.ArrayList;
import java.util.Locale;

import blockchain.example.lex.R;

public class LexFragment extends Fragment {
    private double currentCurrency = 0;
    private Button currencyButton;
    private Button btn1;
    private ArrayList<Button> companyButtons = new ArrayList<>();
    private LexViewModel homeViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(LexViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lex, container, false);
        final TextView textView = root.findViewById(R.id.text_Lex);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        currencyButton = root.findViewById(R.id.currency_button);
        String btnSetText = String.format(Locale.US, "$%.2f", currentCurrency);
        currencyButton.setText(btnSetText);

        for (int i = 1; i <= 20; i++) {
            LinearLayout linear = root.findViewById(R.id.companyButtonLayout);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            Button btn = new Button(root.getContext());
            btn.setId(i);
            final int id_ = btn.getId();
            String btnText = "button " + id_;
            btn.setText(btnText);
            linear.addView(btn, params);
            btn1 = (root.findViewById(id_));
            btn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            "Button clicked index = " + id_, Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }

        return root;
    }





}