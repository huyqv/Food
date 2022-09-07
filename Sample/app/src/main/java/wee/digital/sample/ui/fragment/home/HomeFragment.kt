package wee.digital.sample.ui.fragment.home

import android.view.View
import wee.digital.library.extension.toast
import wee.digital.sample.databinding.HomeBinding
import wee.digital.sample.ui.base.Inflating
import wee.digital.sample.ui.fragment.dialog.alert.showAlert
import wee.digital.sample.ui.fragment.dialog.selectable.Selectable
import wee.digital.sample.ui.fragment.dialog.selectable.showSelectable
import wee.digital.sample.ui.main.MainFragment

class HomeFragment : MainFragment<HomeBinding>() {

    private val homeVM by lazyViewModel(HomeVM::class)

    /**
     * [MainFragment] implements
     */
    override fun inflating(): Inflating = HomeBinding::inflate

    override fun onViewCreated() {
        addClickListener(vb.viewAlert, vb.viewSelectable)
    }

    override fun onLiveDataObserve() {

    }

    override fun onViewClick(v: View?) {
        when (v) {
            vb.viewAlert -> {
                showAlert {
                    title = "Custom alert dialog"
                    message = "You can dismiss by touch outside"
                    acceptOnClick = {
                        toast("you has been click accept")
                    }
                }
            }
            vb.viewSelectable -> {
                showSelectable {
                    title = "Sample selectable dialog"
                    message = "Please select once item below"
                    selectedItem = dialogVM.selectedItem(vb.viewSelectable.id)
                    itemList = listOf(
                        Selectable("foo", text = "Foo item"),
                        Selectable("bar", text = "Bar item")
                    )
                    onItemSelected = {
                        toast("${it.text} has been selected")
                    }
                }
            }
        }
    }

}