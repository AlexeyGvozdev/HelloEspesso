package sinx.com.helloespresso

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.Toolbar
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.InstrumentationRegistry



@RunWith(AndroidJUnit4::class)
class TitleActivityTest {
    @get:Rule
    val activityRule = ActivityTestRule(TitleActivity::class.java)

    @Test
    fun checkTitleBefore() {
        onView(isAssignableFrom(Toolbar::class.java)).check(matches(WithToolbarTitle(`is`(""))))
    }

    @Test
    fun checkChangeTitle() {
        onView(withId(R.id.btn_title)).perform(click())
        val resources = InstrumentationRegistry.getTargetContext().resources
        val title = resources.getString(R.string.title)
        onView(isAssignableFrom(Toolbar::class.java)).check(matches(WithToolbarTitle(`is`(title))))
    }
}