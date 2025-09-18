package com.user.user_app.repositaries;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.user.user_app.models.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}