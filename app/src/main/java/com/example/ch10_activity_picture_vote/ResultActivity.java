package com.example.ch10_activity_picture_vote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

//        Intent intent1 = new Intent()//이거아님!
        Intent intent1 = getIntent();
        int voteArr[] = intent1.getIntArrayExtra("VoteCount");
        String imgNameArr[] = intent1.getStringArrayExtra("ImageName");

        TextView tvArr[] = new TextView[imgNameArr.length];
        RatingBar rbArr[] = new RatingBar[voteArr.length];

        Integer tvID[] = { R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                            R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9 };
        Integer rbarID[] = { R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                            R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9 };

        //최대 득표수에 따른 1.명화제목, 2.명화그림
        Integer imageFileId[] = { R.drawable.pic1, R.drawable.pic2,
                R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8,
                R.drawable.pic9 };

        //voteArr[] 안에서 최대 득표수 구하기
//        int max =0;
//        int max_index=0;
//        for(int i=0; i<voteArr.length; ++i)
//        {
//            if(voteArr[i]>max) {
//                max = voteArr[i];
//                max_index = i;
//            }
//        }
        //voteArr[] 안에서 최대 득표수 구하기
        int max_index=0;
        for(int i=0; i<voteArr.length; ++i)
        {
            if(voteArr[i]>voteArr[max_index]) {
                max_index = i;
            }
        }



        TextView tv1 = findViewById(R.id.tvMax);
        ImageView iv1 = findViewById(R.id.ivMax);

        tv1.setText(imgNameArr[max_index]);
        iv1.setImageResource(imageFileId[max_index]);

        for(int i=0; i<voteArr.length; ++i)//배열 원소 초기화
        {
            tvArr[i] = findViewById(tvID[i]);
            rbArr[i] = findViewById(rbarID[i]);
        }

        for(int i=0; i<voteArr.length; ++i)
        {
            tvArr[i].setText(imgNameArr[i]);
            rbArr[i].setRating((float)voteArr[i]);
        }

        Button btn1 = findViewById(R.id.btnReturn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }
}