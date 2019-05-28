package com.example.tabuto.keepfit.fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tabuto.keepfit.R;
import com.example.tabuto.keepfit.activities.MainActivity;
import com.example.tabuto.keepfit.helper.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentBeslenme extends android.support.v4.app.Fragment {
        TextView textView ;
    private String TAG = FragmentBeslenme.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;

    private static String  url = "http://192.168.1.119:3000/users";

    ArrayList<HashMap<String,String>> userList;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beslenme,container,false);
        textView = (TextView) view.findViewById(R.id.textView);
        userList = new ArrayList<>();
        lv = (ListView)view.findViewById(R.id.listBeslenme);
        return view;
    }

    private class GetBeslenme extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getContext());
            pDialog.setMessage("Çekiyok babaaa.!!");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(url);
            if(jsonStr != null) {
                try {
                    JSONObject jsonObj  = new JSONObject(jsonStr);

                    Log.e(TAG, "Response from  url : " + jsonStr);
                    JSONArray users = jsonObj.getJSONArray("");
                    Log.e("INFORMAL","HELLO GUYS");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
