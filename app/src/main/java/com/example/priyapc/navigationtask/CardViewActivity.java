package com.example.priyapc.navigationtask;

/**
 * Created by PriyaPC on 03-04-2017.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CardViewActivity extends Activity {

    TextView schoolName;
    TextView noticeSubject;
    ImageView schoolLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_notice);
        schoolName = (TextView)findViewById(R.id.addedAtTV);
        noticeSubject = (TextView)findViewById(R.id.titleTV);
        schoolLogo = (ImageView)findViewById(R.id.descriptionTV);
    }
}
