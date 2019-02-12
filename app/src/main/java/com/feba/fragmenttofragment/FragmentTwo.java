package com.feba.fragmenttofragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentTwo extends Fragment {

    EditText editText;
    Button button;
    FragmentTwoListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        editText = view.findViewById(R.id.fragment_two_et);
        button = view.findViewById(R.id.fragment_two_OK_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = editText.getText();
                listener.applyFragmentTwoText(input);
            }
        });

        return view;
    }

    public void updateEditField(CharSequence newInput) {

        editText.setText(newInput);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentTwoListener) {
            listener = (FragmentTwoListener) context;
        } else {
            throw new ClassCastException(context.toString() + "should implement FragmentoneListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface FragmentTwoListener {
        void applyFragmentTwoText(CharSequence input);
    }
}
