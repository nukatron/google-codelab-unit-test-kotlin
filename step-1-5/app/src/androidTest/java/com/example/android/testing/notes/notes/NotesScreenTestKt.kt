package com.example.android.testing.notes.notes

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import android.test.suitebuilder.annotation.LargeTest
import android.text.TextUtils
import android.view.View
import android.view.Window
import com.example.android.testing.notes.R
import com.google.common.base.Preconditions
import dalvik.annotation.TestTarget
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by nutron on 10/10/17.
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class NotesScreenTestKt {

    /**
     * A custom {@link Matcher} which matches an item in a {@link RecyclerView} by its text.
     *
     * <p>
     * View constraints:
     * <ul>
     * <li>View must be a child of a {@link RecyclerView}
     * <ul>
     *
     * @param itemText the text to match
     * @return Matcher that matches text in the given view
     */
    private fun withItemText(itemText: String): Matcher<View> {
        Preconditions.checkArgument(!TextUtils.isEmpty(itemText), "itemText cannot be null or empty")
        return object : TypeSafeMatcher<View>() {
            override fun matchesSafely(item: View?): Boolean {
                return allOf(ViewMatchers.isDescendantOfA(
                        ViewMatchers.isAssignableFrom(RecyclerView::class.java)),
                        withText(itemText)
                ).matches(item)
            }

            override fun describeTo(description: Description?) {
                description?.appendText("is isDescendantOfA RV with text " + itemText)
            }
        }
    }

    /**
     * {@link ActivityTestRule} is a JUnit {@link Rule @Rule} to launch your activity under test.
     *
     * <p>
     * Rules are interceptors which are executed for each test method and are important building
     * blocks of Junit tests.
     */
    @Rule @JvmField
    public val mNotesActivityTestRule = ActivityTestRule<NotesActivity>(NotesActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun clickAddNoteButton_opensAddNoteUi()  {
        // Click on the add note button
        onView(withId(R.id.fab_add_notes)).perform(click())

        // Check if the add note screen is displayed
        onView(withId(R.id.add_note_title)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun addNoteToNotesList() {
        val newNoteTitle = "Espresso Kotlin"
        val newNoteDescription = "UI testing for Android Kotlin"

        // click on the add note description
        onView(withId(R.id.fab_add_notes)).perform(click())

        // Add note title and description
        // Type new note title
        onView(withId(R.id.add_note_title)).perform(typeText(newNoteTitle), closeSoftKeyboard())
        onView(withId(R.id.add_note_description)).perform(typeText(newNoteDescription), closeSoftKeyboard())

        // Save the notes
        onView(withId(R.id.fab_add_notes)).perform(click())

        //scroll note list to added note, by finding its description
        onView(withId(R.id.notes_list)).perform(
                RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                        hasDescendant(withText(newNoteDescription))))

        // Verify note is displayed on screen
        onView(withItemText(newNoteDescription)).check(matches(isDisplayed()))

    }
}