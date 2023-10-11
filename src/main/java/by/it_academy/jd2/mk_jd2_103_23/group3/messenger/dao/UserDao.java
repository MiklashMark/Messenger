package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IUserDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDao implements IUserDao {

    private final String SAVE_ONE_USERS_IN_DB = "INSERT INTO messenger.users(\n" +
            "\tuser_id, login, password, firstname, lastname, birthday, registrationdate, isadministrator)\n" +
            "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    private final String GET_ALL_USERS = "SELECT user_id, login, password, firstname, lastname, birthday, registrationdate, isadministrator\n" +
            "\tFROM messenger.users;";

    private final DataSource dataSource;

    public UserDao (DataSource dataSource){
        this.dataSource = dataSource;
    }


    @Override
    public void save(User user) {
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement stm = conn.prepareStatement(SAVE_ONE_USERS_IN_DB);)
            {
                UUID id = UUID.randomUUID();
                stm.setObject(1, id);
                stm.setString(2, user.getLogin());
                stm.setString(3, user.getPassword());
                stm.setString(4, user.getFirstName());
                stm.setString(5, user.getLastName());
                stm.setBoolean(8, user.isAdministrator());

                stm.setObject(6, user.getBirthDay());
                stm.setObject(7, user.getRegistrationDate());

                stm.execute();

            } catch (SQLException e) {
                throw new IllegalStateException("error saving user", e);
            }
        }

    @Override
    public List<User> getUsers() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stm = conn.prepareStatement(GET_ALL_USERS);
             ResultSet rs = stm.executeQuery();)
        {
            List <User> data = new ArrayList<>();
            while (rs.next()){

                User item = new User();
                item.setLogin(rs.getString("login"));
                item.setPassword(rs.getString("password"));
                item.setFirstName(rs.getString("firstname"));
                item.setLastName(rs.getString("lastname"));
                item.setBirthDay(rs.getTimestamp("birthday").toLocalDateTime().toLocalDate());
                item.setAdministrator(rs.getBoolean("isadministrator"));
                item.setRegistrationDate(rs.getTimestamp("registrationdate").toLocalDateTime());

                data.add(item);
            }
            return data;
        } catch (SQLException e) {
            throw new IllegalStateException("Error getting user information",e);
        }
    }
}