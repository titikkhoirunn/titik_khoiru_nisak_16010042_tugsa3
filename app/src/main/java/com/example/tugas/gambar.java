package com.example.tugas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class gambar extends AppCompatActivity {
    private ViewPager mviewpager;
    private LinearLayout mlinear;

    private TextView[] mDots;
    private  SliderAdapter sliderAdapter;
    private Button back;
    private Button next;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);

        mviewpager = (ViewPager)findViewById(R.id.viewpager);
        mlinear = (LinearLayout)findViewById(R.id.linear);
        back = (Button)findViewById(R.id.btn_kiri);
        next = (Button)findViewById(R.id.btn_kanan);
        sliderAdapter=new SliderAdapter(this);
        mviewpager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        mviewpager.addOnPageChangeListener(viewListener);

        //onclicklisteners
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mviewpager.setCurrentItem(mCurrentPage + 1);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mviewpager.setCurrentItem(mCurrentPage - 1);
            }
        });
    }
    public void addDotsIndicator( int position){
        mDots = new  TextView[3];
        mlinear.removeAllViews();

        for (int i = 0; i < mDots.length ; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            mlinear.addView(mDots[i]);
        }
        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

            if(i == 0){
                next.setEnabled(true);
                back.setEnabled(false);
                back.setVisibility(View.INVISIBLE);

                next.setText("NEXT");
                back.setText("");
            }else if (i == mDots.length -1){
                next.setEnabled(true);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);

                next.setText("");
                back.setText("BACK");
            }else {
                next.setEnabled(true);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);

                next.setText("NEXT");
                back.setText("BACK");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
