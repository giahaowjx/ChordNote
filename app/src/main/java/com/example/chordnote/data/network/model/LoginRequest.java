package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    private LoginRequest() {

    }

    public static class ServerLoginRequest {

        @Expose
        @SerializedName("email")
        private String email;

        @Expose
        @SerializedName("password")
        private String password;

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            ServerLoginRequest that = (ServerLoginRequest) object;

            if (email != null && that.email != null && !email.equals(that.email)) {
                return false;
            }
            if (password != null && that.password != null && password.equals(that.password)) {
                return true;
            }

            return false;
        }

        @Override
        public int hashCode() {
            int result;

            if (email != null) {
                result = email.hashCode();
            } else {
                result = 0;
            }

            result *= 31;

            if (password != null) {
                result += password.hashCode();
            }

            return result;
        }
    }

}
