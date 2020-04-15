CREATE DATABASE movies;
USE movies;

DROP TABLE movie_basic;
CREATE TABLE movie_basic (
movie_id INT PRIMARY KEY,
title VARCHAR(80),
year INT,
genres VARCHAR(160),
rating DOUBLE,
directors VARCHAR(160),
casts VARCHAR(255),
duration VARCHAR(20),
image TEXT,
countries VARCHAR(80),
tags VARCHAR(255),
summary TEXT
);
SELECT * FROM movies.movie_basic;

DROP TABLE movie_review;
CREATE TABLE movie_review (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
    movie_id INT,
    author_profile TEXT,
    author_name VARCHAR(40),
    review VARCHAR(255)
);
SELECT * FROM movies.movie_review;




