package dev.guvenx.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;

import java.util.List;

@ApplicationScoped
public class UserRepository {

    private final DynamoDbTable<User> userTable;
    private static final String TABLE_NAME = "Users";

    @Inject
    public UserRepository(DynamoDbEnhancedClient enhancedClient) {
        this.userTable = enhancedClient.table(TABLE_NAME, TableSchema.fromBean(User.class));
    }

    public void saveUser(User user) {
        userTable.putItem(user);
    }

    public User getUserById(String userId) {
        Key key = Key.builder()
                .partitionValue(userId)
                .build();
        return userTable.getItem(key);
    }

    public List<User> getAllUsers() {
        PageIterable<User> results = userTable.scan();
        return results.items().stream().toList();
    }

    public User updateUser(User user) {
        return userTable.updateItem(user);
    }

    public void deleteUser(String userId) {
        Key key = Key.builder()
                .partitionValue(userId)
                .build();
        userTable.deleteItem(key);
    }

    public boolean exists(String userId) {
        return getUserById(userId) != null;
    }

}
