package com.example.ch10_activity_picture_vote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("명화 선호도 투표");

        //A -> B 로 넘길껀데,
        //1.득표수, 2.명화이름

        int voteCount[] = new int[9];
        for(int i=0; i<voteCount.length; ++i)//배열 원소 초기화
            voteCount[i] = 0;

//        ImageView iv1 = findViewById(R.id.iv1);
//        ImageView iv2 = findViewById(R.id.iv2);
//        ImageView iv3 = findViewById(R.id.iv3);
//        ImageView iv4 = findViewById(R.id.iv4);

        Button btn1 = findViewById(R.id.btnResult);

        final String imgName[] = { "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                                   "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매",
                                   "피아노 레슨", "피아노 앞의 소녀들", "해변에서" };


        ImageView ivArr[] = new ImageView[9];
//        int imgID[] = new int[9];
        int imgID[] = {R.id.iv1, R.id.iv2, R.id.iv3,
                       R.id.iv4, R.id.iv5, R.id.iv6,
                       R.id.iv7, R.id.iv8, R.id.iv9};

        //바인딩 - 이벤트 처리를 하기위해서(투표 행위)
        for(int i=0; i<ivArr.length; ++i)//배열 원소 초기화
            ivArr[i] = findViewById(imgID[i]);

        for(int i=0; i<ivArr.length; ++i)//배열 원소 초기화
        {
            final int final_i = i;
            ivArr[final_i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[final_i]++;
                    Toast.makeText(getApplicationContext(),
                            voteCount[final_i]+"표!",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
//        ivArr[1].setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                voteCount[1]++;
//            }
//        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), ResultActivity.class);

                //A -> B 로 여기서 넘긴다,
                //1.득표수, 2.명화이름
                //Extras
                intent1.putExtra("VoteCount", voteCount);
                intent1.putExtra("ImageName", imgName);

                startActivity(intent1);

            }
        });


    };

}