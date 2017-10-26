package rest.dao.entities;

import rest.dto.entities.UserDTO;
import rest.stubdb.UserStubDB;

import java.util.List;


public class UserDAOImpl implements UserDAO<UserDTO>
{
    @Override
    public List<UserDTO> get()
    {
        return UserStubDB.get();
    }

    @Override
    public UserDTO get(Long id)
    {
        return UserStubDB.get(id);
    }

    @Override
    public UserDTO add(UserDTO entity) throws Exception
    {
        UserDTO dto = UserStubDB.get(entity.getId());

        if (dto != null) {
            throw new Exception("cannot add user with id " + entity.getId() + ": already exists!");
        }

        return UserStubDB.add(entity);
    }

    @Override
    public UserDTO update(UserDTO entity) throws Exception
    {
        UserDTO dto = UserStubDB.get(entity.getId());

        if (dto == null) {
            throw new Exception("cannot update user with id " + entity.getId() + ": does not exists!");
        }

        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDateOfBirth(entity.getDateOfBirth());

        return dto;
    }

    @Override
    public boolean delete(Long id) throws Exception
    {
        UserDTO dto = UserStubDB.get(id);

        if (dto == null) {
            throw new Exception("cannot delete user with id " + id + ": does not exists!");
        }

        UserStubDB.remove(id);

        return true;
    }
}
