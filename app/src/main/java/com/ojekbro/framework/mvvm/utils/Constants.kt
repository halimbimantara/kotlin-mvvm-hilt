/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ojekbro.framework.mvvm.utils

import androidx.annotation.IntDef

/**
 * Constants used throughout the app.
 */
const val DATABASE_NAME = "sunflower-db"
const val PLANT_DATA_FILENAME = "plants.json"
const val API_VERSION = "1.0.0"
const val DB_VERSION = 1
const val NETWORK_TIMEOUT = 60L
const val ERROR_MESSAGE = "Cannot proceed your request, please try again later"
const val UPDATE_ERROR_MESSAGE = "Cannot get latest update"
const val DEFAULT_FONT = "fonts/GoogleSans-Regular.ttf"
object CacheKey {
    const val OVERVIEW = "cache_statistics"
    const val DAYS = "cache_days"
    const val CONFIRMED = "cache_confirmed"
    const val DEATH = "cache_death"
    const val RECOVERED = "cache_recovered"
    const val COUNTRY = "cache_country"
    const val FULL_STATS = "cache_full_details"
    const val PREF_COUNTRY = "cache_pref_country"
    const val PREF_USERNAME = "cache_pref_username"
    const val PREF_EMAIL = "cache_pref_email"
    const val PREF_NO_HP = "cache_pref_nohp"
}


@IntDef(CaseType.CONFIRMED, CaseType.DEATHS, CaseType.RECOVERED, CaseType.FULL)
@Retention(AnnotationRetention.SOURCE)
annotation class CaseTypes

object CaseType {
    const val CONFIRMED = 0
    const val DEATHS = 1
    const val RECOVERED = 2
    const val FULL = 3
}

object IncrementStatus {
    const val FLAT = 0
    const val INCREASE = 1
    const val DECREASE = 2
}