INSERT INTO app_users (name, email, password) VALUES
('Aarav Sharma', 'aarav@gmail.com', 'Password'),
('Ishita Patel', 'ishita@gmail.com', 'Password123'),
('Vivaan Mehta', 'vivaan.mehta@gmail.com', 'SecurePass'),
('Diya Kapoor', 'diya.kapoor@gmail.com', 'Pass!@34'),
('Rohan Verma', 'rohan.verma@gmail.com', 'Rohan2023'),
('Nisha Gupta', 'nisha.gupta@gmail.com', 'Nisha$Pass'),
('Kabir Rao', 'kabir.rao@gmail.com', 'KabirR!2024'),
('Ananya Sen', 'ananya.sen@gmail.com', 'AnanyaSen456'),
('Dev Singh', 'dev.singh@gmail.com', 'DevSecure001'),
('Priya Desai', 'priya.desai@gmail.com', 'Priya@Desai'),
('Aryan Chauhan', 'aryan.chauhan@gmail.com', 'AryanC@1'),
('Ria Bhatt', 'ria.bhatt@gmail.com', 'Ria!2024'),
('Krishna Reddy', 'krishna.reddy@gmail.com', 'Krishna123'),
('Maya Nair', 'maya.nair@gmail.com', 'Maya%Nair'),
('Rehan Malik', 'rehan.malik@gmail.com', 'RehanM@567'),
('Meera Sinha', 'meera.sinha@gmail.com', 'Meera987'),
('Kunal Aggarwal', 'kunal.aggarwal@gmail.com', 'KunalAgg123'),
('Sana Khan', 'sana.khan@gmail.com', 'Sana@2024'),
('Aditya Joshi', 'aditya.joshi@gmail.com', 'Aditya@Joshi'),
('Shreya Anand', 'shreya.anand@gmail.com', 'Shreya$Anand');

INSERT INTO user_roles (user_id, roles) VALUES
(1, 'RIDER'),
(2, 'RIDER'),
(2, 'DRIVER');

INSERT INTO rider(id, user_id, rating) VALUES
(1,1,4.9);

INSERT INTO driver (id, user_id, rating, available, current_location) VALUES
(2,2,4.7,true,ST_GeomFromText('POINT(77.1025 28.7041)',4326))