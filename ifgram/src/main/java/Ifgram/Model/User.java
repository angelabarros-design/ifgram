package Ifgram.Model;

import jakarta.persistence.*;

    @Entity
    @Table(name = "usuarios")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false, length = 120)
        private String nome;

        @Column(nullable = false, unique = true)
        public String email;

        public User(String nome, String email) {
            this.nome = nome;
            this.email = email;
        }

        public long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public String getnome() {
            return nome;
        }
    }

