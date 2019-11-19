package blockchain.example.lex.ui.home;

import android.content.Context;
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


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

import blockchain.example.lex.Model.Token;
import blockchain.example.lex.Model.User;
import blockchain.example.lex.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class LexFragment extends Fragment {
    private double currentCurrency = 0;
    private Button currencyButton;
    //private Button btn1;
    private ArrayList<Button> companyButtons = new ArrayList<>();
    private LexViewModel homeViewModel;
    private Token testToken = new Token();
    private User testUser = new User();
//    private ArrayList tokenList = new ArrayList();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ArrayList<Token> tokenList = testUser.getUserTokens();
        currentCurrency = testUser.getTotalTokenVal();
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
        String btnSetText = String.format(Locale.US, "Total Currency: %.2f", currentCurrency);
        currencyButton.setText(btnSetText);
        //root.findViewById(R)

//        LayoutInflater linf;
//        LinearLayout rr;
//
//        linf = (LayoutInflater) getActivity().getApplicationContext().getSystemService(
//                Context.LAYOUT_INFLATER_SERVICE);
//        linf = LayoutInflater.from(this.getActivity());
//
//        rr = (LinearLayout) root.findViewById(R.id.tokenLayout);

//        for (int i = 1; i < 5; i++) {
//
//            View v = linf.inflate(R.layout.fragment_lex, null);
//            //v.setId(i);
//            TextView text = v.findViewById(R.id.tokenDesc);
//            text.setId(i);
//            text.setText("Company name");
//            text.setPadding(5,500,5,5);
//
//            rr.addView(v);
//
//        }

//        for (int i = 1; i <= 5; i++)
//        {
//            LinearLayout linear = root.findViewById(R.id.companyButtonLayout);
//
//        }

        for (int i = 0; i < tokenList.size(); i++) {
            final Token indToken = tokenList.get(i);
            LinearLayout linear = root.findViewById(R.id.companyButtonLayout);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            Button btn = new Button(root.getContext());
            LinearLayout layout2 = new LinearLayout(root.getContext());
//            layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            layout2.setOrientation(LinearLayout.HORIZONTAL);
            layout2.setBackgroundColor(Color.WHITE);

            int left = 10;
            int top = 15;
            int right = 10;
            int bottom = 15;

            TableRow.LayoutParams parameters = new TableRow.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            parameters.setMargins(left, top, right, bottom);

            //EditText edXY = new EditText(inventory.this);
            layout2.setLayoutParams(parameters);
            layout2.setGravity(Gravity.CENTER);

//            android:layout_width="96dp"-->
//<!--                    android:layout_height="106dp"-->

            layout2.setId(i);
//            layout2.lay
            btn.setId(i);
            CircleImageView image = new CircleImageView(root.getContext());
            image.setId(i);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150, 150);
//            image.requestLayout();
            image.setLayoutParams(layoutParams);
            image.setPadding(10,10,10,10);
//            image.getLayoutParams().width = 96;
//            image.getLayoutParams().height = 106;
            //image.setImageResource(R.drawable.alejandro);
            //Token t tokenList.get(i).getLogo();
            image.setImageResource(indToken.getLogo());
//            image.setMaxWidth(96);
//            image.setMaxHeight(106);



//            image.setImageURI("../../../../res/drawable/alejandro.png");
            layout2.addView(image);
            linear.addView(layout2);

            TextView tv1 = new TextView(root.getContext());
            TextView tv2 = new TextView(root.getContext());

            tv1.setTextSize(25);
            tv2.setTextSize(25);

//            String toName = indToken.getTokenName();
            tv1.setText(indToken.getTokenName());
            String valueText = String.format(Locale.US, "%.2f", indToken.getValue());
            tv2.setText(valueText);

            tv1.setGravity(Gravity.CENTER);
            tv2.setGravity(Gravity.END);
            tv1.setPadding(200,10,1,10);
            tv2.setPadding(100,10,1,10);
            //tv2.layout(10,10,10,10);

            layout2.addView(tv1);
            layout2.addView(tv2);

            final int lID_ = layout2.getId();

            //layoutTwo = root.findViewById(lID_);
            layout2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            indToken.getTokenName(), Toast.LENGTH_SHORT)
                            .show();
                }
            });
//            lBut.setId(i);
//            final int id_ = btn.getId();
//            final int lBId_ = lBut.getId();
//            String btnText = "button " + id_;
//            String lButText = "button " + lBId_;
//            btn.setText(btnText);

//            linear.addView(btn, params);
//            linear.addView(lBut, params);
//            btn1 = (root.findViewById(id_));
//            btn1.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View view) {
//                    Toast.makeText(view.getContext(),
//                            "Button clicked index = " + id_, Toast.LENGTH_SHORT)
//                            .show();
//                }
//            });
        }

        return root;
    }





}