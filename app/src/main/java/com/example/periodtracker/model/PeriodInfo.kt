package com.example.periodtracker.model

class PeriodInfo(var flow: Flow) {
    enum class Flow {
        NORMAL,
        LIGHT,
        HEAVY,
        SPOTTING,
        NONE
    }
}