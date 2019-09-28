package com.example.periodtracker.services

import com.example.periodtracker.model.Cycle
import com.example.periodtracker.model.DailyInfo
import com.example.periodtracker.model.PeriodInfo
import java.time.LocalDate

object PeriodData {
    var cycleRecords = mutableListOf<Cycle>()
    var periodRecords = mutableListOf<DailyInfo>(
        DailyInfo(LocalDate.of(2019, 9, 17), PeriodInfo.Flow.HEAVY),
        DailyInfo(LocalDate.of(2019, 9, 18), PeriodInfo.Flow.NORMAL),
        DailyInfo(LocalDate.of(2019, 9, 19), PeriodInfo.Flow.NORMAL),
        DailyInfo(LocalDate.of(2019, 9, 20), PeriodInfo.Flow.NORMAL),
        DailyInfo(LocalDate.of(2019, 9, 21), PeriodInfo.Flow.LIGHT)

    )
}