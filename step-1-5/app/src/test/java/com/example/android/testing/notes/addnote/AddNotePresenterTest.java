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

package com.example.android.testing.notes.addnote;

import com.example.android.testing.notes.data.NotesRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static junit.framework.Assert.fail;

/**
 * Unit tests for the implementation of {@link AddNotePresenter}.
 */
public class AddNotePresenterTest {

    // TODO: mock data here
    @Mock
    private NotesRepository mNoteRepository;

    private AddNotePresenter mAddNotesPresenter;

    @Before
    public void setupAddNotePresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // TODO: init AddNotePresenter here
        // Get a reference to the class under test
//        mAddNotesPresenter = new AddNotePresenter(mNotesRepository, mAddNoteView, mImageFile);
    }

    @Test
    public void saveNoteToRepository_showsSuccessMessageUi() {
        fail("Not Implement yet");
        // showcase we want to stub some method return (need add else case in if image.Exist())
//        when(mImageFile.exists()).thenReturn(true);

        // TODO: When the presenter is asked to save a note (just uncomment)
//        mAddNotesPresenter.saveNote("New Note Title", "Some Note Description");

        // TODO: Then verify the saveNote in repository is called and show Note List is shown in the UI
    }

    @Test
    public void saveNote_emptyNoteShowsErrorUi() {
        fail("Not Implement yet");
        // TODO: When the presenter is asked to save an empty note (just uncomment)
//        mAddNotesPresenter.saveNote("", "");

        // TODO: Then an empty not error is shown in the UI
    }

    @Test
    public void takePicture_CreatesFileAndOpensCamera() throws IOException {
        fail("Not Implement yet");
        // TODO: When the presenter is asked to take an image

        // TODO: Then an image file is created and camera is opened
        // TODO: verify imageFile.create() is called

        // TODO: verify imageFile.getPath() is called

        // TODO: verify view call to open camera
    }

    @Test
    public void imageAvailable_SavesImageAndUpdatesUiWithThumbnail() {
        fail("Not Implement yet");
        // Given an a stubbed image file
        String imageUrl = "path/to/file";
        // TODO: stub method calling here (just uncomment)
//        when(mImageFile.exists()).thenReturn(true);
//        when(mImageFile.getPath()).thenReturn(imageUrl);

        // TODO: When an image is made available to the presenter -> call imageAvailable

        // TODO: Then the preview image of the stubbed image is shown in the UI
    }

    @Test
    public void imageAvailable_FileDoesNotExistShowsErrorUi() {
        fail("Not Implement yet");
        // TODO: Given the image file does not exist -> add `when`

        // TODO: When an image is made available to the presenter -> call imageAvailable

        // TODO: Then an error is shown in the UI and the image file is deleted
    }

    @Test
    public void noImageAvailable_ShowsErrorUi() {
        fail("Not Implement yet");
        // TODO: When the presenter is notified that image capturing failed -> call imageCaptureFailed

        // TODO: Then an error is shown in the UI and the image file is deleted
    }

}
