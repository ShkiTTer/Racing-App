package com.example.racingapp.domain.entity.result

import com.example.racingapp.domain.entity.user.Racer

class RacerResult(subject: Racer, place: Int, points: Int): Result<Racer>(subject, place, points)