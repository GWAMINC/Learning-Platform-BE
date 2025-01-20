package chat_service.chat_service.migrations;

import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class V1__CreateChatCollections {
    @ChangeSet(order = "001", id = "createUsersCollection", author = "yourname")
    public void createUsersCollection(MongoDatabase db) {
        // Tạo collection "users" nếu chưa tồn tại
        db.createCollection("users");
    }

    @ChangeSet(order = "002", id = "createMessagesCollection", author = "yourname")
    public void createMessagesCollection(MongoDatabase db) {
        // Tạo collection "messages" nếu chưa tồn tại
        db.createCollection("messages");
    }

    @ChangeSet(order = "003", id = "createGroupsCollection", author = "yourname")
    public void createGroupsCollection(MongoDatabase db) {
        // Tạo collection "groups" nếu chưa tồn tại
        db.createCollection("groups");
    }

    @ChangeSet(order = "004", id = "createUserGroupsCollection", author = "yourname")
    public void createUserGroupsCollection(MongoDatabase db) {
        // Tạo collection "user_groups" nếu chưa tồn tại
        db.createCollection("user_groups");
    }

    @ChangeSet(order = "005", id = "insertSampleUser", author = "yourname")
    public void insertSampleUser(MongoDatabase db) {
        // Thêm dữ liệu mẫu vào collection "users"
        Document user = new Document("username", "john_doe")
                .append("email", "john.doe@example.com")
                .append("created_at", new java.util.Date());
        db.getCollection("users").insertOne(user);
    }
}
