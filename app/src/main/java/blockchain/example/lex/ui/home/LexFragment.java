package blockchain.example.lex.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import java.util.ArrayList;
import java.util.Locale;

import blockchain.example.lex.Model.Token;
import blockchain.example.lex.Model.User;
import blockchain.example.lex.R;
import blockchain.example.lex.ui.Send.SendFragment;
import de.hdodenhof.circleimageview.CircleImageView;

public class LexFragment extends Fragment {
    private double currentCurrency;
    private Button currencyButton;
    private LexViewModel homeViewModel;

    private User testUser;

    public LexFragment()
    {
        currentCurrency = 0;
        testUser = new User();
    }

    public LexFragment(User u)
    {
        currentCurrency = 0;
        testUser = u;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ArrayList<Token> tokenList = testUser.getUserTokens();
        currentCurrency = testUser.getTotalTokenVal();
        homeViewModel =
                ViewModelProviders.of(this).get(LexViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lex, container, false);
        final TextView textView = root.findViewById(R.id.text_Lex);
        homeViewModel.getText().observe(this, s -> textView.setText(s));

        currencyButton = root.findViewById(R.id.currency_button);
        String btnSetText = String.format(Locale.US, "%.2f  LEX", currentCurrency);
        currencyButton.setText(btnSetText);


        for (int i = 0; i < tokenList.size(); i++) {
            Token indToken = tokenList.get(i);
            LinearLayout linear = root.findViewById(R.id.companyButtonLayout);
            Button btn = new Button(root.getContext());
            LinearLayout layout2 = new LinearLayout(root.getContext());
            ba

            layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            layout2.setOrientation(LinearLayout.HORIZONTAL);
            layout2.setBackgroundColor(Color.WHITE);



            int left = 10;
            int top = 15;
            int right = 10;
            int bottom = 15;

            TableRow.LayoutParams parameters = new TableRow.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            parameters.setMargins(left, top, right, bottom);

            layout2.setLayoutParams(parameters);
            layout2.setGravity(Gravity.CENTER);


            layout2.setId(i);
            btn.setId(i);
            CircleImageView image = new CircleImageView(root.getContext());
            image.setId(i);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150, 150);
            image.setLayoutParams(layoutParams);
            image.setPadding(10,10,10,10);

            image.setImageResource(indToken.getLogo());


            layout2.addView(image);
            linear.addView(layout2);

            TextView tv1 = new TextView(root.getContext());
            TextView tv2 = new TextView(root.getContext());

            tv1.setTextSize(25);
            tv2.setTextSize(25);

            tv1.setText(indToken.getTokenName());
            String valueText = String.format(Locale.US, "%.2f", indToken.getValue());
            tv2.setText(valueText);

            tv1.setGravity(Gravity.CENTER);
            tv2.setGravity(Gravity.END);
            tv1.setPadding(200,10,1,10);
            tv2.setPadding(100,10,1,10);

            layout2.addView(tv1);
            layout2.addView(tv2);

            final int tokLoc = i;

            layout2.setOnClickListener(view -> Toast.makeText(view.getContext(),
                    indToken.getTokenName(), Toast.LENGTH_SHORT)
                    .show());
            layout2.setOnClickListener(v -> {
                SendFragment nextFrag= new SendFragment(testUser, tokLoc);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.lex_fragment, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            });
        }


        return root;
    }





}