package maduna.fz.vayaviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.airbnb.lottie.LottieAnimationView;

public class Splash extends AppCompatActivity {

    private static final int TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        LottieAnimationView vayaViaLogo = findViewById(R.id.vayaViaLogo);
        ProgressBar progressBar = findViewById(R.id.idPBLoading);

        vayaViaLogo.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // Animation has ended, navigate to the main activity
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Optional: add a loading progress callback
        vayaViaLogo.addAnimatorUpdateListener(animation -> {
            // Do something based on the animation progress (e.g., show/hide progress bar)
            float progress = animation.getAnimatedFraction();
            if (progress == 1.0f) {
                // Animation is complete, hide the progress bar
                progressBar.setVisibility(View.GONE);
            } else {
                // Animation is still in progress, show the progress bar
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        // Optional: Start the Lottie animation
        vayaViaLogo.playAnimation();
    }
}