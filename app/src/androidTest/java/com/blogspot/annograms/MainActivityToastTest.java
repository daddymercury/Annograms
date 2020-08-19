package com.blogspot.annograms;


import android.app.Activity;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.squareup.spoon.Spoon;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityToastTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void shouldShowToast() {
        Activity activity = mActivityRule.getActivity();
        Spoon.screenshot(activity, "clear_screen");
        onView(withText(R.string.show_result)).perform(click());
        onView(withText("Input shouldn't be empty")).inRoot(withDecorView(not(is(mActivityRule.
                getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

        Spoon.screenshot(activity, "screen_with_toast");

    }


}