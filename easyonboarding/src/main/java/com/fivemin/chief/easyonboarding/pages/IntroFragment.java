package com.fivemin.chief.easyonboarding.pages;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fivemin.chief.easyonboarding.R;

/**
 * Created by chief on 4/4/18.
 */

public class IntroFragment extends Fragment {

    public static String INTRO_PAGE_TITLE_RES_ID = "intro_title_res_id";
    public static String INTRO_PAGE_TITLE = "intro_title";
    public static String INTRO_PAGE_TITLE_COLOR = "intro_title_color";

    public static String INTRO_PAGE_DESCRIPTION_RES_ID = "intro_title_descrpition_id";
    public static String INTRO_PAGE_DESCRIPTION = "intro_title_descrpition";
    public static String INTRO_PAGE_DESCRIPTION_COLOR = "intro_title_descrpition_color";


    public static String INTRO_PAGE_BACKGROUND = "intro_background";


    private String title;
    @StringRes
    private int titleResId;

    private String description;
    @StringRes
    private int descriptionResId;

    @ColorRes
    private int titleColor;
    @ColorRes
    private int descriptionColor;

    @DrawableRes
    private int background;


    private View view;
    private TextView titleIntro;
    private TextView descriptionIntro;
    private ImageView imgBackground;

    // Empty Constructor for Fragment
    public IntroFragment() {
    }

    /*
    *   Here we are getting the fragment card Setting passed by the user
    *   and then bundling them with the Fragment instance
    *   These attributes are then fetched in OnCreateView method of Fragment, Fragment View is
    *   Created.
     */
    public static IntroFragment newInstance(IntroCards introCards) {
        Bundle bundleArgs = new Bundle();

        bundleArgs.putString(INTRO_PAGE_TITLE, introCards.getTitle());
        bundleArgs.putInt(INTRO_PAGE_TITLE_RES_ID, introCards.getTitleId());
        bundleArgs.putInt(INTRO_PAGE_TITLE_COLOR, introCards.getTitleColor());

        bundleArgs.putString(INTRO_PAGE_DESCRIPTION, introCards.getDescription());
        bundleArgs.putInt(INTRO_PAGE_DESCRIPTION_RES_ID, introCards.getDescriptionId());
        bundleArgs.putInt(INTRO_PAGE_DESCRIPTION_COLOR, introCards.getDescriptionColor());


        bundleArgs.putInt(INTRO_PAGE_BACKGROUND, introCards.getBackground());

        IntroFragment introFragment = new IntroFragment();

        introFragment.setArguments(bundleArgs);

        return introFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {


        // Inflating the view
        view = inflater.inflate(R.layout.layout_intro_fragment, container, false);
        getAttributes();
        initViews();
        setAttributes();
        return view;
    }

    private void setAttributes() {
        // set title
        if (title != null) {
            titleIntro.setText(title.toUpperCase());
        } else {
            titleIntro.setText(getResources().getText(titleResId).toString().toUpperCase());
        }

        // set description
        if (description != null) {
            descriptionIntro.setText(description.toUpperCase());
        } else {
            descriptionIntro.setText(getResources().getText(
                    descriptionResId).toString().toUpperCase());
        }

        titleIntro.setTextColor(getResources().getColor(titleColor));
        descriptionIntro.setTextColor(getResources().getColor(descriptionColor));

        imgBackground.setImageResource(background);

    }

    private void initViews() {
        titleIntro = view.findViewById(R.id.titleText);
        descriptionIntro = view.findViewById(R.id.descriptionText);
        imgBackground = view.findViewById(R.id.imgView_Background);
    }

    private void getAttributes() {
        Bundle bundle = getArguments();

        titleResId = bundle.getInt(INTRO_PAGE_TITLE_RES_ID, 0);
        title = bundle.getString(INTRO_PAGE_TITLE, null);
        titleColor = bundle.getInt(INTRO_PAGE_TITLE_COLOR, 0);

        description = bundle.getString(INTRO_PAGE_DESCRIPTION, null);
        descriptionResId = bundle.getInt(INTRO_PAGE_DESCRIPTION_RES_ID, 0);
        descriptionColor = bundle.getInt(INTRO_PAGE_DESCRIPTION_COLOR, 0);

        background = bundle.getInt(INTRO_PAGE_BACKGROUND, 0);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
