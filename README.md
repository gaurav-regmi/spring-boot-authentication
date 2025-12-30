# spring-boot-authentication
Developed a secure authentication and authorization system using Spring Boot and Spring Security, implementing JWT-based authentication to protect RESTful APIs. Integrated password encryption using BCrypt and implemented token validation, refresh, and expiration handling to ensure secure session management.

Add roles first after running the project:

INSERT INTO roles (id, name) VALUES (1, 'USER');
INSERT INTO roles (id, name) VALUES (2, 'ADMIN');
