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

package com.example.android.testing.notes.notes;

import com.example.android.testing.notes.data.Note;
import com.example.android.testing.notes.data.NotesRepository;
import com.example.android.testing.notes.data.NotesRepository.LoadNotesCallback;
import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.fail;

/**
 * Unit tests for the implementation of {@link NotesPresenter}
 */
public class NotesPresenterTest {

    private static List<Note> NOTES = Lists.newArrayList(new Note("Title1", "Description1"),
            new Note("Title2", "Description2"));

    private static List<Note> EMPTY_NOTES = new ArrayList<>(0);

    @Mock
    private NotesRepository mNotesRepository;

    @Mock
    private NotesContract.View mNotesView;

    /**
     * {@link ArgumentCaptor} is a powerful Mockito API to capture argument values and use them to
     * perform further actions or assertions on them.
     */
    @Captor
    private ArgumentCaptor<LoadNotesCallback> mLoadNotesCallbackCaptor;

    private NotesPresenter mNotesPresenter;

    @Before
    public void setupNotesPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mNotesPresenter = new NotesPresenter(mNotesRepository, mNotesView);
    }


    @Test
    public void clickOnFab_ShowsAddsNoteUi() {
        fail("Not Implement yet");
        // TODO: When adding a new note

        // TODO: Then verify add note UI is shown
    }

    @Test
    public void clickOnNote_ShowsDetailUi() {
        fail("Not Implement yet");
        // Given a stubbed note by creating mock object
        Note requestedNote = new Note("Details Requested", "For this note");

        // TODO: When open note details is requested

        // TODO: Then verify detail UI is shown
    }

    @Test
    public void loadNotesFromRepositoryAndLoadIntoView() {
        fail("Not Implement yet");
        // TODO: When loading of Notes is requested

        // TODO: Callback is captured and invoked with stubbed notes --> trigger callback

        // TODO: Then progress indicator is hidden and notes are shown in UI
    }
}
