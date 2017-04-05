package com.example.sofak.fastcalculator;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityEspresoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityEsspresoTest() {
        int i1;
        for(int i=1;i<=1000;i++) {
            Random r = new Random();
            i1 = r.nextInt(22) + 1;
            Log.d("Esspreso: ", Integer.toString(i1));
            switch(i1) {
                case 1:
                    ViewInteraction appCompatButton = onView(
                            allOf(withId(R.id.seven), withText("7"), isDisplayed()));
                    appCompatButton.perform(click());
                    break;
                case 2:
                    ViewInteraction appCompatButton2 = onView(
                            allOf(withId(R.id.eight), withText("8"), isDisplayed()));
                    appCompatButton2.perform(click());
                    break;
                case 3:
                    ViewInteraction appCompatButton3 = onView(
                            allOf(withId(R.id.two), withText("2"), isDisplayed()));
                    appCompatButton3.perform(click());
                    break;
                case 4:
                    ViewInteraction appCompatButton4 = onView(
                            allOf(withId(R.id.three), withText("3"), isDisplayed()));
                    appCompatButton4.perform(click());
                    break;
                case 5:
                    ViewInteraction appCompatButton5 = onView(
                            allOf(withId(R.id.eight), withText("8"), isDisplayed()));
                    appCompatButton5.perform(click());
                    break;
                case 6:
                    ViewInteraction appCompatButton6 = onView(
                            allOf(withId(R.id.backspace), isDisplayed()));
                    appCompatButton6.perform(click());
                    break;
                case 7:
                    ViewInteraction appCompatButton7 = onView(
                            allOf(withId(R.id.nine), withText("9"), isDisplayed()));
                    appCompatButton7.perform(click());
                    break;
                case 8:
                    ViewInteraction appCompatButton8 = onView(
                            allOf(withId(R.id.six), withText("6"), isDisplayed()));
                    appCompatButton8.perform(click());
                    break;
                case 9:
                    ViewInteraction appCompatButton9 = onView(
                            allOf(withId(R.id.five), withText("5"), isDisplayed()));
                    appCompatButton9.perform(click());
                    break;
                case 10:
                    ViewInteraction appCompatButton10 = onView(
                            allOf(withId(R.id.four), withText("4"), isDisplayed()));
                    appCompatButton10.perform(click());
                    break;
                case 11:
                    ViewInteraction appCompatButton11 = onView(
                            allOf(withId(R.id.one), withText("1"), isDisplayed()));
                    appCompatButton11.perform(click());
                    break;
                case 12:
                    ViewInteraction appCompatButton12 = onView(
                            allOf(withId(R.id.zero), withText("0"), isDisplayed()));
                    appCompatButton12.perform(click());
                    break;
                case 13:
                    ViewInteraction appCompatButton13 = onView(
                            allOf(withId(R.id.dot), withText("."), isDisplayed()));
                    appCompatButton13.perform(click());
                    break;
                case 14:
                    ViewInteraction appCompatButton14 = onView(
                            allOf(withId(R.id.synplun), withText("+/-"), isDisplayed()));
                    appCompatButton14.perform(click());
                    break;
                case 15:
                    ViewInteraction appCompatButton15 = onView(
                            allOf(withId(R.id.kai), withText("+"), isDisplayed()));
                    appCompatButton15.perform(click());
                    break;
                case 16:
                    ViewInteraction appCompatButton16 = onView(
                            allOf(withId(R.id.meion), withText("-"), isDisplayed()));
                    appCompatButton16.perform(click());
                    break;
                case 17:
                    ViewInteraction appCompatButton17 = onView(
                            allOf(withId(R.id.epi), withText("*"), isDisplayed()));
                    appCompatButton17.perform(click());
                    break;
                case 18:
                    ViewInteraction appCompatButton18 = onView(
                            allOf(withId(R.id.dia), withText("/"), isDisplayed()));
                    appCompatButton18.perform(click());
                    break;
                case 19:
                    ViewInteraction appCompatButton19 = onView(
                            allOf(withId(R.id.percent), withText("%"), isDisplayed()));
                    appCompatButton19.perform(click());
                    break;
                case 20:
                    ViewInteraction appCompatButton20 = onView(
                            allOf(withId(R.id.parenthesis), withText("()"), isDisplayed()));
                    appCompatButton20.perform(click());
                    break;
                case 21:
                    ViewInteraction appCompatButton21 = onView(
                            allOf(withId(R.id.clear), withText("C"), isDisplayed()));
                    appCompatButton21.perform(click());
                    break;
                default:
                    break;
            }
            if (i1==50){
                ViewInteraction appCompatButton21 = onView(
                        allOf(withId(R.id.clear), withText("C"), isDisplayed()));
                appCompatButton21.perform(click());
            }
        }

    }

}
