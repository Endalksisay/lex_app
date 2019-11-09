package blockchain.example.lex.ui.ui.aboutus;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import blockchain.example.lex.R;

public class AboutusFragment extends Fragment {

    private AboutusViewModel mViewModel;

    public static AboutusFragment newInstance() {
        return new AboutusFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(this).get(AboutusViewModel.class);

        View root = inflater.inflate(R.layout.aboutus_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_aboutus);
        mViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}