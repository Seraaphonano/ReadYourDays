package com.example.readyourdays;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;

import java.time.Month;

public class PopUpCalendar extends DialogFragment implements CalendarView.OnCalendarSelectListener,
        CalendarView.OnYearChangeListener,View.OnClickListener {

    private TextView displayDate;  //Year on top
    private TextView displayLunarDate; // Month on top
    private CalendarView calendarView; //calendar itself
    private Calendar calendar;
    private int year; // to shold year numner
    private Month month;
    private Month lunaMonth;
    private int day;
    private int lunaDay;
    private CalendarLayout calendarLayout; // layout for calendar
    private Context mcontext;
    private Button popSelectDate;
    private RelativeLayout display_year_option;
    private ImageView moonToday;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pop_up_calendarview, container, false);

        popSelectDate = view.findViewById(R.id.pop_select_date);
        popSelectDate.setOnClickListener(this);

        iniView(view);
        return view;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void iniView(View view) {
      displayDate = view.findViewById(R.id.display_date);
      displayLunarDate = view.findViewById(R.id.display_lunar_date);
        calendarView = view.findViewById(R.id.gCalendar);
        calendarLayout = view.findViewById(R.id.calendarLayout);
        calendarView.setOnYearChangeListener(this);
        calendarView.setOnCalendarSelectListener(this);
        calendar = calendarView.getSelectedCalendar();
        display_year_option = view.findViewById(R.id.display_year_layout);
        moonToday = view.findViewById(R.id.moon_icon);

        year=calendarView.getCurYear();
        month =  Month.of(calendarView.getCurMonth());
        day = calendarView.getCurDay();
        String sMonth = month.toString();
        String sMonthDisplay = sMonth.substring(0,1) + sMonth.substring(1).toLowerCase();
        String dateInfo = String.format("%d %s",  year, sMonthDisplay);
        displayDate.setText(dateInfo);
        lunaMonth = Month.of(calendar.getLunarCalendar().getMonth());
        lunaDay = calendar.getLunarCalendar().getDay();
        String sLunaMonth = lunaMonth.toString();
        String slunaMonthDisplay = sLunaMonth.substring(0,1) + sLunaMonth.substring(1).toLowerCase();
        String lunaInfo = String.format("%s %d",  slunaMonthDisplay, lunaDay);
        displayLunarDate.setText(lunaInfo);

        moonToday.setOnClickListener(this);
        displayDate.setOnClickListener(this);



    }


    @Override
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        displayDate.setVisibility(View.VISIBLE);
        displayLunarDate.setVisibility(View.VISIBLE);
        year = calendar.getYear();
        day = calendar.getDay();
        month = Month.of(calendar.getMonth());
        String sMonth = month.toString();
        String sMonthDisplay = sMonth.substring(0,1) + sMonth.substring(1).toLowerCase();
        String dateInfo = String.format("%d %s",  year, sMonthDisplay);
        displayDate.setText(dateInfo);

        lunaMonth = Month.of(calendar.getLunarCalendar().getMonth());
        lunaDay = calendar.getLunarCalendar().getDay();
        String sLunaMonth = lunaMonth.toString();
        String slunaMonthDisplay = sLunaMonth.substring(0,1) + sLunaMonth.substring(1).toLowerCase();
        String lunaInfo = String.format("%s %d",  slunaMonthDisplay, lunaDay);
        displayLunarDate.setText(lunaInfo);

        //costumize snackbar for displaying lunar dates in English

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pop_select_date:
                getDialog().dismiss();
                break;
            case R.id.display_date:
                if (!calendarLayout.isExpand()) {
                    calendarLayout.expand();

                    return;
                }
                calendarView.showYearSelectLayout(year);
                displayLunarDate.setVisibility(View.GONE);
                break;
            case R.id.moon_icon:
                calendarView.scrollToCurrent();
                break;
        }

    }

    @Override
    public void onYearChange(int year) {
        displayDate.setText(String.valueOf(year));
    }
}
