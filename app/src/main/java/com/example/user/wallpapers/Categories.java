package com.example.user.wallpapers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Categories extends AppCompatActivity {
    GridView grid ;
    int[] categories = {R.drawable.c1,R.drawable.c2,R.drawable.c3,
                        R.drawable.c4,R.drawable.c5,R.drawable.c6,
                        R.drawable.c7,R.drawable.c8};
String names[]={"Audi","Call of Duty","Counter Strike", "Abstract","Dota2", "Nature","PUBG","Vector"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        grid=(GridView)findViewById(R.id.gridView);
//-----------------------------------Activity switching--------------------------//
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                       Intent intent = new Intent(Categories.this, C1.class);
                       intent.putExtra("array",i);
                       startActivity(intent);


            }
        });

//------------------------------------ArrayListAndHashMap-------------------------------------------//

        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for(int i=0;i<categories.length;i++)
        {
            HashMap<String,String> join= new HashMap<>();
            join.put("IMAGE",categories[i]+"");
            join.put("NAMES",names[i]);
            arrayList.add(join);
        }
        String[] from ={"NAMES","IMAGE"};
        int[] to ={R.id.textView,R.id.imageView};
        final SimpleAdapter sa = new SimpleAdapter(this,arrayList,R.layout.dummyxml,from,to);
        grid.setAdapter(sa);
    }
}
