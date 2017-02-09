package com.redice_inc.layoutexamples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.List;


public class ProfileAdapter extends ArrayAdapter<Profile> {
    private LayoutInflater inflater = null;

    public ProfileAdapter(Context context, int resource, int textViewResourceId, List<Profile> profiles) {
        super(context, resource, textViewResourceId, profiles);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Profile currentProfile = getItem(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.profile, null, false);
        }

        TextView profileName = (TextView) convertView.findViewById(R.id.name);
        TextView profileCompany = (TextView) convertView.findViewById(R.id.company);
        TextView profileJob = (TextView) convertView.findViewById(R.id.job);
        NetworkImageView profileImage = (NetworkImageView) convertView.findViewById(R.id.profile_image);

        profileName.setText(currentProfile.name);
        profileCompany.setText(currentProfile.company);
        profileJob.setText(currentProfile.job);
        profileImage.setImageUrl(currentProfile.profile_image,
                VolleySingleton.getInstance(getContext()).getImageLoader());


        return convertView;
    }

}