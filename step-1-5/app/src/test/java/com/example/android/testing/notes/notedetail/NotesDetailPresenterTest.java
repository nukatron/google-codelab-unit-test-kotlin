/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.notes.notedetail;

import com.example.android.testing.notes.data.Note;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.fail;

/**
 * Unit tests for the implementation of {@link NoteDetailPresenter}
 */
public class NotesDetailPresenterTest {

    public static final String INVALID_ID = "INVALID_ID";

    public static final String TITLE_TEST = "title";

    public static final String DESCRIPTION_TEST = "description";

    //TODO: add mock data here

    //TODO: add argument captor here

    private NoteDetailPresenter mNotesDetailsPresenter;

    @Before
    public void setupNotesPresenter() {
        fail("Not Implement yet");
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        //TODO: init mNotesDetailsPresenter here
        // Get a reference to the class under test
//        mNotesDetailsPresenter = new NoteDetailPresenter(mNotesRepository, mNoteDetailView);
    }

    @Test
    public void getNoteFromRepositoryAndLoadIntoView() {
        fail("Not Implement yet");
        // Given an initialized NoteDetailPresenter with stubbed note
        Note note = new Note(TITLE_TEST, DESCRIPTION_TEST);

        //TODO: When notes presenter is asked to open a note

        //TODO: Then note is loaded from model, callback is captured and progress indicator is shown

        //TODO: When note is finally loaded --> Trigger callback

        //TODO: Then progress indicator is hidden and title and description are shown in UI
    }

    @Test
    public void getUnknownNoteFromRepositoryAndLoadIntoView() {
        fail("Not Implement yet");
        // TODO: When loading of a note is requested with an invalid note ID.

        // TODO: Then note with invalid id is attempted to load from model, callback is captured and
        // TODO: progress indicator is shown.

        // TODO: When note is finally loaded -->  Trigger callback

        // TODO: Then progress indicator is hidden and missing note UI is shown
    }
}
