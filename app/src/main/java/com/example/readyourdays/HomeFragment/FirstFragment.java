package com.example.readyourdays.HomeFragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.readyourdays.Base.BaseFragment;
import com.example.readyourdays.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.navigation.fragment.NavHostFragment;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class FirstFragment extends BaseFragment implements
        CalendarView.OnCalendarSelectListener,
        CalendarView.OnYearChangeListener,
        View.OnClickListener{

    //specify the components we need
        private TextView displayYear;  //Year on top
        private TextView displayMonth; // Month on top
        private CalendarView calendarView; //calendar isself
        private TextView lunarTextView;
        private RelativeLayout relativeLayout;
        private Calendar calendar;
        private int year; // to shold year numner
        private Month lunaMonth;
        private Month month;
        private int day;
        private int lunaDay;
        private CalendarLayout calendarLayout; // layout for calendar
        private FloatingActionButton showBtn, today, countDown, toCome, diary;  //floating butttons
        private static final Float transition = 100f;
        private Boolean isOpenning;
        private Animation openAnimation , closeAnimation;
        private OvershootInterpolator interpolator = new OvershootInterpolator();
        private Context mcontext;




    //initialize fragment
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

    }

    //initialize components and giva them actions
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //pair all vairables with UI tools
        iniVariables(view);


        //put schedaled days in the map
        Map<String, Calendar> map = new HashMap<>();
        map.put(getSchemeCalendar(2020, 4, 28,0xFF40db25, "Birth").toString(),
                getSchemeCalendar(2020, 4, 28,0xFF40db25, "Birth")) ;
        calendarView.setSchemeDate(map);

        /*no use
        view.findViewById(R.id.next_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }


        });*/


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mcontext = context;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void iniVariables(View view){
        displayYear = view.findViewById(R.id.display_year);
        displayMonth = view.findViewById(R.id.display_month);
        calendarView = view.findViewById(R.id.gCalendar);
        calendarLayout = view.findViewById(R.id.calendarLayout);
        today = view.findViewById(R.id.today_btn);
        countDown = view.findViewById(R.id.dayBefore_btn);
        toCome = view.findViewById(R.id.dayAfter_btn);
        diary = view.findViewById(R.id.diary_btn);
        showBtn = view.findViewById(R.id.show_btn);
        lunarTextView = view.findViewById(R.id.lunar_textview);
        calendarView.setOnYearChangeListener(this);
        calendarView.setOnCalendarSelectListener(this);
        calendar = calendarView.getSelectedCalendar();

        year=calendarView.getCurYear();
        month =  Month.of(calendarView.getCurMonth());
        lunaMonth = Month.of(calendar.getLunarCalendar().getMonth());
        lunaDay = calendar.getLunarCalendar().getDay();
        String sLunaMonth = lunaMonth.toString();
        String slunaMonthDisplay = sLunaMonth.substring(0,1) + sLunaMonth.substring(1).toLowerCase();
        String lunaInfo = String.format("%s %d",  slunaMonthDisplay, lunaDay);
        lunarTextView.setText(lunaInfo);
        displayYear.setText(String.valueOf(calendarView.getCurYear()));
        String sMonth = month.toString();
        displayMonth.setText(sMonth.substring(0,1) + sMonth.substring(1).toLowerCase());
        displayYear.setOnClickListener(this);
        showBtn.setOnClickListener(this);
        today.setOnClickListener(this);
        countDown.setOnClickListener(this);
        toCome.setOnClickListener(this);
        openAnimation = AnimationUtils.loadAnimation(mcontext, R.anim.fab_open);
        closeAnimation = AnimationUtils.loadAnimation(mcontext, R.anim.fab_close);
        isOpenning = false;

    }


        private void openMenu(View v){

           showBtn.animate().setInterpolator(interpolator).rotation(-144).setDuration(300).start();
            toCome.startAnimation(openAnimation);
            today.startAnimation(openAnimation);
            diary.startAnimation(openAnimation);
            countDown.startAnimation(openAnimation);
          //  v.startAnimation(openAnimation);
            isOpenning = ! isOpenning;



        }

        private void closeMenu(View view){

            showBtn.animate().setInterpolator(interpolator).rotation(0).setDuration(300).start();
            toCome.startAnimation(closeAnimation);
            today.startAnimation(closeAnimation);
            diary.startAnimation(closeAnimation);
            countDown.startAnimation(closeAnimation);
            isOpenning = ! isOpenning;

        }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.display_year:
                if (!calendarLayout.isExpand()) {
                    calendarLayout.expand();

                    return;
                }
                calendarView.showYearSelectLayout(year);
                displayMonth.setVisibility(View.GONE);
                break;
            case R.id.show_btn:
                if (isOpenning){
                    closeMenu(v);
                }else{
                    openMenu(v);
                }
                break;
            case R.id.diary_btn:

                break;
            case R.id.today_btn:
                calendarView.scrollToCurrent();
                break;
            case R.id.dayAfter_btn:
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_navigation_home_to_createMemoryFragment);
                break;
            case R.id.dayBefore_btn:
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_navigation_home_to_createMemoryFragment);
                break;


        }


    }

    //set up the scheduled days format
    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        return calendar;
    }

    @Override
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        displayYear.setVisibility(View.VISIBLE);
        displayMonth.setVisibility(View.VISIBLE);
        lunaMonth = Month.of(calendar.getLunarCalendar().getMonth());
        lunaDay = calendar.getLunarCalendar().getDay();

        displayYear.setText(String.valueOf(calendar.getYear()));
        month = Month.of(calendar.getMonth());
        String sMonth = month.toString();
        String sLunaMonth = lunaMonth.toString();
        String slunaMonthDisplay = sLunaMonth.substring(0,1) + sLunaMonth.substring(1).toLowerCase();
        String lunaInfo = String.format("%s %d",  slunaMonthDisplay, lunaDay);
        displayMonth.setText(sMonth.substring(0,1) + sMonth.substring(1).toLowerCase());
        lunarTextView.setText(lunaInfo);
        //costumize snackbar for displaying lunar dates in English

    }


            @Override
    public void onYearChange(int year) {
        displayYear.setText(String.valueOf(year));
    }
}
