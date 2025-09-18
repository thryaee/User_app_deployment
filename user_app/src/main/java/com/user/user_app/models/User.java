package com.user.user_app.models;

import org.springframework.data.annotation.Id;

// import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

        @Id
        private String userId;
        @Size(min = 3, message = "Name should have at least 3 characters")
        private String userName;
        @Pattern(regexp = "^[6789][0-9]{9}$", message = "Mobile number must be exactly 10 digits")
        private String mobileNum;
        // @Email(message = "Email should be valid")
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email should be valid")
        private String userEmail;
        @Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one digit, and one special character")
        private String userPassword;

        public User() {
        }
        public User(String userId, String userName, String mobileNum, String userEmail, String userPassword) {
            this.userId = userId;
            this.userName = userName;
            this.mobileNum = mobileNum;
            this.userEmail = userEmail;
            this.userPassword = userPassword;
        }
        public String getUserId() {
            return userId;
        }
        public void setUserId(String userId) {
            this.userId = userId;
        }
        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public String getMobileNum() {
            return mobileNum;
        }
        public void setMobileNum(String mobileNum) {
            this.mobileNum = mobileNum;
        }
        public String getUserEmail() {
            return userEmail;
        }
        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }
        public String getUserPassword() {
            return userPassword;
        }
        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }
        @Override
        public String toString() {
            return "User [userId=" + userId + ", userName=" + userName + ", mobileNum=" + mobileNum + ", userEmail="
                    + userEmail + ", userPassword=" + userPassword + "]";
        }

}