package com.app.focusonbinding

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    private var _sampleText = ObservableField("Sample Text at First")

    val getSampleText: ObservableField<String> = _sampleText

    fun changeSampleText() {
        _sampleText.set("Text updated from button in view model")
    }
}
