package com.fivemin.chief.easyonboarding.pages;


import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.fivemin.chief.easyonboarding.R;

/**
 * Where cards are made
 */

public class IntroCards {

    final static int colorDefault = android.R.color.white;
    final static int backgroundDefault = R.color.grey_600;


    @ColorRes
    private int titleColor = 0;
    @ColorRes
    private int descriptionColor = 0;

    @DrawableRes
    private int background = 0;

    private String title;
    private String description;

    @StringRes
    private int titleId;
    @StringRes
    private int descriptionId;

    public IntroCards(@NonNull String title, String description) {
        this.title = title;
        this.description = description;

    }

    public IntroCards(@NonNull @StringRes int title, @StringRes int description) {
        this.titleId = title;
        this.descriptionId = description;
    }

    // title color
    protected int getTitleColor() {

        if (this.titleColor == 0) {
            return colorDefault;
        }
        return titleColor;
    }

    /**
     * <pre>
     * Set title color for current IntroPage
     * eg-> setTitleColor(R.color.blue);
     * </pre>
     *
     * @param titleColor color for title
     */
    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    // description color
    protected int getDescriptionColor() {
        if (descriptionColor == 0) {
            return colorDefault;
        }
        return descriptionColor;
    }

    /**
     * <pre>
     * Set Description color for current IntroPage
     * eg-> setDescriptionColor(R.color.red);
     * </pre>
     *
     * @param descriptionColor color for Description
     */
    public void setDescriptionColor(int descriptionColor) {
        this.descriptionColor = descriptionColor;
    }

    // background
    protected int getBackground() {
        if (background == 0) {
            return backgroundDefault;
        }
        return background;
    }

    /**
     * <pre>
     *      Set background for current intro page
     *      eg-> setBackground(R.drawable.mybackground)
     *  </pre>
     *
     * @param background Drawable for current page background
     */
    public void setBackground(@DrawableRes int background) {
        this.background = background;
    }

    // title String
    protected String getTitle() {
        return title;
    }

    // description String
    protected String getDescription() {
        return description;
    }

    // title int resource
    protected int getTitleId() {
        return titleId;
    }

    // description int resource
    protected int getDescriptionId() {
        return descriptionId;
    }


}
