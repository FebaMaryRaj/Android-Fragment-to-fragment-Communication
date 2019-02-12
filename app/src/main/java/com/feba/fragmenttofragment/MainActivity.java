package com.feba.fragmenttofragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentOne.FragmentOneListener, FragmentTwo.FragmentTwoListener {

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_fragment_one, fragmentOne)
                .replace(R.id.layout_fragment_two, fragmentTwo).commit();
    }

    @Override
    public void applyFragmentOneText(CharSequence input) {
        fragmentTwo.updateEditField(input);

    }

    @Override
    public void applyFragmentTwoText(CharSequence input) {
        fragmentOne.updateEditField(input);

    }
}
