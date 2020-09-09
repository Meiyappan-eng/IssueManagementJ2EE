package com.vinaylogics.issuemanagement.doa.repository;

import com.vinaylogics.issuemanagement.doa.core.BaseDao;
import com.vinaylogics.issuemanagement.doa.models.Issue;
import com.vinaylogics.issuemanagement.doa.utils.QueryConstant;

public interface IssueRepository extends BaseDao<Issue,Long>, QueryConstant.IssuesTable {
}
