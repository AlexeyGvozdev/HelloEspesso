package sinx.com.helloespresso

import android.support.test.espresso.matcher.BoundedMatcher
import android.support.v7.widget.Toolbar
import org.hamcrest.Description
import org.hamcrest.Matcher

class WithToolbarTitle(private val matcher: Matcher<CharSequence>) :
    BoundedMatcher<Any, Toolbar>(Toolbar::class.java) {
    override fun describeTo(description: Description?) {
        description?.appendText("with toolbar title ")
        matcher.describeTo(description)
    }

    override fun matchesSafely(item: Toolbar?): Boolean {
        return item?.run {
            matcher.matches(title)
        } ?: false
    }

}