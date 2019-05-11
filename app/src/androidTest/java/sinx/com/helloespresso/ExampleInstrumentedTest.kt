package sinx.com.helloespresso

import android.support.annotation.ColorInt
import android.support.annotation.StringRes
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("sinx.com.helloespresso", appContext.packageName)
    }

    @Test
    fun on_button_one_click() {
        onView(withId(R.id.btn_set_one)).perform(click())
        checkTextView(R.string.one)
    }

    @Test
    fun on_button_two_click() {
        onView(withId(R.id.btn_set_two)).perform(click())
        checkTextView(R.string.two)
    }

    @Test
    fun on_button_three_click() {
        onView(withId(R.id.btn_set_three)).perform(click())
        checkTextView(R.string.three)
    }

    @Test
    fun on_button_clear_click() {
        onView(withId(R.id.btn_clear)).perform(click())
        checkTextView(R.string.clear)
    }

    @Test
    fun on_switch_left() {
        onView(withId(R.id.switch_view)).perform(SwitchViewAction(true))
        checkTextColor(android.R.color.holo_red_dark)
    }

    @Test
    fun on_switch_right() {
        onView(withId(R.id.switch_view)).perform(SwitchViewAction(false))
        checkTextColor(android.R.color.holo_blue_dark)
    }

    private fun checkTextView(@StringRes res: Int) {
        onView(withId(R.id.tv_result)).check(matches(withText(res)))
    }

    private fun checkTextColor(@ColorInt color: Int) {
        onView(withId(R.id.tv_result)).check(matches(hasTextColor(color)))
    }
}
