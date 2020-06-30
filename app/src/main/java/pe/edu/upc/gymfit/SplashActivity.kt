package pe.edu.upc.gymfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintSet.WRAP_CONTENT
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_splash.*
import pe.edu.upc.gymfit.splash.IntroSlide
import pe.edu.upc.gymfit.splash.IntroSliderAdapter
import pe.edu.upc.gymfit.ui.auth.AuthActivity

class SplashActivity : AppCompatActivity() {

    private val introSlideAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Fuerza y Motivo x2",
                "Tener fuerza de voluntad y mucha energia para nuestro gimnasio.",
                R.drawable.img01
            ),
            IntroSlide(
                "Trainers",
                "Todos clientes tienen a sus trainers para sus debidos entrenamientos.",
                R.drawable.img02
            ),
            IntroSlide(
                "Nutrición",
                "Nosotros te indicamos y mejoramos la nutrición para que este en forma y bien alimentado.",
                R.drawable.img03
            ),
            IntroSlide(
                "Verse Bien",
                "Siempre debemos vernos bien y estar en forma. Nosotros nos encargaremos de darte buenos tips.",
                R.drawable.img04
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        introSliderViewPager.adapter = introSlideAdapter
        setupIndicator()
        setCurrentIndicator(0)
        introSliderViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        buttonNext.setOnClickListener {
            if(introSliderViewPager.currentItem + 1 < introSlideAdapter.itemCount){
                introSliderViewPager.currentItem += 1
            }
            else{
                Intent(applicationContext, AuthActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
        textSkipIntro.setOnClickListener {
            Intent(applicationContext, AuthActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
    private fun hideSystemUI() {
        val decorView = window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }
    private fun setupIndicator(){
        val  indicators = arrayOfNulls<ImageView>(introSlideAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)

        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                     ContextCompat.getDrawable(
                         applicationContext,
                         R.drawable.indicator_inactive
                     )
                )
                this?.layoutParams = layoutParams
            }
            indicatorsContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int){
        val childCount = indicatorsContainer.childCount
        for(i in 0  until childCount){
            val imageView  = indicatorsContainer[i] as ImageView
            if(i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }
            else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}
