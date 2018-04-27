package com.fivemin.chief.easyonboarding.transformer;

import android.view.View;

/**
 * Created by chief on 27/4/18.
 */

public class StackTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        view.setTranslationX(position < 0 ? 0f : -view.getWidth() * position);

    }
}