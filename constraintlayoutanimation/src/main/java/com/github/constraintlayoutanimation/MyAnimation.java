package com.github.constraintlayoutanimation;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Mehdi Haghgoo on 1/14/18.
 */

public class MyAnimation{
    private Context mContext;
    private ConstraintSet mConstraintSet;
    private Transition mTransition;
    private final String LOG_TAG = MyAnimation.class.getSimpleName();

    private static final MyAnimation mInstance = new MyAnimation();

    private MyAnimation() {}
    public static MyAnimation getInstance() { return mInstance;}


    /**
     * initializes context for the current instance
     * @param context context to be used for {@link ConstraintSet}
     * @return an instance of {@link MyAnimation}
     */
    public MyAnimation with(Context context) {
        mContext = context;
        mConstraintSet = new ConstraintSet();
        return this;
    }

    /**
     *
     * @param secondKeyframe This is the layout from which constraints will be picked
     * @return An instance of this class
     * @throws IllegalStateException Throws exception if context has not been initialized
     */
    public MyAnimation from(@LayoutRes int secondKeyframe) throws IllegalStateException {
        if(mContext == null) {
            throw new IllegalStateException("Context not initalized. Please call with(Context) first");
        }
        mConstraintSet.clone(mContext, secondKeyframe);
        return this;
    }
    /**
     *
     * @param secondKeyframe This is the layout from which constraints will be picked
     * @return An instance of this class
     * @throws IllegalStateException Throws exception if context has not been initialized
     */
    public MyAnimation from(@LayoutRes int secondKeyframe, Transition customTransition) throws IllegalStateException {
        if(mContext == null) {
            throw new IllegalStateException("Context not initalized. Please call with(Context) first");
        }
        mTransition = customTransition;
        mConstraintSet.clone(mContext, secondKeyframe);
        return mInstance;
    }

    /**
     * Applies animation after applying new {@link ConstraintSet}
     * @param layout The ViewGroup on which the animation will be performed
     */
    public  void animate(ConstraintLayout layout) {
        mConstraintSet.applyTo(layout);
        Log.i(LOG_TAG, "animation started");
        if(mTransition != null) {
            TransitionManager.beginDelayedTransition(layout, mTransition);
        }
        else {
            TransitionManager.beginDelayedTransition(layout);
        }

    }




}
