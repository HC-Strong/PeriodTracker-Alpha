package com.example.periodtracker.model

// first day of period or last day of prev cycle
// making this basically a mutable version of LocalDate which is immutable

class P0 (var year: Int, var month : Int, var dayOfMonth : Int) {}