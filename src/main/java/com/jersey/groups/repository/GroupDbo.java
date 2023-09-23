package com.jersey.groups.repository;

import com.jersey.groups.models.GroupDTO;
import org.jdbi.v3.sqlobject.statement.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface GroupDbo {

    @SqlUpdate("INSERT INTO group (name, officeid) VALUES (:name, :officeId)")
    void createGroup(@BindBean GroupDTO groupDTO);

    @SqlUpdate("UPDATE group SET name = :name, officeid = :officeId WHERE id = :id")
    void updateGroup(@BindBean GroupDTO groupDTO);

    @SqlQuery("SELECT * FROM group WHERE id = :id")
    GroupDTO getGroupById(long id);

    @SqlQuery("SELECT * FROM group")
    List<GroupDTO> getAllGroups();

    @SqlUpdate("DELETE FROM group WHERE id = :id")
    void deleteGroup(long id);

    // Add additional queries or updates as needed
}
