package com.example.android.testing.notes.addnote

import android.app.Activity
import android.app.Instrumentation
import android.provider.MediaStore
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.core.deps.guava.base.Predicates.not
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers.hasAction
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import com.example.android.testing.notes.R
import com.example.android.testing.notes.custom.matcher.ImageViewHasDrawableMatcher.hasDrawable
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by nutron on 10/10/17.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class AddNoteScreenTestKt {

    /**
     * {@link IntentsTestRule} is an {@link ActivityTestRule} which inits and releases Espresso
     * Intents before and after each test run.
     *
     * <p>
     * Rules are interceptors which are executed for each test method and are important building
     * blocks of Junit tests.
     */
    @Rule @JvmField
    val addNoteIntentsTestRule = IntentsTestRule(AddNoteActivity::class.java)

    /**
     * Prepare your test fixture for this test. In this case we register an IdlingResources with
     * Espresso. IdlingResource resource is a great way to tell Espresso when your app is in an
     * idle state. This helps Espresso to synchronize your test actions, which makes tests significantly
     * more reliable.
     */
    @Before
    fun registerIdlingResource() {
        Espresso.registerIdlingResources(addNoteIntentsTestRule.activity.countingIdlingResource)
    }

    /**
     * Unregister your Idling Resource so it can be garbage collected and does not leak any memory.
     */
    @After
    fun unregisterIdlingResource() {
        Espresso.unregisterIdlingResources(addNoteIntentsTestRule.activity.countingIdlingResource)
    }

    @Test
    fun addImageToNote_ShowsThumbnailInUi() {
        // Create an Activity Result which can be use to stub the camera Intent
        val result = createImageCaptureActivityResultStub()

        // If there is an Intent with ACTION_IMAGE_CAPTURE, intercept the Intent and response with
        // a stubbed result.
        Intents.intending(hasAction(MediaStore.ACTION_IMAGE_CAPTURE)).respondWith(result)

        // Check thumbnail view is not displayed
        onView(withId(R.id.add_note_image_thumbnail)).check(matches(Matchers.not(isDisplayed())))

        selectTakeImageFromMenu()

        // Check that the stubbed thumbnail is displayed in the UI
        onView(withId(R.id.add_note_image_thumbnail))
                .perform(scrollTo())  // Scroll to thumbnail
                .check(matches(allOf(
                        hasDrawable(), // Check ImageView has a drawable set with a custom matcher
                        isDisplayed())))
    }

    @Test
    fun errorShowOnEmptyMessage() {
        onView(withId(R.id.fab_add_notes)).perform(click())

        // Add note title and description
        onView(withId(R.id.add_note_title)).perform(typeText(""))
        onView(withId(R.id.add_note_description)).perform(typeText(""), closeSoftKeyboard())

        // Save the note
        onView(withId(R.id.fab_add_notes)).perform(click())

        // Verify empty notes snackbar is shown
        val emptyNoteMessageText = InstrumentationRegistry
                .getTargetContext().getString(R.string.empty_note_message)
        onView(withText(emptyNoteMessageText)).check(matches(isDisplayed()))

    }

    /**
     * Convenience method which opens the options menu and select the take image option.
     */
    private fun selectTakeImageFromMenu() {
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getContext())

        // Click on add picture option
        onView(withText(R.string.take_picture)).perform(click())
    }

    private fun createImageCaptureActivityResultStub(): Instrumentation.ActivityResult {
        // Create the ActivityResult, with a null Intent since we do not want to return any data
        // back to the Activity.
        return Instrumentation.ActivityResult(Activity.RESULT_OK, null)
    }
}