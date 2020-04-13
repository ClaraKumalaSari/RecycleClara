package com.example.recycleclara;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.content.Context;
import android.support.v7.widget.RecyclerView;

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
    private GestureDetector gestureDetector;
    private ClickListener clickListener;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
                    recyclerView.getChildAdapterPosition(child);
                }
            }
        });
    }


    @Override
    public boolean onInterceptTouchEvent (RecyclerView rv, MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }


    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
    public interface ClickListener{
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}
