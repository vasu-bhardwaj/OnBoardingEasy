package com.fivemin.chief.easyonboarding.intro_activity;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.fivemin.chief.easyonboarding.R;
import com.fivemin.chief.easyonboarding.adapter.IntroAdapter;
import com.fivemin.chief.easyonboarding.pages_intro.IntroCards;
import com.fivemin.chief.easyonboarding.pages_intro.IntroFragment;

import java.util.ArrayList;
import java.util.List;

public class EasyOnBoarding extends AppCompatActivity implements
        ViewPager.OnPageChangeListener {
    private ImageView imgViewNext;
    private Button btnSkip;
    private ViewPager mViewPager;
    private IntroAdapter mIntroAdapter;
    private List<IntroFragment> pagesFragment;
    private Button btnFinish;
    private FrameLayout layoutNavigation;

    @Override
    public void onPageSelected(int position) {
        if (position == pagesFragment.size() - 1) {
            // fadeOut(circleIndicatorView);
            showFinish();
            fadeOut(layoutNavigation);
            //fadeIn(ivPrev);
        } else if (position == 0) {
            //fadeOut(ivPrev);
            fadeIn(layoutNavigation);
            hideFinish();
            // fadeIn(circleIndicatorView);
        } else {
            // fadeIn(circleIndicatorView);
            hideFinish();
            fadeIn(layoutNavigation);
            //fadeIn(ivNext);
        }

    }

    private void initListner() {
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupFinishButton();
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupSkipButton();
            }
        });


        imgViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            }
        });

    }


    /**
     * <pre>
     * Add custom skip button code, to your Intro
     * eg-> startActivity(new Intent(MainActivity.this, your.class));
     * </pre>
     */
    public void setupSkipButton() {
    }


    /**
     * Add code for the finish Button.
     * This button will be shown to user on the last Intro Slide
     * </pre>
     */
    public void setupFinishButton() {

    }


    /**
     * <pre>
     * Setup Gradient background for the all intro slide.
     *
     * When using setGradient,make sure you have set background of
     * each intro page as transparent.
     *</pre>
     * @param showGradient    is set to true, the gradient background will be displayed.
     * @param gradientListXML is the list of all the drawable gradient , in the resource folder
     */
    public void setGradient(Boolean showGradient, @DrawableRes int gradientListXML,int durationFadeIn,int durationFadeOut) {
        if (showGradient) {

            ImageView imageView = findViewById(R.id.gradient_background);
            imageView.setBackgroundResource(gradientListXML);
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
            imageView.setVisibility(View.VISIBLE);

            animationDrawable.setEnterFadeDuration(durationFadeIn);

            animationDrawable.setExitFadeDuration(durationFadeOut);

            animationDrawable.start();

        }
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.vp_pager);
        btnFinish = (Button) findViewById(R.id.btnStart);
        layoutNavigation = (FrameLayout) findViewById(R.id.layoutNavigation);
        imgViewNext = (ImageView) findViewById(R.id.ivNext);
        btnSkip = (Button) findViewById(R.id.btnSkip);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity__intro);
        initViews();
        initListner();
        mViewPager.addOnPageChangeListener(this);

        // mViewPager.setPageTransformer(true, new ParallaxPageTransformer());

        View decorView = getWindow().getDecorView();

        pagesFragment = new ArrayList<>();

    }


    /**
     * <pre>
     * Add intro cards.
     * Note-> Try to keep intro slides less than 5.
     * </pre>
     *
     * @param page The intro page to be added. ie IntroCards
     */
    public void addPage(IntroCards page) {
        pagesFragment.add(IntroFragment.newInstance(page));

        if (pagesFragment.size() > 5) {
            Log.w("Warning", "Don't use these many slides");
        }

    }


    public void setupIntro() {
        mIntroAdapter = new IntroAdapter(pagesFragment, getSupportFragmentManager());
        mViewPager.setAdapter(mIntroAdapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void fadeOut(View v) {
        fadeOut(v, true);
    }

    private void fadeOut(final View v, boolean delay) {

        long duration = 0;
        if (delay) {
            duration = 300;
        }

        if (v.getVisibility() != View.GONE) {
            Animation fadeOut = new AlphaAnimation(1, 0);
            fadeOut.setInterpolator(new AccelerateDecelerateInterpolator());
            fadeOut.setDuration(duration);
            fadeOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    v.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            v.startAnimation(fadeOut);
        }
    }

    private void fadeIn(final View v) {

        if (v.getVisibility() != View.VISIBLE) {
            Animation fadeIn = new AlphaAnimation(0, 1);
            fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
            fadeIn.setDuration(300);
            fadeIn.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    v.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            v.startAnimation(fadeIn);
        }
    }

    private void showFinish() {
        btnFinish.setVisibility(View.VISIBLE);
        this.btnFinish.animate().translationY(0 - dpToPixels(5, this)).setInterpolator(
                new DecelerateInterpolator()).setDuration(500).start();
    }

    private float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    private void hideFinish(boolean delay) {

        long duration = 0;
        if (delay) {
            duration = 250;
        }

        this.btnFinish.animate().translationY(
                this.btnFinish.getBottom() + dpToPixels(100, this)).setInterpolator(
                new AccelerateInterpolator()).setDuration(duration).setListener(
                new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                        btnFinish.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                }).start();
    }

    private void hideFinish() {
        hideFinish(true);
    }

}
