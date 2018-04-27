package com.fivemin.chief.easyonboarding.transformer;

import android.view.View;

/**
 * Created by chief on 27/4/18.
 */

public class AccordionTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        view.setPivotX(position < 0 ? 0 : view.getWidth());
        view.setScaleX(position < 0 ? 1f + position : 1f - position);
    }

}