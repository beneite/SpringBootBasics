-- Create database if it does not exist
CREATE DATABASE IF NOT EXISTS userManagementDb;
USE userManagementDb;

-- Create users table
CREATE TABLE IF NOT EXISTS usersTable (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    userFirstName VARCHAR(20) NOT NULL,
    userLastName VARCHAR(20) NOT NULL,
    userEmail VARCHAR(60) NOT NULL UNIQUE
);

-- Insert sample users
INSERT INTO usersTable (userEmail, userFirstName, userLastName) VALUES
('Aditya.Mishra@gmail.com', 'Aditya', 'Mishra'),
('Umang.Kamal@yopmail.com', 'Umang', 'Kamal'),
('Mukesh.Rathod@yopmail.com', 'Mukesh', 'Rathod');
