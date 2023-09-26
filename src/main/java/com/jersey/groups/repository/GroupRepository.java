package com.jersey.groups.repository;


import com.jersey.groups.models.Group;

import java.util.List;

public class GroupRepository {

    GroupDbo groupDbo;

    public GroupRepository(GroupDbo groupDbo){
        this.groupDbo = groupDbo;
    }

    public void createGroup(Group group) {
        groupDbo.createGroup(group);
    }

    public void updateGroup(Group group) {
        groupDbo.updateGroup(group);
    }

    public Group getGroupById(long id){
        return groupDbo.getGroupById(id);
    }

    public List<Group> getAllGroups(){
        return groupDbo.getAllGroups();
    }

    public void deleteGroup(long id){
        groupDbo.deleteGroup(id);
    }
}
