package com.garikcarrot.browserfilter.data.models

import com.garikcarrot.browserfilter.entity.Filter

fun FilterDto.toEntity() = Filter(id, pattern, packageName, activityName)
fun Filter.toDto() =
    FilterDto(id, pattern, packageName, activityName)

fun List<FilterDto>.toEntity() = map { it.toEntity() }