package com.redice_inc.layoutexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public static String url = "http://192.168.0.11:4756/profiles";

    private static MainActivity instance;
    public static MainActivity getContext() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);

        JsonArrayRequest jsonRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            List<Profile> profiles = new ArrayList<Profile>();
                            for (int i = 0; i < response.length(); ++i) {
                                JSONObject object = response.getJSONObject(i);
                                String name = object.getString("name");
                                String company = object.getString("company");
                                String job = object.getString("job");
                                String profile_image = object.getString("profile_image");
                                Profile profile = new Profile(name, company, job, profile_image);
                                profiles.add(profile);
                            }
                            inflateProfiles(profiles);
                        } catch(JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        VolleySingleton.getInstance(getContext()).addToRequestQueue(jsonRequest);
    }

    public void inflateProfiles(List<Profile> profiles) {
        ProfileAdapter profileAdapter = new ProfileAdapter(this, R.layout.profile, 0, profiles);
        ListView profilesView = (ListView) findViewById(R.id.profiles);
        profilesView.setAdapter(profileAdapter);
    }
}
