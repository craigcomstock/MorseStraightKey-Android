package com.savanto.morsekeyboard;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;


public class MorseKeyboardView extends KeyboardView {
    public MorseKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setPreviewEnabled(false);
    }

    @Override
    protected boolean onLongPress(Keyboard.Key key) {
        switch (key.codes[0]) {
        case MorseKeyboard.KEYCODE_SIGNAL:
            ((MorseKeyboardInputMethodService) this.getOnKeyboardActionListener()).onLongKey(
                    MorseKeyboard.KEYCODE_DAH);
            break;
        case MorseKeyboard.KEYCODE_GAP:
            ((MorseKeyboardInputMethodService) this.getOnKeyboardActionListener()).onLongKey(
                    MorseKeyboard.KEYCODE_MEDIUM_GAP);
            break;
        }
        return super.onLongPress(key);
    }
}
