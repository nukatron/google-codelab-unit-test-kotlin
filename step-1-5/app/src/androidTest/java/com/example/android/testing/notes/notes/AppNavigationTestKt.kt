package com.example.android.testing.notes.notes

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.DrawerActions
import android.support.test.espresso.contrib.DrawerMatchers
import android.support.test.espresso.contrib.NavigationViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import android.view.Gravity
import com.example.android.testing.notes.R
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by nutron on 10/10/17.
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class AppNavigationTestKt {

    /**
     * {@link ActivityTestRule} is a JUnit {@link Rule @Rule} to launch your activity under test.
     *
     * <p>
     * Rules are interceptors which are executed for each test method and are important building
     * blocks of Junit tests.
     */
    @Rule @JvmField
    public val activityTestRule = ActivityTestRule(NotesActivity::class.java)


    @Test
    fun clickOnStatisticsNavigationItem_ShowsStatisticsScreen() {
        // Open Drawer to click on navigation
        onView(withId(R.id.drawer_layout))
                .check(matches(DrawerMatchers.isClosed(Gravity.LEFT)))
                .perform(DrawerActions.open())

        onView(withId(R.id.nav_view)).perform(
                NavigationViewActions.navigateTo(R.id.statistics_navigation_menu_item))

        val expectedNoStatisticsText = InstrumentationRegistry
                .getTargetContext()
                .getString(R.string.no_statistics_available)
        onView(withId(R.id.no_statistics)).check(
                matches(allOf(isDisplayed(), withText(expectedNoStatisticsText))))

    }

    @Test
    fun clickOnAndroidHomeIcon_OpensNavigation() {
        // check that left drawer close at startup
        onView(withId(R.id.drawer_layout)).check(matches(DrawerMatchers.isClosed(Gravity.LEFT)))

        // Open Drawer
        val navigateUpDesc = activityTestRule.activity
                .getString(android.support.v7.appcompat.R.string.abc_action_bar_up_description)
        onView(withContentDescription(navigateUpDesc)).perform(click())

        // Check if drawer is open
        onView(withId(R.id.drawer_layout)).check(matches(DrawerMatchers.isOpen(Gravity.LEFT)))

    }
}