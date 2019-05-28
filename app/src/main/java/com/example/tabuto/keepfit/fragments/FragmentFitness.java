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
         String[] desc = {"Leg Press : Makinenin sırt kısmını kendinize uygun açıya getirin. Göğüs kafesi büyük, göbek çevresi geniş ya da kalın bacaklara sahip olanlar olanlar sonuna kadar yatırabilirler. Bunun amacı, bacakları son noktaya kadar vücuda çekebilmek içindir.",

                 "Decline Push-Up : Dizleriniz,kalçanız ve elleriniz de omuz hizasında olacak şekilde dört ayak pozisyonu alın." +
                         " Daha sonra ayaklarınızı bir sandalye veya yüksek bir şey üzerine kaldırın ve vücudunuzu kol gücünüzden destek alarak yukarı aşağı hareket ettirin." +
                         " Gövdenizin bir hizada olması gerektiğini unutmayın.",

                 "Diamond Push-Up : Ayaklarınızı birleştirerek şınav posizyonu alın.Elleriniz de omuz hizasında olacak şekilde dört ayak pozisyonu alın." +
                 " İşaret ve baş parmaklarınızı bir araya getirip göğsünüzün altında bir elmas işareti oluşturun.Daha sonra vücudunuzu yukarı aşağı hareket ettirin.",

                 /*"Bird Dog : Dizlerinizi kırarak dört ayak üstünde durun ve elleriniz omuzlarınızın altında, dizlerinizse kalçanın alt hizasında olsun." +
                 " Bu pozisyondayken sol kolu ileriye ve sağ bacağı da geriye doğru olacak şekilde aynı anda yukarı kaldırın ve uzanabildiğiniz kadar ileri uzanmaya çalışın." +*/
                 " Kol ve bacağınızı eski yerine koyduktan sonra bu sefer de sağ kolunuz ve sol bacağınızı aynı anda kaldırın.",

                 "Plank : Şınav çeker pozisyonda dümdüz durun, kollarınız omuz genişliğini geçmeyecek şekilde açık ve elleriniz de omuzlarınızın tam altında olsun."};
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
