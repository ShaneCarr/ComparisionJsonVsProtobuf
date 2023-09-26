package com.jersey.groups.repository;

import com.jersey.groups.models.Group;

import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface GroupDbo {

    @SqlUpdate("INSERT INTO public.group (name, officeid) VALUES (:name, :officeId)")
    void createGroup(@BindBean Group group);

    @SqlUpdate("UPDATE group SET name = :name, officeid = :officeId WHERE id = :id")
    void updateGroup(@BindBean Group groupDTO);

    @SqlQuery("SELECT * FROM group WHERE id = :id")
    Group getGroupById(long id);

    @SqlQuery("SELECT * FROM group")
    List<Group> getAllGroups();

    @SqlUpdate("DELETE FROM group WHERE id = :id")
    void deleteGroup(long id);

    // Add additional queries or updates as needed
}
