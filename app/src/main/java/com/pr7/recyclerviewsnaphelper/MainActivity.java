package com.pr7.recyclerviewsnaphelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Integer> imagearraylist;
    MyAdapter myAdapter;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview1);
        imagearraylist=new ArrayList<>();
        //imageView=findViewById(R.id.imageview2);



        imagearraylist.add(R.drawable.khamr);
        imagearraylist.add(R.drawable.mayser);
        imagearraylist.add(R.drawable.ansab);
        imagearraylist.add(R.drawable.azlam);

        myAdapter=new MyAdapter(MainActivity.this,imagearraylist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(myAdapter);


        SnapHelper snapHelper=new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setPadding(100,0,100,0);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                RecyclerView.ViewHolder viewHolder=recyclerView.findViewHolderForAdapterPosition(0);
                RelativeLayout relativeLayout=viewHolder.itemView.findViewById(R.id.relativlay);
                relativeLayout.animate().setDuration(350).scaleX(1).scaleY(1).setInterpolator(new AccelerateInterpolator()).start();
            }
        },100);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                View view=snapHelper.findSnapView(recyclerView.getLayoutManager());
                int position=recyclerView.getLayoutManager().getPosition(view);


                RecyclerView.ViewHolder viewHolder=recyclerView.findViewHolderForAdapterPosition(position);
                RelativeLayout relativeLayout=viewHolder.itemView.findViewById(R.id.relativlay);

                if (newState ==RecyclerView.SCROLL_STATE_IDLE){
                    relativeLayout.animate().setDuration(350).scaleX(1).scaleY(1).setInterpolator(new AccelerateInterpolator()).start();
                }else {
                    relativeLayout.animate().setDuration(350).scaleX(0.8f).scaleY(0.8f).setInterpolator(new AccelerateInterpolator()).start();
                }

                if (newState ==RecyclerView.SCROLL_STATE_IDLE){
                    Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
//                    if (position==0){
//                        imageView.setImageResource(R.drawable.khamr);
//                    }
//                    if (position==1){
//                        imageView.setImageResource(R.drawable.mayser);
//                    }
//                    if (position==2){
//                        imageView.setImageResource(R.drawable.ansab);
//                    }
//                    if (position==3){
//                        imageView.setImageResource(R.drawable.azlam);
//                    }
                }else {

                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });


    }
}