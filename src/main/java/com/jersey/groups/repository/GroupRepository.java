package com.jersey.groups.repository;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.jersey.groups.models.Group;
import com.jersey.groups.repository.GroupDbo;

import java.util.List;

public class GroupRepository {

    GroupDbo groupDbo;

    public GroupRepository(GroupDbo groupDbo){
        this.groupDbo = groupDbo;
    }

    void createGroup(Group group) {

    }

    void updateGroup(Group group) {

    }

    Group getGroupById(long id){

    }

    List<Group> getAllGroups(){

    }

    void deleteGroup(long id){

    }

    // Add additional queries or updates as needed
}
