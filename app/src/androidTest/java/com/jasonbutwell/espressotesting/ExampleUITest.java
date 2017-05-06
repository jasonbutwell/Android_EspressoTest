package com.jasonbutwell.espressotesting;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void ClickButtonTest() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.jasonbutwell.espressotesting", appContext.getPackageName());

        // The text that should be in the textview after we click the button
        String buttonClickedTextString = appContext.getString(R.string.textview_clicked_text);

        // Click the button to trigger the button listener code
        onView(withId(R.id.button))
                .perform(click());

        // The text view's text should have been changed, so check it
        //onView(withId(R.id.textView)).check(matches(withText(buttonClickedTextString)));

        onView(withText(buttonClickedTextString))
                .check(matches(isDisplayed()));
    }
}
