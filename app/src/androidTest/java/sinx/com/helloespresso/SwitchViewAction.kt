package sinx.com.helloespresso

import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.view.View
import android.widget.Checkable
import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.isA

class SwitchViewAction(private val checked: Boolean): ViewAction {
    override fun getDescription(): String = ""


    override fun getConstraints(): Matcher<View> = object : BaseMatcher<View>() {
        override fun describeTo(description: Description?) {}

        override fun matches(item: Any?) = isA(Checkable::class.java).matches(item)

    }
    override fun perform(uiController: UiController?, view: View?) {
        val checkableView = view as? Checkable
        checkableView?.isChecked = checked
    }
}