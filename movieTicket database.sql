CREATE TABLE Users (
userID INT AUTO_INCRIMENT,
username VARCHAR(255),
Password VARCHAR(255),
Name VARCHAR(255),
phone VARCHAR(15),
Address VARCHAR(255),
PRIMARY KEY (UserID)
);

CREATE TABLE Admin (
AdminID INT AUTO_INCRIMENT,
username VARCHAR(255),
Password VARCHAR(255),
PRIMARY KEY (AdminID)
);

CREATE TABLE Theaters (
TheaterID INT AUTO_INCRIMENT,
Location VARCHAR(255),
SeatingCapacity VARCHAR(255),
PRIMARY KEY (TheaterID)
);

CREATE TABLE Movies (
MovieID INT AUTO_INCRIMENT,
Title VARCHAR(255),
Genre VARCHAR(255),
Rating DECIMAL(3,2),
Duration INT, 
Synopsis TEXT,
PRIMARY KEY (MovieID)
);

CREATE TABLE Showtimes (
ShowtimeID INT AUTO_INCRIMENT,
MovieID INT,
TheaterID INT,
Showtime DATETIME,
PRIMARY KEY (ShowtimeID),
FOREIGN KEY (MovieID) REFERENCES Movies(MovieID),
FOREIGN KEY (TheaterID) REFERENCES Theaters(TheaterID)
);

CFREATE TABLE Bookings(
BookingID INT AUTO_INCRIMENT,
UserID INT,
ShowtimeId INT,
PaymentStatus BOOLEAN,
primary KEY (BookingID),
FOREIGN KEY (UserID) REFERENCES Users(UserID),
FOREIGN KEY (ShowtimeID) REFERENCES Showtimes(ShowtimeID)
);