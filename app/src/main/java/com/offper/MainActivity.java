package com.offper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.slide_image_1, R.drawable.slide_image_2, R.drawable.slide_image_3};
    int[] slides = {
            R.layout.login_carousel_slide1,
            R.layout.login_carousel_slide2,
            R.layout.login_carousel_slide3,
            R.layout.login_carousel_slide4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarouselView carouselView = (CarouselView) findViewById(R.id.carousel);
        carouselView.setPageCount(slides.length);
        //carouselView.setImageListener(imageListener);
        carouselView.setViewListener(viewListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(images[position]);
        }
    };

    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {
            return getLayoutInflater().inflate(slides[position], null);
        }
    };
}
