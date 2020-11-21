package com.samuilolegovich.vedroid_handgestures_autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.widget.AutoCompleteTextView;
import android.view.GestureDetector;
import android.widget.ArrayAdapter;
import android.view.MotionEvent;
import android.widget.TextView;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private GestureDetectorCompat gestureDetectorCompat;
    // предлагает возможные варианты по введеной букве
    private AutoCompleteTextView autoCompleteTextView;
    private TextView textView;
    private String[] strings = new String[] {
            "Audi",
            "BMW",
            "Ford",
            "Infiniti",
            "Nissan",
            "Mazda",
            "Volvo",
            "Hummer",
            "Seat",
            "Lada",
            "Honda",
            "Bentley"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.field);
        // отслеживанеие всех жестов на экране
        gestureDetectorCompat = new GestureDetectorCompat(this, this);
        gestureDetectorCompat.setOnDoubleTapListener(this);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        // android.R.layout.select_dialog_item - указываем тему как выводить предложения
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, strings);
        // после скольки символов выводить подсказки
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }


    // этот метод нужен - чтобы все остальные методы работали
    // срабатывает при прикосновению к экрану и передает это в нужные методы ниже
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        gestureDetectorCompat.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }



    // срабатывает когда мы нажимаем на экран
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        textView.setText("onSingleTapConfirmed: " + e.toString());
        return false;
    }

    // если два раза нажмем
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        textView.setText("onDoubleTap: " + e.toString());
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        textView.setText("onDoubleTapEvent: " + e.toString());
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        textView.setText("onDown: " + e.toString());
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        textView.setText("onShowPress: " + e.toString());
    }

    // сработает именно тогда когда мы нажмем и отожмем палец от экрана
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        textView.setText("onSingleTapUp: " + e.toString());
        return false;
    }

    // сработает при скролинге
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        textView.setText("onScroll: " + e1.toString() + "\n" + e2.toString());
        return false;
    }

    // срабатывает при долгом нажатии на экран
    @Override
    public void onLongPress(MotionEvent e) {
        textView.setText("onLongPress: " + e.toString());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        textView.setText("onFling: " + e1.toString() + "\n"
                + e2.toString());
        return false;
    }
}