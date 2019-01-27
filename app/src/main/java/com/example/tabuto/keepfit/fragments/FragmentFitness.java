package com.example.tabuto.keepfit.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tabuto.keepfit.R;
import com.example.tabuto.keepfit.model.FitnessCategory;

import java.util.ArrayList;

public class FragmentFitness extends android.support.v4.app.Fragment {
        TextView textView ;
        ArrayList<FitnessCategory> arrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fitness,container,false);
        textView = (TextView) view.findViewById(R.id.textView);

         String[] titles = {"Bacak","Omuz","Göğüs","Sırt","Kol"};
         String[] desc = {"Bacak çalış","Omuz çalış","Göğüs çalış","Sırt çalış","Kol çalış"};
         int[] images = {R.drawable.leg,R.drawable.shoulder,R.drawable.chest,R.drawable.back,R.drawable.arm};
         ListView listView = view.findViewById(R.id.lvFitness);
         FitnessCategory category;
         arrayList = new ArrayList<FitnessCategory>();
        for (int i = 0; i <titles.length ; i++) {
            category = new FitnessCategory(titles[i],desc[i],images[i]);
            arrayList.add(category);
        }
        MyArrayAdapter adapter = new MyArrayAdapter(getContext());
        listView.setAdapter(adapter);
        return view;
    }

    public class MyArrayAdapter extends ArrayAdapter<FitnessCategory> {

        public MyArrayAdapter(@NonNull Context context) {
            super(context, R.layout.custom_fitness_item,arrayList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rootView = layoutInflater.inflate(R.layout.custom_fitness_item,parent,false);

            TextView tvTitle = rootView.findViewById(R.id.itemFitnessTitle);
            TextView tvDesc = rootView.findViewById(R.id.itemFitnessDescription);
            ImageView image = rootView.findViewById(R.id.itemFitnessAvatar);

            tvTitle.setText(arrayList.get(position).getTitle());
            tvDesc.setText(arrayList.get(position).getDecription());
            image.setImageDrawable(getResources().getDrawable(arrayList.get(position).getImage()));

            return rootView;
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }
    }
}
