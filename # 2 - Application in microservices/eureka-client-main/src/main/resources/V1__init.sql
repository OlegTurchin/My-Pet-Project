CREATE SCHEMA IF NOT EXISTS boot;
SET SEARCH_PATH TO boot;

DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS products (id SERIAL NOT NULL UNIQUE PRIMARY KEY , title VARCHAR(50) NOT NULL, price INT NOT NULL, count SMALLINT DEFAULT 0);

INSERT INTO products (title, price) VALUES ('Currants', 13);
INSERT INTO products (title, price) VALUES ('Mushroom - Portebello', 50);
INSERT INTO products (title, price) VALUES ('Clams - Canned', 81);
INSERT INTO products (title, price) VALUES ('Appetizer - Assorted Box', 85);
INSERT INTO products (title, price) VALUES ('Rum - Spiced, Captain Morgan', 8);
INSERT INTO products (title, price) VALUES ('Wine - White, Pelee Island', 23);
INSERT INTO products (title, price) VALUES ('Wine - Lamancha Do Crianza', 83);
INSERT INTO products (title, price) VALUES ('Galliano', 14);
INSERT INTO products (title, price) VALUES ('Fish - Base, Bouillion', 60);
INSERT INTO products (title, price) VALUES ('Wine - Jafflin Bourgongone', 75);
INSERT INTO products (title, price) VALUES ('Plastic Wrap', 16);
INSERT INTO products (title, price) VALUES ('Rosemary - Dry', 29);
INSERT INTO products (title, price) VALUES ('Wine - Cava Aria Estate Brut', 15);
INSERT INTO products (title, price) VALUES ('Creme De Banane - Marie', 80);
INSERT INTO products (title, price) VALUES ('Ham - Proscuitto', 89);
INSERT INTO products (title, price) VALUES ('Marjoram - Dried, Rubbed', 75);
INSERT INTO products (title, price) VALUES ('Tarragon - Fresh', 25);
INSERT INTO products (title, price) VALUES ('Quail - Eggs, Fresh', 75);
INSERT INTO products (title, price) VALUES ('Wine - Chablis 2003 Champs', 99);
INSERT INTO products (title, price) VALUES ('Corn Syrup', 68);
INSERT INTO products (title, price) VALUES ('Cookies Almond Hazelnut', 77);
INSERT INTO products (title, price) VALUES ('Beef - Ground Medium', 65);
INSERT INTO products (title, price) VALUES ('Ecolab Digiclean Mild Fm', 50);
INSERT INTO products (title, price) VALUES ('Wonton Wrappers', 34);
INSERT INTO products (title, price) VALUES ('Stainless Steel Cleaner Vision', 92);
INSERT INTO products (title, price) VALUES ('Chocolate - Milk', 100);
INSERT INTO products (title, price) VALUES ('Soup - Boston Clam Chowder', 88);
INSERT INTO products (title, price) VALUES ('Chilli Paste, Hot Sambal Oelek', 67);
INSERT INTO products (title, price) VALUES ('Tomato - Tricolor Cherry', 92);
INSERT INTO products (title, price) VALUES ('Wine - Redchard Merritt', 47);
INSERT INTO products (title, price) VALUES ('Sorrel - Fresh', 19);
INSERT INTO products (title, price) VALUES ('Milk - 2%', 28);
INSERT INTO products (title, price) VALUES ('Bay Leaf Ground', 14);
INSERT INTO products (title, price) VALUES ('Curry Powder Madras', 59);
INSERT INTO products (title, price) VALUES ('Milk - Chocolate 250 Ml', 19);
INSERT INTO products (title, price) VALUES ('Pepper - Orange', 57);
INSERT INTO products (title, price) VALUES ('Mushroom Morel Fresh', 64);
INSERT INTO products (title, price) VALUES ('Broom - Angled', 70);
INSERT INTO products (title, price) VALUES ('Lettuce - Frisee', 62);
INSERT INTO products (title, price) VALUES ('Shrimp - Black Tiger 13/15', 43);
INSERT INTO products (title, price) VALUES ('Mix - Cappucino Cocktail', 91);
INSERT INTO products (title, price) VALUES ('Pasta - Penne, Rigate, Dry', 27);
INSERT INTO products (title, price) VALUES ('Cheese - Gouda', 67);
INSERT INTO products (title, price) VALUES ('Veal - Inside, Choice', 33);
INSERT INTO products (title, price) VALUES ('Peas Snow', 44);
INSERT INTO products (title, price) VALUES ('Beans - Wax', 15);
INSERT INTO products (title, price) VALUES ('Hot Choc Vending', 38);
INSERT INTO products (title, price) VALUES ('Beer - Blue Light', 40);
INSERT INTO products (title, price) VALUES ('Sugar - Icing', 55);
INSERT INTO products (title, price) VALUES ('Cream - 18%', 44);
INSERT INTO products (title, price) VALUES ('Cookies - Englishbay Chochip', 70);
INSERT INTO products (title, price) VALUES ('Soy Protein', 80);
INSERT INTO products (title, price) VALUES ('Sponge Cake Mix - Chocolate', 14);
INSERT INTO products (title, price) VALUES ('Cheese - Cheddar, Medium', 12);
INSERT INTO products (title, price) VALUES ('Vinegar - Champagne', 4);
INSERT INTO products (title, price) VALUES ('Wine - Cousino Macul Antiguas', 82);
INSERT INTO products (title, price) VALUES ('Tomatoes - Orange', 26);
INSERT INTO products (title, price) VALUES ('Ecolab - Hand Soap Form Antibac', 48);
INSERT INTO products (title, price) VALUES ('Curry Paste - Madras', 32);
INSERT INTO products (title, price) VALUES ('Soup - Campbells Chili Veg', 100);
INSERT INTO products (title, price) VALUES ('Jolt Cola - Electric Blue', 23);
INSERT INTO products (title, price) VALUES ('Wine - Magnotta - Bel Paese White', 16);
INSERT INTO products (title, price) VALUES ('Mushroom - Morel Frozen', 44);
INSERT INTO products (title, price) VALUES ('Lamb Tenderloin Nz Fr', 12);
INSERT INTO products (title, price) VALUES ('Beef - Ox Tail, Frozen', 24);
INSERT INTO products (title, price) VALUES ('Asparagus - White, Canned', 42);
INSERT INTO products (title, price) VALUES ('Sorrel - Fresh', 41);
INSERT INTO products (title, price) VALUES ('Longos - Lasagna Beef', 39);
INSERT INTO products (title, price) VALUES ('Chips Potato Reg 43g', 96);
INSERT INTO products (title, price) VALUES ('Beef - Montreal Smoked Brisket', 38);
INSERT INTO products (title, price) VALUES ('Soup Campbells Turkey Veg.', 15);
INSERT INTO products (title, price) VALUES ('Kippers - Smoked', 81);
INSERT INTO products (title, price) VALUES ('Puree - Strawberry', 42);
INSERT INTO products (title, price) VALUES ('Dc Hikiage Hira Huba', 4);
INSERT INTO products (title, price) VALUES ('Turkey - Breast, Double', 5);
INSERT INTO products (title, price) VALUES ('Mace', 58);
INSERT INTO products (title, price) VALUES ('Sugar - Invert', 7);
INSERT INTO products (title, price) VALUES ('Mushroom - White Button', 65);
INSERT INTO products (title, price) VALUES ('Puree - Raspberry', 4);
INSERT INTO products (title, price) VALUES ('Eggplant - Regular', 30);
INSERT INTO products (title, price) VALUES ('Pork - Tenderloin, Frozen', 24);
INSERT INTO products (title, price) VALUES ('Wine - Red, Cooking', 50);
INSERT INTO products (title, price) VALUES ('Pepper - Black, Ground', 60);
INSERT INTO products (title, price) VALUES ('Bagel - Everything', 98);
INSERT INTO products (title, price) VALUES ('Hersey Shakes', 7);
INSERT INTO products (title, price) VALUES ('Sauce - Caesar Dressing', 79);
INSERT INTO products (title, price) VALUES ('Savory', 52);
INSERT INTO products (title, price) VALUES ('Smirnoff Green Apple Twist', 25);
INSERT INTO products (title, price) VALUES ('Squid - Breaded', 92);
INSERT INTO products (title, price) VALUES ('Lobster - Baby, Boiled', 57);
INSERT INTO products (title, price) VALUES ('Asparagus - White, Fresh', 94);
INSERT INTO products (title, price) VALUES ('Fudge - Chocolate Fudge', 7);
INSERT INTO products (title, price) VALUES ('Mix - Cocktail Strawberry Daiquiri', 100);
INSERT INTO products (title, price) VALUES ('Cheese - Victor Et Berthold', 46);
INSERT INTO products (title, price) VALUES ('Dasheen', 75);
INSERT INTO products (title, price) VALUES ('Ham - Cooked', 91);
INSERT INTO products (title, price) VALUES ('Sultanas', 50);
INSERT INTO products (title, price) VALUES ('Tomato Paste', 59);
INSERT INTO products (title, price) VALUES ('Vinegar - White Wine', 6);
INSERT INTO products (title, price) VALUES ('Pepper - Black, Crushed', 78);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE IF NOT EXISTS users (id SERIAL NOT NULL UNIQUE PRIMARY KEY, username VARCHAR(50) NOT NULL UNIQUE, password VARCHAR(100) NOT NULL,
                    first_name VARCHAR(50) NOT NULL, last_name VARCHAR(50) NOT NULL, email VARCHAR(50) NOT NULL , phone VARCHAR(50));

INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('rmar0', '$2a$10$mGMRPJWq4bkMKrz1a9CtWuRrRuYU3WiB0kAM2BzWy92b6XLu9laRW', 'Rahel', 'Mar', 'rmar0@slashdot.org', NULL);
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('rviney1', '$2a$10$V1AvMpV1y0kyz./9/sEGTe6KB8W6k4jBmmgvVMNmpo480PjyTTqwm', 'Ravi', 'Viney', 'rviney1@ihg.com', '+358 (416) 455-0308');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('sjanak2', '$2a$10$QaL4T.Qfc1HeJMv3frzor..Djmo7M3Meki0Hw4udM/k4BEWZ86/ce', 'Salvador', 'Janak', 'sjanak2@dion.ne.jp', '+62 (124) 543-2801');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('nmanvell3', '$2a$10$rzO70dMiRD4Yrn.ugzrqgOPyI/YXQctRJPg8Fxhh0JizUaDczLAf.', 'Nathaniel', 'Manvell', 'nmanvell3@ning.com', NULL);
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('nwilcockes4', '$2a$10$dt5aW9DkbjM5hZ6nLQYd0eYqG./REtsklefp9Zme1DHV4JwnuZ6VK', 'Nolly', 'Wilcockes', 'nwilcockes4@storify.com', '+86 (735) 776-6466');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('lhannond5', '$2a$10$wK7AKsK2rVlOo/.sfFPnve7DXrpQxwaEqz82U1pkyzprDOg9CyDeO', 'Llewellyn', 'Hannond', 'lhannond5@wix.com', NULL);
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('lthornhill6', '$2a$10$b04zTiBuzuSiqQmUHvX/zOHDQTe8sIWzsofpR1YT55WFSdatb059K', 'Laurella', 'Thornhill', 'lthornhill6@yellowpages.com', '+55 (932) 499-3395');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('mbroinlich7', '$2a$10$98CQUr9z61h43MtE/HMtfOkbB4wc13GDEFSGAAOzOY1W5/eg4XymG', 'Modestine', 'Broinlich', 'mbroinlich7@nyu.edu', '+86 (610) 239-6408');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('vcrafts8', '$2a$10$lVgZpcK4DA6if0dGEsD9luFUvpZMaoYmbdBTKcQqnO4otlB0aq8iK', 'Vail', 'Crafts', 'vcrafts8@hibu.com', '+351 (142) 220-7325');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('nquilter9', '$2a$10$UKF59auVC.BeQBUS9SBoR.tMPr2cs5Gz4CLAYyI9g6n37V7GAaV/i', 'Nye', 'Quilter', 'nquilter9@macromedia.com', '+375 (791) 613-3590');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('gdavydochkina', '$2a$10$OhFxfyPmZxLPf39xr5/ny.cX2Pf257Mw8P4mkAAMnIloEp5AGOBCu', 'Granville', 'Davydochkin', 'gdavydochkina@technorati.com', '+86 (811) 264-6765');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('cgreaserb', '$2a$10$1TV6YozMMSXrbAgxByLzz.qbMjKH9d7jkcz/7f.xoIiKzFmaA/xOm', 'Cathee', 'Greaser', 'cgreaserb@printfriendly.com', '+30 (579) 595-6748');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('bburchardc', '$2a$10$A824okt/pDhlMjAdq.Ir1ek78L55r9Udk27iAQKhoR5t6c7uMQRQC', 'Bev', 'Burchard', 'bburchardc@accuweather.com', NULL);
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('nmaccheyned', '$2a$10$QepmsEwFq.87v2xM1sA/WOR8UO4kp.Rpl5EQ9uijAvmVJ7BkMMUf.', 'Nana', 'MacCheyne', 'nmaccheyned@acquirethisname.com', '+46 (983) 978-4621');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('hfishendene', '$2a$10$MDNg1r/QV.9.8fO.m8Of/eSGMeXzyKpGsNVXxyIySxBqgHlkJ8dqC', 'Hercule', 'Fishenden', 'hfishendene@soup.io', '+86 (147) 356-7534');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('aronaldsonf', '$2a$10$2ibUhj5HJUYdSpP.dHBWsekID.R9RMNbmuxaYFgcV0mmP4ko8vAPi', 'Audry', 'Ronaldson', 'aronaldsonf@sourceforge.net', '+251 (853) 544-3913');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('jblinderg', '$2a$10$kOqRsmgoYx.RPsokxAXBxefriAFgpPuU16IVbhgloGCl8r5olILhi', 'Jeth', 'Blinder', 'jblinderg@theglobeandmail.com', '+63 (275) 852-0267');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('losemanh', '$2a$10$GhkyWxFVUFS7koKKLne9Ye6/IuXr5gvjacCvSWxt4h1CLEc8joO.K', 'Lida', 'Oseman', 'losemanh@utexas.edu', '+962 (948) 854-0067');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('apalfremani', '$2a$10$xjT4zCEXbosMVky5PnMxKOcTjkPLO31HfFmBytR36seNWPeX4AC5e', 'Archibald', 'Palfreman', 'apalfremani@theatlantic.com', '+502 (598) 474-5441');
INSERT INTO users (username, password, first_name, last_name, email, phone)
VALUES ('oosullivanj', '$2a$10$at9w4./YpMO1xTXNzWU0ueTFPIKhA/y3USniaQDaPTx3IWrGlgR.m', 'Ora', 'O Sullivan', 'oosullivanj@photobucket.com', '+351 (495) 115-5064');
-- VALUES ('oosullivanj', 'w6uwh9y', 'Ora', 'O Sullivan', 'oosullivanj@photobucket.com', '+351 (495) 115-5064');

DROP TABLE IF EXISTS roles CASCADE;
CREATE TABLE IF NOT EXISTS roles (id SERIAL NOT NULL UNIQUE PRIMARY KEY, name VARCHAR(50) NOT NULL UNIQUE);

INSERT INTO roles (name) VALUES ('ROLE_ADMINISTRATOR');
INSERT INTO roles (name) VALUES ('ROLE_MANAGER');
INSERT INTO roles (name) VALUES ('ROLE_BASIC_USER');

DROP TABLE IF EXISTS users_roles CASCADE;
CREATE TABLE IF NOT EXISTS users_roles (user_id INTEGER NOT NULL, role_id INTEGER NOT NULL, PRIMARY KEY (user_id, role_id),
                    CONSTRAINT FK_USER_ID FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
                    CONSTRAINT FK_ROLE_ID FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE NO ACTION ON UPDATE NO ACTION);

INSERT INTO users_roles (user_id, role_id) VALUES (20, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (20, 2);

-- select * from users;
-- select * from users where id = 20;
-- select * from users_roles join users on users_roles.user_id = users.id;