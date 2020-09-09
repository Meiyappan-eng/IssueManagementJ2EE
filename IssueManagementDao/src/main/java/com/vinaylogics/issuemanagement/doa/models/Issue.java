package com.vinaylogics.issuemanagement.doa.models;

import java.util.Objects;

public class Issue extends BaseModel {

    private String issue;
    private String description;
    private IssueStatus status = IssueStatus.CREATE;
    private boolean fixed;
    private Long userId;

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Issue issue1 = (Issue) o;
        return fixed == issue1.fixed &&
                Objects.equals(issue, issue1.issue) &&
                Objects.equals(description, issue1.description) &&
                status == issue1.status &&
                Objects.equals(userId, issue1.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), issue, description, status, fixed, userId);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "base_model='"+super.toString()+'\''+
                "issue='" + issue + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", fixed=" + fixed +
                ", userId=" + userId +
                '}';
    }
}
