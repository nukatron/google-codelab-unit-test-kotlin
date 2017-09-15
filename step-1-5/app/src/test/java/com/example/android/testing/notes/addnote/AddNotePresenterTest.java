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

import com.example.android.testing.notes.data.Note;
import com.example.android.testing.notes.data.NotesRepository;
import com.example.android.testing.notes.util.ImageFile;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Verifier;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static junit.framework.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the implementation of {@link AddNotePresenter}.
 */
public class AddNotePresenterTest {

    // TODO: mock data here
    @Mock
    private NotesRepository mNoteRepository;
    @Mock
    private AddNoteContract.View mAddNoteView;
    @Mock
    private ImageFile mImageFile;

    private AddNotePresenter mAddNotesPresenter;

    @Before
    public void setupAddNotePresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // TODO: init AddNotePresenter here
        // Get a reference to the class under test
        mAddNotesPresenter = new AddNotePresenter(mNoteRepository, mAddNoteView, mImageFile);
    }

    @Test
    public void saveNoteToRepository_showsSuccessMessageUi() {
        // showcase we want to stub some method return (need add else case in if image.Exist())
        when(mImageFile.exists()).thenReturn(true);

        // TODO: When the presenter is asked to save a note (just uncomment)
        mAddNotesPresenter.saveNote("New Note Title", "Some Note Description");

        // TODO: Then verify the saveNote in repository is called and show Note List is shown in the UI
        verify(mImageFile).getPath();
        verify(mAddNoteView, never()).showEmptyNoteError();
        verify(mNoteRepository).saveNote(any(Note.class));
        verify(mAddNoteView).showNotesList();
    }

    @Test
    public void saveNote_emptyNoteShowsErrorUi() {
        // create an condition
        doReturn(true).when(mImageFile).exists();

        // TODO: When the presenter is asked to save an empty note (just uncomment)
        mAddNotesPresenter.saveNote("", "");

        // TODO: Then an empty not error is shown in the UI
        verify(mImageFile).getPath();
        verify(mAddNoteView).showEmptyNoteError();
    }

    @Test
    public void takePicture_CreatesFileAndOpensCamera() throws IOException {
        // TODO: When the presenter is asked to take an image
        mAddNotesPresenter.takePicture();

        // TODO: Then an image file is created and camera is opened
        // TODO: verify imageFile.create() is called
        verify(mImageFile).create(anyString(), anyString());

        // TODO: verify imageFile.getPath() is called
        verify(mImageFile).getPath();

        // TODO: verify view call to open camera
        verify(mAddNoteView).openCamera(anyString());
    }

    @Test
    public void imageAvailable_SavesImageAndUpdatesUiWithThumbnail() {
        // Given an a stubbed image file
        String imageUrl = "path/to/file";
        // TODO: stub method calling here (just uncomment)
        when(mImageFile.exists()).thenReturn(true);
        when(mImageFile.getPath()).thenReturn(imageUrl);

        // TODO: When an image is made available to the presenter -> call imageAvailable
        mAddNotesPresenter.imageAvailable();

        // TODO: Then the preview image of the stubbed image is shown in the UI
        verify(mAddNoteView).showImagePreview(anyString());
    }

    @Test
    public void imageAvailable_FileDoesNotExistShowsErrorUi() {
        // TODO: Given the image file does not exist -> add `when`
        when(mImageFile.exists()).thenReturn(false);

        // TODO: When an image is made available to the presenter -> call imageAvailable
        mAddNotesPresenter.imageAvailable();

        // TODO: Then an error is shown in the UI and the image file is deleted
        verify(mImageFile).delete();
        verify(mAddNoteView).showImageError();
    }

    @Test
    public void noImageAvailable_ShowsErrorUi() {
        // TODO: When the presenter is notified that image capturing failed -> call imageCaptureFailed
        mAddNotesPresenter.imageCaptureFailed();

        // TODO: Then an error is shown in the UI and the image file is deleted
        verify(mImageFile).delete();
        verify(mAddNoteView).showImageError();
    }

}
