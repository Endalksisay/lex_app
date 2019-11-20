package blockchain.example.lex.ui.Merchants;

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

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.Locale;

import blockchain.example.lex.Model.Company;
import blockchain.example.lex.Model.Token;
import blockchain.example.lex.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class MerchantsFragment extends Fragment {

    private MerchantsViewModel merchantsViewModel;
    private ArrayList<Company> companyList = new ArrayList<>();

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

        companyList = merchantsViewModel.getCompanylist();

        for (int i = 0; i < companyList.size(); i++) {
            final Company indCompany = companyList.get(i);
            LinearLayout linear = root.findViewById(R.id.merchantLayout);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            Button btn = new Button(root.getContext());
            LinearLayout layout2 = new LinearLayout(root.getContext());

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

            image.setImageResource(indCompany.getLogo());

            layout2.addView(image);
            linear.addView(layout2);

            TextView tv1 = new TextView(root.getContext());
            TextView tv2 = new TextView(root.getContext());

            tv1.setTextSize(25);
            tv2.setTextSize(25);

            tv1.setText(indCompany.getCompanyName());
            tv2.setText(indCompany.getPublicKey());

            tv1.setGravity(Gravity.CENTER);
            tv1.setPadding(200,10,1,10);
            tv2.setPadding(100,10,1,10);

            layout2.addView(tv1);
            layout2.addView(tv2);

            layout2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            indCompany.getCompanyName(), Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }
        return root;
    }
}