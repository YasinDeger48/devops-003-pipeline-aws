package com.yasindeger.integrationTest;

public class UserModel {
        private Long id;
        private String name;

        public UserModel(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

}
