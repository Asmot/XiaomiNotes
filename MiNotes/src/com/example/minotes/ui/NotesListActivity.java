package com.example.minotes.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.minotes.R;

public class NotesListActivity extends Activity implements OnClickListener{
	
	private Button mAddNewNote;
	
	
	private final static int REQUEST_CODE_OPEN_NODE = 102;
    private final static int REQUEST_CODE_NEW_NODE  = 103;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list);
        initResources();

       
    }

    
    @Override
    protected void onStart() {
        super.onStart();
      
    }

    private void initResources() {
    	mAddNewNote = (Button) findViewById(R.id.btn_new_note);
    	mAddNewNote.setOnClickListener(this);
    }
    
    private void createNewNote() {
    	Intent intent = new Intent(this, NoteEditActivity.class);
    	startActivityForResult(intent, REQUEST_CODE_NEW_NODE);
    }

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.btn_new_note:
			createNewNote();
			break;

		default:
			break;
		}
	}

}
