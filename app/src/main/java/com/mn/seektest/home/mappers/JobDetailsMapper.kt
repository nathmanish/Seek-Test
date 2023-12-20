package com.mn.seektest.home.mappers

import com.mn.seektest.GetAllJobsQuery
import com.mn.seektest.JobDetailsQuery
import com.mn.seektest.Query

fun JobDetailsQuery.Job.toQueryJobDetails(): Query.Job {
    return Query.Job(
        _id = this._id,
        description = this.description,
        haveIApplied = this.haveIApplied,
        positionTitle = this.positionTitle,
        salaryRange = this.salaryRange?.toQuerySalaryRange()
    )
}

fun JobDetailsQuery.SalaryRange.toQuerySalaryRange(): Query.SalaryRange {
    return Query.SalaryRange(
        max = this.max,
        min = this.min,
    )
}

fun GetAllJobsQuery.Job.toQueryJobDetails(): Query.Job {
    return Query.Job(
        _id = this._id,
        description = this.description,
        haveIApplied = this.haveIApplied,
        positionTitle = this.positionTitle,
        salaryRange = this.salaryRange?.toQuerySalaryRange()
    )
}

fun GetAllJobsQuery.SalaryRange.toQuerySalaryRange(): Query.SalaryRange {
    return Query.SalaryRange(
        max = this.max,
        min = this.min,
    )
}