package blockchain.example.lex.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import java.util.Locale;

import blockchain.example.lex.Model.Token;
import blockchain.example.lex.Model.User;
import blockchain.example.lex.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class TokenFragment extends Fragment {
    private double currentCurrency = 0;
    private Button currencyButton;
    private LexViewModel homeViewModel;
    private User testUser = new User();
    private Token indToken;

    public TokenFragment(Token indToken)
    {
        this.indToken = indToken;
        User testUser = new User();
        currentCurrency = 0;
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        currentCurrency = testUser.getTotalTokenVal();
        homeViewModel =
                ViewModelProviders.of(this).get(LexViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lex, container, false);
        final TextView textView = root.findViewById(R.id.text_Lex);
        homeViewModel.getText().observe(this, s -> textView.setText(s));

        currencyButton = root.findViewById(R.id.currency_button);
        String btnSetText = String.format(Locale.US, "Total Currency: %.2f", currentCurrency);
        currencyButton.setText(btnSetText);


            LinearLayout linear = root.findViewById(R.id.companyButtonLayout);
            Button btn = new Button(root.getContext());
            LinearLayout layout2 = new LinearLayout(root.getContext());
            layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            layout2.setOrientation(LinearLayout.VERTICAL);
            layout2.setBackgroundColor(Color.WHITE);

            layout2.setGravity(Gravity.CENTER);

            layout2.setId(0);

            btn.setId(0);
            CircleImageView image = new CircleImageView(root.getContext());
            image.setId(0);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150, 150);

            image.setLayoutParams(layoutParams);
            image.setPadding(10, 10, 10, 10);

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
            tv1.setPadding(200, 10, 1, 10);
            tv2.setPadding(100, 10, 1, 10);

            layout2.addView(tv1);
            layout2.addView(tv2);

            layout2.setOnClickListener(view -> Toast.makeText(view.getContext(),
                    indToken.getTokenName(), Toast.LENGTH_SHORT)
                    .show());


        return root;
    }
}
