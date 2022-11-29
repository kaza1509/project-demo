CREATE DATABASE book_management
GO
USE book_management
GO

CREATE TABLE Book(
	book_id				INT				PRIMARY KEY IDENTITY(1, 1),
	book_name			NVARCHAR(50)	NOT NULL,
	author_name			NVARCHAR(50)	NOT NULL,
	publish_date		DATE			NOT NULL
)