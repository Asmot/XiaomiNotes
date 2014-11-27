package com.example.minotes.ui;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minotes.R;
import com.example.minotes.tool.ResourceParser;

public class NoteEditActivity extends Activity implements OnClickListener{

	private static final Map<Integer, Integer> sBgSelectorBtnsMap = new HashMap<Integer, Integer>();
    static {
        sBgSelectorBtnsMap.put(R.id.iv_bg_yellow, ResourceParser.YELLOW);
        sBgSelectorBtnsMap.put(R.id.iv_bg_red, ResourceParser.RED);
        sBgSelectorBtnsMap.put(R.id.iv_bg_blue, ResourceParser.BLUE);
        sBgSelectorBtnsMap.put(R.id.iv_bg_green, ResourceParser.GREEN);
        sBgSelectorBtnsMap.put(R.id.iv_bg_white, ResourceParser.WHITE);
    }

    private static final Map<Integer, Integer> sBgSelectorSelectionMap = new HashMap<Integer, Integer>();
    static {
        sBgSelectorSelectionMap.put(ResourceParser.YELLOW, R.id.iv_bg_yellow_select);
        sBgSelectorSelectionMap.put(ResourceParser.RED, R.id.iv_bg_red_select);
        sBgSelectorSelectionMap.put(ResourceParser.BLUE, R.id.iv_bg_blue_select);
        sBgSelectorSelectionMap.put(ResourceParser.GREEN, R.id.iv_bg_green_select);
        sBgSelectorSelectionMap.put(ResourceParser.WHITE, R.id.iv_bg_white_select);
    }

    private static final Map<Integer, Integer> sFontSizeBtnsMap = new HashMap<Integer, Integer>();
    static {
        sFontSizeBtnsMap.put(R.id.ll_font_large, ResourceParser.TEXT_LARGE);
        sFontSizeBtnsMap.put(R.id.ll_font_small, ResourceParser.TEXT_SMALL);
        sFontSizeBtnsMap.put(R.id.ll_font_normal, ResourceParser.TEXT_MEDIUM);
        sFontSizeBtnsMap.put(R.id.ll_font_super, ResourceParser.TEXT_SUPER);
    }

    private static final Map<Integer, Integer> sFontSelectorSelectionMap = new HashMap<Integer, Integer>();
    static {
        sFontSelectorSelectionMap.put(ResourceParser.TEXT_LARGE, R.id.iv_large_select);
        sFontSelectorSelectionMap.put(ResourceParser.TEXT_SMALL, R.id.iv_small_select);
        sFontSelectorSelectionMap.put(ResourceParser.TEXT_MEDIUM, R.id.iv_medium_select);
        sFontSelectorSelectionMap.put(ResourceParser.TEXT_SUPER, R.id.iv_super_select);
    }
	
	//head 
	private View mHeadViewPanel;
	private HeadViewHolder mNoteHeaderHolder;

    private View mNoteBgColorSelector;

    private View mFontSizeSelector;

    
 
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.note_edit);
		
		initResources();
	}
	
	
	private void initResources() {
		
		mHeadViewPanel = findViewById(R.id.note_title);
 
		mNoteHeaderHolder = new HeadViewHolder();
		mNoteHeaderHolder.tvModified = (TextView) findViewById(R.id.tv_modified_date);
		mNoteHeaderHolder.ivAlertIcon = (ImageView) findViewById(R.id.iv_alert_icon);
		mNoteHeaderHolder.tvAlertDate = (TextView) findViewById(R.id.tv_alert_date);
		mNoteHeaderHolder.ibSetBgColor = (ImageView) findViewById(R.id.btn_set_bg_color);
		mNoteHeaderHolder.ibSetBgColor.setOnClickListener(this);

		mNoteBgColorSelector = findViewById(R.id.note_bg_color_selector);
		for (int id : sBgSelectorBtnsMap.keySet()) {
			ImageView iv = (ImageView) findViewById(id);
			iv.setOnClickListener(this);
		}
	}
	
	public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_set_bg_color) {
            mNoteBgColorSelector.setVisibility(View.VISIBLE);
//            findViewById(sBgSelectorSelectionMap.get(mWorkingNote.getBgColorId())).setVisibility(
//                    -                    View.VISIBLE);
        } 
//        else if (sBgSelectorBtnsMap.containsKey(id)) {
//            findViewById(sBgSelectorSelectionMap.get(mWorkingNote.getBgColorId())).setVisibility(
//                    View.GONE);
//            mWorkingNote.setBgColorId(sBgSelectorBtnsMap.get(id));
//            mNoteBgColorSelector.setVisibility(View.GONE);
//        } else if (sFontSizeBtnsMap.containsKey(id)) {
//            findViewById(sFontSelectorSelectionMap.get(mFontSizeId)).setVisibility(View.GONE);
//            mFontSizeId = sFontSizeBtnsMap.get(id);
//            mSharedPrefs.edit().putInt(PREFERENCE_FONT_SIZE, mFontSizeId).commit();
//            findViewById(sFontSelectorSelectionMap.get(mFontSizeId)).setVisibility(View.VISIBLE);
//            if (mWorkingNote.getCheckListMode() == TextNote.MODE_CHECK_LIST) {
//                getWorkingText();
//                switchToListMode(mWorkingNote.getContent());
//            } else {
//                mNoteEditor.setTextAppearance(this,
//                        TextAppearanceResources.getTexAppearanceResource(mFontSizeId));
//            }
//            mFontSizeSelector.setVisibility(View.GONE);
//        }
    }
	

	private class HeadViewHolder {
        public TextView tvModified;
        public ImageView ivAlertIcon;
        public TextView tvAlertDate;
        public ImageView ibSetBgColor;
    }
}
