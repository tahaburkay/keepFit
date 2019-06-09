package com.example.tabuto.keepfit.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tabuto.keepfit.R;
import com.example.tabuto.keepfit.Utils.KeepFitApi;
import com.example.tabuto.keepfit.activities.MainActivity;
import com.example.tabuto.keepfit.helper.HttpHandler;
import com.example.tabuto.keepfit.model.Nutrition;
import com.example.tabuto.keepfit.model.User.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentBeslenme extends android.support.v4.app.Fragment {
        ListView listView ;
        KeepFitApi keepFitApi;
        String baseUrl = "http://192.168.1.2:3000";
        private NutritonAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beslenme,container,false);
        listView =  view.findViewById(R.id.nutrionList);
        getUsers();
        return view;
    }


    private void getUsers(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build();

        keepFitApi = retrofit.create(KeepFitApi.class);
        Call<List<Nutrition>> call = keepFitApi.getNutrition();
        call.enqueue(new Callback<List<Nutrition>>() {
            @Override
            public void onResponse(Call<List<Nutrition>> call, Response<List<Nutrition>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                 List<Nutrition> nutritions = response.body();
                mAdapter = new NutritonAdapter(getContext(), (ArrayList<Nutrition>) nutritions);
                listView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<List<Nutrition>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class NutritonAdapter extends ArrayAdapter<Nutrition> {

        private Context mContext;
        private List<Nutrition> nutritionList = new ArrayList<Nutrition>();

        public NutritonAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Nutrition> list) {
            super(context, 0 , list);
            mContext = (Context) context;
            nutritionList = list;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listItem = convertView;
            if(listItem == null)
                listItem = LayoutInflater.from(mContext).inflate(R.layout.custom_nutritionlist,parent,false);

            Nutrition nutrition = nutritionList.get(position);


            TextView name = (TextView) listItem.findViewById(R.id.tvNTitle);
            name.setText(nutrition.getTitle());

            TextView calory = (TextView) listItem.findViewById(R.id.tvNCalory);
            calory.setText(nutrition.getCalori());

            TextView meal = (TextView) listItem.findViewById(R.id.tvNMeal);
            meal.setText(convertMeal(Integer.parseInt(nutrition.getType())));

            return listItem;
        }


        public String convertMeal(int meal){
            String status = "";
            if(meal == 1){
                status = "Kahvalti";
            }else if(meal == 2){
                status = "Oglen";
            }else {
                status = "Aksam";
            }
            return status;
        }
    }



}
