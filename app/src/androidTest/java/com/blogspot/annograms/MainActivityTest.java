package com.blogspot.annograms;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

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
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import com.jraska.falcon.FalconSpoonRule;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Rule
    public final FalconSpoonRule falconSpoonRule = new FalconSpoonRule();

    @Test
    public void mainActivityTest() {
        MainActivity mainActivity = new MainActivity();
        falconSpoonRule.screenshot(mainActivity, "Before_result");
        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.editTextInput),
                childAtPosition(childAtPosition(withId(android.R.id.content),
                        0), 0), isDisplayed()));
        appCompatEditText.perform(replaceText("this i$ an e$press7o t38e-s8t"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(allOf(withId(R.id.buttonShowResult),
                withText("Show Result"),
                childAtPosition(childAtPosition(withId(android.R.id.content),
                        0), 1), isDisplayed()));
        appCompatButton.perform(click());
        falconSpoonRule.screenshot(mainActivity, "After_result");    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
