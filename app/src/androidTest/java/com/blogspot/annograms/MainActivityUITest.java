package com.blogspot.annograms;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import com.squareup.spoon.Spoon;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.rule.GrantPermissionRule.grant;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)


public class MainActivityUITest {

    class RotationTest {
        @Rule
        public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


        private void rotateScreen() {
            Context context = InstrumentationRegistry.getTargetContext();
            int orientation = context.getResources().getConfiguration().orientation;

            Activity activity = mActivityTestRule.getActivity();
            activity.setRequestedOrientation(
                    (orientation == Configuration.ORIENTATION_PORTRAIT) ?
                            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE :
                            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }


        @Test
        public void mainActivityTestOrientation() {
            Activity activity = mActivityTestRule.getActivity();

            Spoon.screenshot(activity, "clear_screen");
            onView(withId(R.id.editTextInput)).perform(typeText("This is a Test Me$$age"));
            Spoon.screenshot(activity, "screen_with_text_before_rotating");
            rotateScreen();
            Spoon.screenshot(activity, "screen_with_text_after_rotating");
            rotateScreen();
            Spoon.screenshot(activity, "screen_with_text_after_second_rotating");
        }
    }

    @RunWith(androidx.test.ext.junit.runners.AndroidJUnit4.class)
    @LargeTest
    class MainActivityToastTest2 {

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

    @LargeTest
    @RunWith(AndroidJUnit4.class)
    class MainActivityTestNormalWork {

        @Rule
        public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
        @Rule
        public GrantPermissionRule mRuntimePermissionRule =
                grant(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE);

        @Test
        public void mainActivityTest() {
            Activity activity = mActivityTestRule.getActivity();

            Spoon.screenshot(activity, "clear_screen");
            onView(withId(R.id.editTextInput)).perform(typeText("this i$ an e$press7o t38e-s8t"));
            Spoon.screenshot(activity, "screen_with_string");
            onView(withText(R.string.show_result)).perform(click());
            Spoon.screenshot(mActivityTestRule.getActivity(), "screen_aftter_reverse");
        }
    }
}