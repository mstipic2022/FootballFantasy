CREATE TABLE Player (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(50) NOT NULL,
                        position VARCHAR(50) NOT NULL,
                        team VARCHAR(50),
                        nationalteam VARCHAR(50),
                        dob DATE NOT NULL
);


INSERT INTO Player (name, position, team, nationalteam, dob) VALUES
    ('Luka Modric', 'CM', 'Real Madrid', 'Croatia', '2008-11-11'),
    ('Lionel Messi', 'RW', 'Inter Miami', 'Argentina', '2008-11-11'),
    ('Cristiano Ronaldo', 'ST', 'Al Nasser', 'Portugal', '2008-11-11');

