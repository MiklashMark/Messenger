package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IMessageDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MessageDao implements IMessageDao {

    private final DataSource dataSource;

    public MessageDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addMessage(String login, Message message) {
        String INSERT_NEW_MESSAGE_QUERY = "insert into messenger.messages(message_id, " +
                "time, from_user, to_user, message)\n" +
                "values (?,?,?,?,?);";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_NEW_MESSAGE_QUERY)) {
            statement.setString(1, UUID.randomUUID().toString());
            statement.setTimestamp(2, Timestamp.valueOf(message.getTime()));
            statement.setString(3, getUUID(getUserByLogin(message.getFrom())));
            statement.setString(4, getUUID(getUserByLogin(message.getTo())));
            statement.setString(5, message.getMessage());
            statement.execute();
        } catch (Exception e) {
            throw new IllegalStateException("Error saving message", e);
        }
    }

    @Override
    public Map<User, List<Message>> getUsersMessages() {
        return null;
    }

    @Override
    public List<Message> getUserMessages(User user) {
        String SELECT_USER_MESSAGES_QUERY = "select message_id, time, from_user, to_user, message\n" +
                "from messenger.messages\n" +
                "where from_user = ?;";
        List<Message> messages = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_MESSAGES_QUERY)) {
            statement.setString(1, getUUID(user));

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Message message = new Message();
                    message.setFrom(resultSet.getString("from_user"));
                    message.setTo(resultSet.getString("to_user"));
                    message.setTime(resultSet.getTimestamp("time").toLocalDateTime());
                    message.setMessage(resultSet.getString("message"));

                    messages.add(message);
                }
            } catch (Exception e) {
                throw new IllegalStateException("Error receiving messages by user", e);
            }

        } catch (Exception e) {
            throw new IllegalStateException("Error receiving messages by user", e);
        }
        return messages;
    }

    @Override
    public void addUser(User user) {
        new UserDao(dataSource).save(user);
    }

    @Override
    public long getCount() {
        String SELECT_COUNT_MESSAGES_QUERY = "select count(message_id)\n" +
                "from messenger.messages;";
        int count = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_COUNT_MESSAGES_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (Exception e) {
            throw new IllegalStateException("Error getting count information", e);
        }
        return count;
    }

    private User getUserByLogin(String login) {
        String SELECT_USER_QUERY = "select user_id,\n" +
                "       login,\n" +
                "       password,\n" +
                "       firstname,\n" +
                "       lastname,\n" +
                "       birthday,\n" +
                "       registration_date,\n" +
                "       is_administrator\n" +
                "from messenger.users\n" +
                "where login = ?;";
        User user = new User();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_QUERY)) {
            statement.setString(1, login);
            statement.execute();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    user.setLogin(resultSet.getString("login"));
                    user.setPassword(resultSet.getString("password"));
                    user.setFirstName(resultSet.getString("firstname"));
                    user.setLastName(resultSet.getString("lastname"));
                    user.setBirthDay(resultSet.getDate("birthday").toLocalDate());
                    user.setRegistrationDate(resultSet.getTimestamp("registration_date").toLocalDateTime());
                    user.setAdministrator(resultSet.getBoolean("is_administrator"));
                }
            } catch (Exception e) {
                throw new IllegalStateException("Error getting user information", e);
            }

        } catch (Exception e) {
            throw new IllegalStateException("Error getting user information", e);
        }
        return user;
    }

    private String getUUID(User user) {
        String SELECT_UUID_BY_USER_QUERY = "select user_id\n" +
                "from messenger.users\n" +
                "where login = ?;";
        String uUID = "";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_UUID_BY_USER_QUERY)) {
            statement.setString(1, user.getLogin());
            statement.execute();

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    uUID = resultSet.getString("user_id");
                }
            } catch (Exception e) {
                throw new IllegalStateException("Error receiving UUID by user", e);
            }

        } catch (Exception e) {
            throw new IllegalStateException("Error receiving UUID by user", e);
        }
        System.out.println(uUID);
        return uUID;
    }

}
