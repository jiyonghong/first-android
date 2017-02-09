package com.redice_inc.layoutexamples;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileView extends LinearLayout {

    private String name;
    private String company;
    private String job;

    public ProfileView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ProfileView);
        name = typedArray.getString(R.styleable.ProfileView_name);
        company = typedArray.getString(R.styleable.ProfileView_company);
        job = typedArray.getString(R.styleable.ProfileView_job);

        initializeView(context);
    }

    public void initializeView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.profile, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        TextView nameView = (TextView) this.findViewById(R.id.name);
        nameView.setText(name);
        TextView companyView = (TextView) this.findViewById(R.id.company);
        companyView.setText(company);
        TextView jobView = (TextView) this.findViewById(R.id.job);
        jobView.setText(job);
    }
}
